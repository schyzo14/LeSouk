package com.miage.lesouk.web;

import java.security.Principal;
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
    
    /**
     * GET http://localhost:8080/api/seConnecter
     * @return 
     */
    @GetMapping
    public Principal user(Principal user){
        return user;
    }   
}
