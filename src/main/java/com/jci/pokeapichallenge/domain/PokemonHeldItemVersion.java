/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;

/**
 *
 * @author Joel Corona
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonHeldItemVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private NamedAPIResource version;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private Integer rarity;

    
    /**
     * 
     * @return 
     */
    public NamedAPIResource getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(NamedAPIResource version) {
        this.version = version;
    }

    /**
     * 
     * @return 
     */
    public Integer getRarity() {
        return rarity;
    }

    /**
     * 
     * @param rarity 
     */
    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PokemonHeldItemVersion{"
                + "version='" + version + '\''
                + ", rarity=" + rarity
                + '}';
    }   
    
}
