package com.miage.lesouk.web;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.repository.UtilisateurRepository;
import com.miage.lesouk.securityComponents.UserCredential;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.UtilisateurService;
import java.util.List;
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
    
    /**
     * GET http://localhost:8080/api/lesouk/utilisateurs
     * @return 
     */
    /*@GetMapping
    public Iterable<Utilisateur> findUtilisateurs() {
        return this.utilService.findAll();
    }*/
    
    @GetMapping("{idU}")
    public Utilisateur getUtilisateur(@PathVariable Integer idU) {
        return utilService.getUtilisateur(idU);
    }
    
    @GetMapping("user/{pseudoU}")
    public UserCredential getUtilisateurByPseudo(@PathVariable String pseudoU) {
        return utilService.getUtilisateurByPseudo(pseudoU);
    }
    
    /*
    @GetMapping("{idU}/annoncesCrees")
    public List<Annonce> getAnnoncesCrees(@PathVariable Integer idU) {
        return annonceService.getAnnoncesCreees(idU);
    }
    
    @GetMapping("{idU}/annoncesCandidatees")
    public List<Annonce> getAnnoncesCandidatees(@PathVariable Integer idU) {
        return annonceService.getAnnoncesCandidatees(idU);
    }
    */
}
