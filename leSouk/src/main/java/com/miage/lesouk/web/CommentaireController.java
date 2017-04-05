package com.miage.lesouk.web;

import com.miage.lesouk.repository.CommentaireRepository;
import com.miage.lesouk.entite.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping
    public Iterable<Commentaire> findCommentaires() {
        return this.repository.findAll();
    }
}
