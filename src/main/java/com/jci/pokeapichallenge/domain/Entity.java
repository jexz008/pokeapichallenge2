/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jci.pokeapichallenge.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.LastModifiedDate;


/**
 *
 * @author Joel Corona
 */
//@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @JsonView(value = {PokeapichallengeViews.External.class, PokeapichallengeViews.Internal.class})
    private String id;
    
    @CreatedDate
    @JsonView(PokeapichallengeViews.Internal.class)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @JsonView(PokeapichallengeViews.Internal.class)
    private LocalDateTime updateDate;

    @JsonView(PokeapichallengeViews.Internal.class)
    private String user;   

    
    /**
     * Entity.
     */
    public Entity() {
    }    

    /**
     * 
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param entityId 
     */
    public void setId(String id) {
        this.id = id;
    }
        
    /**
     * 
     * @return 
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    
    /**
     * 
     * @param creationDate 
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    /**
     * 
     * @return 
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    
    /**
     * 
     * @param updateDate 
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 
     * @return 
     */
    public String getUser() {
        return user;
    }

    /**
     * 
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    
}
