/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Joel Corona
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePokeapichallenge implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    private String pokemonName;
    
    private String error;
    
    private LocalDateTime date;    
    
    
    
    private ResponsePokeapichallenge() {
    }
    
    /**
     * 
     * @param message 
     */
    private ResponsePokeapichallenge(final String message) {
        this.message = message;
    }    
    
    /**
     * 
     * @param message
     * @param pokemonName 
     */
    private ResponsePokeapichallenge(final String message, final String pokemonName) {
        this.message = message;
        this.pokemonName = pokemonName;
    }        

    /**
     * 
     * @param message
     * @param pokemonName
     * @param date 
     */
    private ResponsePokeapichallenge(final String message, final String pokemonName, final LocalDateTime date) {
        this.message = message;
        this.pokemonName = pokemonName;
        this.date = date;
    } 
    
    
    /**
     * 
     * @return 
     */
    public static ResponsePokeapichallenge empty() {
        return new ResponsePokeapichallenge();
    }        
    
    
    /**
     * 
     * @param message
     * @param pokemonName
     * @return 
     */
    public static ResponsePokeapichallenge of(final String message, final String pokemonName) {
        return new ResponsePokeapichallenge(message, pokemonName);
    }
    /**
     * 
     * @param message
     * @param pokemonName
     * @param date
     * @return 
     */
    public static ResponsePokeapichallenge of(final String message, final String pokemonName, final LocalDateTime date) {
        return new ResponsePokeapichallenge(message, pokemonName, date);
    }      
    
    /**
     * 
     * @param message
     * @return 
     */
    public static ResponsePokeapichallenge error(final String message) {
        ResponsePokeapichallenge responsePokeApiChallenge = new ResponsePokeapichallenge();
        responsePokeApiChallenge.setError(message);
        return responsePokeApiChallenge;
    }

    
    
    
    /**
     * 
     * @return 
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message 
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return 
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * 
     * @param pokemonName 
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * 
     * @return 
     */
    public String getError() {
        return error;
    }

    /**
     * 
     * @param error 
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 
     * @return 
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * 
     * @param date 
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
      
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ResponsePokeApiChallenge{"
                + "message='" + message + '\''
                + ", pokemonName='" + pokemonName + '\''
                + ", error='" + error + '\''
                + ", date='" + date 
                + '}';
    }    
}
