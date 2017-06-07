package com.miage.lesouk.web;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@CrossOrigin
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    
    // Service de Utilisateur
    @Autowired
    private UtilisateurService utilService;
    
    //Service de Annonce
    @Autowired
    private AnnonceService annonceService;
    
    @GetMapping("{idU}")
    public Utilisateur getUtilisateur(@PathVariable Integer idU) {
        return utilService.getUtilisateur(idU);
    }
    
    @GetMapping("user/{pseudoU}")
    public Utilisateur getUtilisateurByPseudo(@PathVariable String pseudoU) {
        return utilService.getUtilisateurByPseudo(pseudoU);
    }
    
}
