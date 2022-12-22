package com.jci.pokeapichallenge.service;

import com.jci.pokeapichallenge.domain.Pokemon;
//import com.jci.pokeapichallenge.producing_web_service.Pokemon;

/**
 *
 * @author Joel Corona
 */
public interface PokeapichallengeService {
    /**
     * 
     * @param pokemonName
     * @return 
     */
    public Pokemon getPokeapichallgengeInfo (String pokemonName);    
}