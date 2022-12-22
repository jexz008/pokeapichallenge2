/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.repository;

import com.jci.pokeapichallenge.producing_web_service.Pokemon;
//import io.spring.guides.gs_producing_web_service.Pokemon;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
/**
 *
 * @author Joel Corona
 */
@Component
public class PokemonRepository {
    private static final Map<String, Pokemon> pokemons = new HashMap<>();   

	@PostConstruct
	public void initData() {
		Pokemon pikachu = new Pokemon();
                pikachu.setName("pikachu");
                pikachu.setBaseExperience(112);
                pikachu.setId(25);
                pikachu.setLocationAreaEncounters("https://pokeapi.co/api/v2/pokemon/25/encounters");

		pokemons.put(pikachu.getName(), pikachu);

                pikachu.setName("pikachuTwo");
                pikachu.setBaseExperience(112);
                pikachu.setId(25);
                pikachu.setLocationAreaEncounters("https://pokeapi.co/api/v2/pokemon/25/encounters");
	}

	public Pokemon findPokemon(String name) {
		Assert.notNull(name, "The pokemon's name must not be null");
		return pokemons.get(name);
	}
}
