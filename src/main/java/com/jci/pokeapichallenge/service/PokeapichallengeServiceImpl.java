/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import com.jci.pokeapichallenge.domain.Pokemon;
//import com.jci.pokeapichallenge.producing_web_service.Pokemon;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Joel Corona
 */
@Service
public class PokeapichallengeServiceImpl implements PokeapichallengeService{    

    private static final Logger LOGGER = LoggerFactory.getLogger(PokeapichallengeServiceImpl.class);
   
    private static final String METADATA = "metadata";
    private static final String LOGA = "PACH -> ";

    @Autowired
    private RestTemplate restTemplate;
    
    
    @Value("${pokeapi.url.rest}")
    private String pokeapiEndpoint;     

    /**
     * 
     * @param pokemonName
     * @return 
     */
    @Override
    public Pokemon getPokeapichallgengeInfo (String pokemonName) {
        LOGGER.info(String.format(LOGA+"Service: Getting Pokemon Info, pokemon name: %s", pokemonName));
        
        ResponseEntity<Pokemon> response;
        Pokemon pokemon;
        try {
            
            response = this.restTemplate.exchange(this.getUrl(String.join("", "pokemon/", pokemonName), Boolean.FALSE),
                        HttpMethod.GET, 
                        //null,
                        new HttpEntity<>(this.createHeaders()),
                        Pokemon.class);            

            pokemon = (response.hasBody() && Objects.nonNull(response.getBody()))
                ? response.getBody() : null;

            //if (LOGGER.isDebugEnabled()) {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(pokemon);
                LOGGER.info("Pokemon found -> " + json);
            //}            

            
            return pokemon;
        } catch (RestClientException ex) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format(LOGA+"Could not get pokemon %s information for the following reason: {}", pokemonName), ex.getMessage(), ex);
            }
            LOGGER.error(ex.getMessage());            
            return null;
        } catch (Exception ex) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format(LOGA+"Could not get pokemon %s information for the following reason: {}", pokemonName), ex.getMessage(), ex);
            }
            LOGGER.error(ex.getMessage());            
            return null;
        }
    }
    
    /**
     * 
     * @param context
     * @param hasMetadata
     * @return 
     */
    private String getUrl(final String context, final boolean hasMetadata) {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(this.pokeapiEndpoint + context);
        if (hasMetadata) {
            uriComponentsBuilder.queryParam(METADATA, "{json}");
        }
        return uriComponentsBuilder.build().toString();
    }
    
    
    private HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {   
                /*String auth = String.join("", PokeapichallengeServiceImpl.this.pokeapiUser, ":",
                        PokeapichallengeServiceImpl.this.pokeapiPassword);
                 byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(StandardCharsets.UTF_8));
                 String authHeader = new StringBuilder("Basic").//BASIC).
                                        append(" ").
                                        append(new String(encodedAuth)).toString();
                set(HttpHeaders.AUTHORIZATION, authHeader);*/
                set("user-agent", "Application");
            }
        };
    }        
}
