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
public class PokemonAbility implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private NamedAPIResource ability;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private Boolean is_hidden;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private Integer slot;
    

    /**
     * 
     * @return 
     */
    public NamedAPIResource getAbility() {
        return ability;
    }

    /**
     * 
     * @param ability 
     */
    public void setAbility(NamedAPIResource ability) {
        this.ability = ability;
    }

    /**
     * 
     * @return 
     */
    public Boolean getIs_hidden() {
        return is_hidden;
    }

    /**
     * 
     * @param is_hidden 
     */
    public void setIs_hidden(Boolean is_hidden) {
        this.is_hidden = is_hidden;
    }

    /**
     * 
     * @return 
     */
    public Integer getSlot() {
        return slot;
    }

    /**
     * 
     * @param slot 
     */
    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Abilities{"
                + "ability='" + ability + '\''
                + ", is_hidden=" + is_hidden + '\''
                + ", slot=" + slot
                + '}';
    }      
    
}
