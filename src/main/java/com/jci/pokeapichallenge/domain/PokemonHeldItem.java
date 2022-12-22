/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Joel Corona
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonHeldItem implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @JsonView (value = {PokeapichallengeViews.Combined.class})    
    private NamedAPIResource item;

    @JsonView (value = {PokeapichallengeViews.Combined.class})    
    private List<PokemonHeldItemVersion> version_details;

    
    /**
     * 
     * @return 
     */
    public NamedAPIResource getItem() {
        return item;
    }

    /**
     * 
     * @param item 
     */
    public void setItem(NamedAPIResource item) {
        this.item = item;
    }

    /**
     * 
     * @return 
     */
    public List<PokemonHeldItemVersion> getVersion_details() {
        return version_details;
    }

    /**
     * 
     * @param version_details 
     */
    public void setVersion_details(List<PokemonHeldItemVersion> version_details) {
        this.version_details = version_details;
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PokemonHeldItem{"
                + "item='" + item + '\''
                + ", version_details=" + version_details
                + '}';
    }       
}
