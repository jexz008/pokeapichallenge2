/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;

/**
 *
 * @author Joel Corona
 */
public class Detail implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonView(value = PokeapichallengeViews.Combined.class)
    private String field;

    @JsonView(value = PokeapichallengeViews.Combined.class)
    private String detail;

    /**
     * 
     * @return 
     */
    public String getField() {
        return field;
    }

    /**
     * 
     * @param field 
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 
     * @return 
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 
     * @param detail 
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }


    @Override
    public String toString() {
        return "Detail{"
                + "field='" + field + '\''
                + ", detail='" + detail + '\''
                + '}';
    }    
}
