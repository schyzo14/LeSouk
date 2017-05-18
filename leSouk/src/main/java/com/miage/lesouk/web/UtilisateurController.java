package com.miage.lesouk.web;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.repository.UtilisateurRepository;
import java.util.List;
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
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    
    // Repository de Utilisateur
    @Autowired
    private UtilisateurRepository utilRepository;
    
    //Repository de Annonce
    @Autowired
    private AnnonceRepository annonceRepository;
    
    /**
     * GET http://localhost:8080/api/lesouk/utilisateurs
     * @return 
     */
    @GetMapping
    public Iterable<Utilisateur> findUtilisateurs() {
        return this.utilRepository.findAll();
    }
    
    @GetMapping("{idU}")
    public Utilisateur getUtilisateur(@PathVariable Integer idU) {
        return utilRepository.findById(idU);
    }
    
    @GetMapping("{idU}/annoncesCrees")
    public List<Annonce> getAnnoncesCrees(@PathVariable Integer idU) {
        return annonceRepository.findByIdUCreateur(idU);
    }
    
    @GetMapping("{idU}/annoncesCandidatees")
    public List<Annonce> getAnnoncesCandidatees(@PathVariable Integer idU) {
        return annonceRepository.findByIdUCandidat(idU);
    }
    
    
}
