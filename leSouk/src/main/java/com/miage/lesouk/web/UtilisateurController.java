package com.miage.lesouk.web;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@RestController
@RequestMapping("/api/lesouk/utilisateurs")
public class UtilisateurController {
    
    // Repository de Utilisateur
    @Autowired
    private UtilisateurRepository repository;
    
    /**
     * GET http://localhost:8080/api/lesouk/utilisateurs
     * @return 
     */
    @GetMapping
    public Iterable<Utilisateur> findUtilisateurs() {
        return this.repository.findAll();
    }
    
    @GetMapping("{idU}")
    public Utilisateur getUtilisateur(@PathVariable Long idU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping("{idU}/annoncesCrees")
    public Utilisateur getAnnoncesCrees(@PathVariable Long idU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping("{idU}/annoncesCandidatees")
    public Utilisateur getAnnoncesCandidatees(@PathVariable Long idU) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
