/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.ws;

import com.jci.pokeapichallenge.controller.PokeapichallengeController;
import com.jci.pokeapichallenge.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jci.pokeapichallenge.producing_web_service.Pokemon;
import com.jci.pokeapichallenge.producing_web_service.PokemonAbility;
import com.jci.pokeapichallenge.producing_web_service.PokemonHeldItem;


import com.jci.pokeapichallenge.producing_web_service.GetPokemonRequest;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonResponse;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonAbilitiesRequest;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonAbilitiesResponse;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonBaseExperienceRequest;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonBaseExperienceResponse;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonHeldItemsResponse;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonHeldItemsRequest;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonIdResponse;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonIdRequest;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonNameResponse;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonNameRequest;

import com.jci.pokeapichallenge.producing_web_service.GetPokemonLocationAreaEncountersResponse;
import com.jci.pokeapichallenge.producing_web_service.GetPokemonLocationAreaEncountersRequest;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.spi.http.HttpExchange;

/**
 *
 * @author Joel Corona
 */
@Endpoint
public class PokemonEndpoint {
	private static final String NAMESPACE_URI = "http://jci.com/pokeapichallenge/producing-web-service";

	private PokemonRepository pokemonRepository;
        
@Autowired
private HttpServletRequest request;

        @Autowired
        PokeapichallengeController pokeapichallengeController;        

	@Autowired
	public PokemonEndpoint(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
	@ResponsePayload
	public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
            
		GetPokemonResponse response = new GetPokemonResponse();         
                response.setPokemon(pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "all", this.getIpAddress()));
		//MOK:response.setPokemon(pokemonRepository.findPokemon(request.getPokemonName()));

		return response;
	}
        
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonAbilitiesRequest")
	@ResponsePayload
	public GetPokemonAbilitiesResponse getPokemonAbilitiesRequest(@RequestPayload GetPokemonAbilitiesRequest request) {
                GetPokemonAbilitiesResponse response = new GetPokemonAbilitiesResponse();
                Pokemon pokemon = pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "abilities", this.getIpAddress());
                for (PokemonAbility pa : pokemon.getAbilities()) {
                    response.getAbilities().add(pa);                    
                }
		return response;
	}
        
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonBaseExperienceRequest")
	@ResponsePayload
	public GetPokemonBaseExperienceResponse getPokemonBaseExperienceRequest(@RequestPayload GetPokemonBaseExperienceRequest request) {
                GetPokemonBaseExperienceResponse response = new GetPokemonBaseExperienceResponse();
                response.setBaseExperience(pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "base_experience", this.getIpAddress()).getBaseExperience());

		return response;
	}     
            
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonHeldItemsRequest")
	@ResponsePayload
	public GetPokemonHeldItemsResponse getPokemonHeldItemsRequest(@RequestPayload GetPokemonHeldItemsRequest request) {
                GetPokemonHeldItemsResponse response = new GetPokemonHeldItemsResponse();
                Pokemon pokemon = pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "held_items", this.getIpAddress());
                for (PokemonHeldItem pHI : pokemon.getHeldItems()) {
                    response.getPokemonHeldItems().add(pHI);                    
                }
		return response;
	}        

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonIdRequest")
	@ResponsePayload
	public GetPokemonIdResponse getPokemonIdRequest(@RequestPayload GetPokemonIdRequest request) {
                GetPokemonIdResponse response = new GetPokemonIdResponse();
                response.setId(pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "id", this.getIpAddress()).getId());

		return response;
	}     
        
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonNameRequest")
	@ResponsePayload
	public GetPokemonNameResponse getPokemonNameRequest(@RequestPayload GetPokemonNameRequest request) {
                GetPokemonNameResponse response = new GetPokemonNameResponse();
                response.setName(pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "name", this.getIpAddress()).getName());

		return response;
	}    
        
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonLocationAreaEncountersRequest")
	@ResponsePayload
	public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncountersRequest(@RequestPayload GetPokemonLocationAreaEncountersRequest request) {
                GetPokemonLocationAreaEncountersResponse response = new GetPokemonLocationAreaEncountersResponse();
                response.setLocationAreaEncounters(pokeapichallengeController.pokemonApiToPokemonWS(request.getPokemonName(), "location_area_encounters", this.getIpAddress()).getLocationAreaEncounters());

		return response;
	}            
        
    protected String getIpAddress() {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        System.out.println(ipAddress);
        return ipAddress;
    }      
    
    
}
