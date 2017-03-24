/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.mongodb.domaine;

import com.miage.lesouk.mongodb.domaine.Commentaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Aurore
 */
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>{
    
    public Iterable<Commentaire> findAll();
}
