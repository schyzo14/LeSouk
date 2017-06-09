package com.miage.lesouk.web;

import com.miage.lesouk.entite.Utilisateur;
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
    
    /**
     * Récupérer les informations d'un Utilisateur
     * GET http://localhost:8080/api/utilisateurs/
     * @param idU
     * @return Utilisateur
     */
    @GetMapping("{idU}")
    public Utilisateur getUtilisateur(@PathVariable Integer idU) {
        return utilService.getUtilisateur(idU);
    }
    
    /**
     * Récupérer les informations d'un Utilisateur à partir de son pseudo
     * GET http://localhost:8080/api/utilisateurs/user/
     * @param pseudoU
     * @return Utilisateur
     */
    @GetMapping("user/{pseudoU}")
    public Utilisateur getUtilisateurByPseudo(@PathVariable String pseudoU) {
        return utilService.getUtilisateurByPseudo(pseudoU);
    }
    
}
