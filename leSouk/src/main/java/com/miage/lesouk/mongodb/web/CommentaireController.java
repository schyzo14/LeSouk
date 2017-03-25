/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.mongodb.web;

import com.miage.lesouk.mongodb.domaine.CommentaireRepository;
import com.miage.lesouk.mongodb.domaine.Commentaire;
import java.awt.print.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aurore
 */
@RestController
@RequestMapping("/api/lesouk/commentaires")
public class CommentaireController {
    
    @Autowired
    private CommentaireRepository repository;
    
    /**
     * GET http://localhost:8080/api/lesouk/commentaires
     * @return 
     */
    @GetMapping
    public Iterable<Commentaire> findCommentaires() {
        return this.repository.findAll();
    }
}
