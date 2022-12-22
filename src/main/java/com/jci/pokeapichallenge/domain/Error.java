/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Joel Corona
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Detail> details;
    
    
    /**
     *
     */
    public Error() {
    }


    /**
     * 
     * @param message 
     */
    public Error(final String message) {
        this.message = message;
    }

    /**
     *
     * @param message
     * @param details
     */
    public Error(final String message, final List<Detail> details) {
        this.message = message;
        this.details = details;
    }

    /**
     *
     * @return
     */
    public static Error empty() {
        return new Error();
    }

    /**
     *
     * @param message
     * @return
     */
    public static Error of(final String message) {
        return new Error(message, new ArrayList<>());
    }

    /**
     *
     * @param message
     * @param details
     * @return
     */
    public static Error of(final String message, final List<Detail> details) {
        return new Error(message, details);
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public List<Detail> getDetails() {
        return Collections.unmodifiableList(this.details);
    }

    /**
     *
     * @param details
     */
    public void setDetails(final List<Detail> details) {
        this.details = Collections.unmodifiableList(details);
    }

    
    
    
    /**
     * {@inheritDoc }
     */
    @Override
    public String toString() {
        return "Error{" + "message=" + message + ", details=" + details + '}';
    }    
    
    
}
