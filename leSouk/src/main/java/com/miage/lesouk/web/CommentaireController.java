/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.web;

import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de Commentaire
 * 
 * ---------------------- A supprimer ----------------------------
 * 
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@RestController
@RequestMapping("/api/lesouk/commentaires")
public class CommentaireController {
    
    // Repository de Commentaire
    @Autowired
    private CommentaireRepository repository;
    
    /**
     * GET http://localhost:8080/api/lesouk/commentaires
     * @return      liste de commentaires
     */
    @GetMapping("comm/{idA}")
    public Iterable<Commentaire> getTest1(@PathVariable int idA){
        return this.repository.findByIdA(idA);
    }
}