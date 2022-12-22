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
public class NamedAPIResource implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private String name;

    @JsonView (value = {PokeapichallengeViews.Combined.class})
    private String url;

    /**
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
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "NamedAPIResource{"
                + "name='" + name + '\''
                + ", url=" + url
                + '}';
    }    
}
