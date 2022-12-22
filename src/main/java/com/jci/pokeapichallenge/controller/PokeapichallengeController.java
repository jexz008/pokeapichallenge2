/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.controller;

import com.jci.pokeapichallenge.domain.Pokemon;
import com.jci.pokeapichallenge.domain.ResponsePokeapichallenge;
import com.jci.pokeapichallenge.domain.Error;
import com.jci.pokeapichallenge.domain.PokeapichallengeLog;
import com.jci.pokeapichallenge.domain.PokemonAbility;
import com.jci.pokeapichallenge.domain.PokemonHeldItem;
import com.jci.pokeapichallenge.domain.PokemonHeldItemVersion;
import com.jci.pokeapichallenge.repository.PokeapichallengeLogRepositry;
//import com.jci.pokeapichallenge.producing_web_service.Pokemon;
import com.jci.pokeapichallenge.service.PokeapichallengeService;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Joel Corona
 */
@Controller
public class PokeapichallengeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PokeapichallengeController.class);

    @Autowired
    private PokeapichallengeService pokeapichallengeService;    
    
    @Autowired
    private PokeapichallengeLogRepositry pokeapichallengeLogRepositry;
    
    /**
     * 
     * @param pokemonName
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{name}") 
    public ResponseEntity<?> pokemonInfo(
            @PathVariable(name = "name", required = true) final String pokemonName    
            //@RequestParam(name = "pokemonName", required = true) final String fechaFin                
    ) { 
        Pokemon pokemon;
        try {
            LOGGER.info(String.format("Starting process to obtain %s pokemon information.", pokemonName));
            pokemon = this.pokeapichallengeService.getPokeapichallgengeInfo(pokemonName);
            
            
            return ResponseEntity.ok(ResponsePokeapichallenge.of(String.format("Information of the %s pokemon obtained successfully", pokemonName), pokemonName, LocalDateTime.now() ));
        } catch (final Exception ex) {
            LOGGER.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Error.of(ex.getMessage()));
        }              
    } 


    
    /**
     * 
     * @param pokemonName
     * @param metodo
     * @param ip
     * @return 
     */
    public com.jci.pokeapichallenge.producing_web_service.Pokemon pokemonApiToPokemonWS (String pokemonName, String metodo, String ip) {
        LOGGER.info(String.format("Starting process to obtain %s pokemon information.", pokemonName));

        com.jci.pokeapichallenge.producing_web_service.Pokemon pokemon = new  com.jci.pokeapichallenge.producing_web_service.Pokemon();
        Pokemon pokemonInfo;
        PokeapichallengeLog pokeapichallengeLog;

        LOGGER.info("Saving the request in the database");
        pokeapichallengeLog = new PokeapichallengeLog();
        pokeapichallengeLog.setIpOrigen(ip);
        pokeapichallengeLog.setMetodo(metodo);
        pokeapichallengeLog.setCreationDate(LocalDateTime.now());
        this.pokeapichallengeLogRepositry.save(pokeapichallengeLog);

        
        LOGGER.info("Getting the information from the pokemon api");
        pokemonInfo = this.pokeapichallengeService.getPokeapichallgengeInfo(pokemonName);
        
        pokemon.setBaseExperience(pokemonInfo.getBase_experience());
        pokemon.setId(pokemonInfo.getId());
        pokemon.setLocationAreaEncounters(pokemonInfo.getLocation_area_encounters());
        pokemon.setName(pokemonInfo.getName());

        for (PokemonAbility pA : pokemonInfo.getAbilities() ) {
            com.jci.pokeapichallenge.producing_web_service.PokemonAbility pokemonAbility = new com.jci.pokeapichallenge.producing_web_service.PokemonAbility();
            com.jci.pokeapichallenge.producing_web_service.NamedAPIResource namedAPIResource = new com.jci.pokeapichallenge.producing_web_service.NamedAPIResource();
            namedAPIResource.setName(pA.getAbility().getName());
            namedAPIResource.setUrl(pA.getAbility().getUrl());
            pokemonAbility.setAbility(namedAPIResource);
            pokemonAbility.setIsHidden(pA.getIs_hidden());
            pokemonAbility.setSlot(pA.getSlot());
            
            pokemon.getAbilities().add(pokemonAbility);
        }
        
        for (PokemonHeldItem pHI : pokemonInfo.getHeld_items() ) {
            com.jci.pokeapichallenge.producing_web_service.PokemonHeldItem pokemonHeldItem = new com.jci.pokeapichallenge.producing_web_service.PokemonHeldItem();
            com.jci.pokeapichallenge.producing_web_service.NamedAPIResource namedAPIResource = new com.jci.pokeapichallenge.producing_web_service.NamedAPIResource();
            namedAPIResource.setName(pHI.getItem().getName());
            namedAPIResource.setUrl(pHI.getItem().getUrl());
            for (PokemonHeldItemVersion pHIV : pHI.getVersion_details()) {
                com.jci.pokeapichallenge.producing_web_service.PokemonHeldItemVersion pokemonHeldItemVersion = new com.jci.pokeapichallenge.producing_web_service.PokemonHeldItemVersion();
                com.jci.pokeapichallenge.producing_web_service.NamedAPIResource namedAPIResourceB = new com.jci.pokeapichallenge.producing_web_service.NamedAPIResource();
                namedAPIResourceB.setName(pHIV.getVersion().getName());
                namedAPIResourceB.setUrl(pHIV.getVersion().getUrl());
                pokemonHeldItemVersion.setRarity(pHIV.getRarity());
                pokemonHeldItemVersion.setVersion(namedAPIResourceB);
                
                pokemonHeldItem.setVersionDetails(pokemonHeldItemVersion);
            }
            
            pokemonHeldItem.setItem(namedAPIResource);
            pokemon.getHeldItems().add(pokemonHeldItem);
        }
        //pokemon.getHeldItems().add(pokemonInfo.getHeld_items());
        
        return pokemon;
    }
}
