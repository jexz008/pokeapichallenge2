/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Joel Corona
 */
@Document(collection = "pokeapichallengeLog")
@JsonRootName("pokeapichallengeLog")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokeapichallengeLog extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

   
    @JsonView (value = {PokeapichallengeViews.Internal.class})
    private String ipOrigen;
    
    @JsonView (value = {PokeapichallengeViews.Internal.class})
    private String metodo;

    /**
     * 
     * @return 
     */
    public String getIpOrigen() {
        return ipOrigen;
    }

    /**
     * 
     * @param ipOrigen 
     */
    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    /**
     * 
     * @return 
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * 
     * @param metodo 
     */
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "PokeapichallengeLog{"
                + "ipOrigen='" + ipOrigen + '\''
                + ", metodo=" + metodo 
                + '}';
    }       
    
}
