package com.miage.lesouk.web;

import com.miage.lesouk.securityComponents.AuthentificationService;
import com.miage.lesouk.service.UtilisateurService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@CrossOrigin
@RestController
@RequestMapping("api/seConnecter")
public class AuthentificationController {
    
    // Service de Utilisateur
    @Autowired
    private UtilisateurService utilService;
    
    //Service de Annonce
    @Autowired
    private AuthentificationService authentificationService;
    
    /**
     * POST http://localhost:8080/api/seConnecter
     * @return 
     */
    @GetMapping
    public Principal user(Principal user){
        return user;
    }   
}
