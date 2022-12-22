/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jci.pokeapichallenge.repository;

import com.jci.pokeapichallenge.domain.PokeapichallengeLog;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joel Corona
 */
@Repository
public interface PokeapichallengeLogRepositry extends MongoRepository<PokeapichallengeLog, String> {

    
    
    @Query(value = "{ $and: [ { 'ipOrigen':?0 } ] }", count = true)
    Long findByIpOrigen(String ipOrigen);
    
    
    @Query(value = "{ $and: [ { 'ipOrigen':?0 }, { 'metodo':?0 } ] }")
    Optional<PokeapichallengeLog> findByMetodoIpOrigen(final String ipOrigen, final String metodo);


    
}
