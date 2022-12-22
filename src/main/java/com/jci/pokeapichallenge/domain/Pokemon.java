/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Joel Corona
 */
//@Document(collection = "pokeapichallenge")
@JsonRootName("pokemon")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pokemon {//extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private List<PokemonAbility> abilities;
    
    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private Integer base_experience;
    
    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private List<PokemonHeldItem> held_items;
    
    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private Integer id;
    
    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private String name;
    
    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private String location_area_encounters;

    
    /**
     * 
     * @return 
     */
    public List<PokemonAbility> getAbilities() {
        return abilities;
    }

    /**
     * 
     * @param abilities 
     */
    public void setAbilities(List<PokemonAbility> abilities) {
        this.abilities = abilities;
    }

    /**
     * 
     * @return 
     */
    public Integer getBase_experience() {
        return base_experience;
    }

    /**
     * 
     * @param base_experience 
     */
    public void setBase_experience(Integer base_experience) {
        this.base_experience = base_experience;
    }

    /**
     * 
     * @return 
     */
    public List<PokemonHeldItem> getHeld_items() {
        return held_items;
    }

    /**
     * 
     * @param held_items 
     */
    public void setHeld_items(List<PokemonHeldItem> held_items) {
        this.held_items = held_items;
    }

    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /***
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    /**
     * 
     * @param location_area_encounters 
     */
    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    
    

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Pokemon{"
                + "abilities='" + abilities + '\''
                + ", base_experience=" + base_experience + '\''
                + ", held_items=" + held_items + '\''
                + ", id=" + id + '\''
                + ", name=" + name + '\''
                + ", location_area_encounters=" + location_area_encounters
                + '}';
    }      
    
}
