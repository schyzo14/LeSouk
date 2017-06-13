package com.miage.lesouk.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.interfacepublic.VueUtilisateur;
import com.miage.lesouk.service.AnnonceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe AnnonceController
 */
@CrossOrigin
@RestController
@RequestMapping("api/annonces")
public class AnnonceController {
    @Autowired
    public AnnonceService annonceService;
    
    /**
     * Récupération de l'annonce par l'id
     * @param idA
     * @return l'annonce
     */
    @GetMapping("{idA}")
    @JsonView(VueUtilisateur.Simple.class)
    public Annonce getAnnonce(@PathVariable Integer idA) {
        return annonceService.getAnnonce(idA);
    }
    
    /**
     * Récupération de l'annonce par l'id
     * @param idA
     * @return l'annonce
     */
    @GetMapping("/cloturee/{idA}")
    @JsonView(VueUtilisateur.Complet.class)
    @PostAuthorize("returnObject.etatA.equals('Cloturée') and (returnObject.createur.pseudo"
            + ".equals(authentication.name) or returnObject.candidat.pseudo.equals(authentication.name))")
    public Annonce getAnnonceCloturee(@PathVariable Integer idA) {
        return annonceService.getAnnonce(idA);
    }
    
    /**
     * Recherche d'annonces
     * @param idU
     * @param motsCles
     * @return liste d'annonces trouvées
     */
    @GetMapping("rechercher/{idU}/{motsCles}")
    public List<Annonce> getAnnonces(@PathVariable Integer idU, @PathVariable String motsCles) {
        return annonceService.getAnnonces(idU, motsCles);
    }
    
    /**
     * Créer annonce
     * @param annonce
     * @return l'annonce
     */
    @PostMapping
    public Annonce postAnnonce(@RequestBody Annonce annonce) {
        return annonceService.creerAnnonce(annonce.getNomA(), annonce.getDescriptionA(), annonce.getPrixA(),
                annonce.getCreateur().getId());
    }
    
    /**
     * Candidater à une annonce
     * @param idA
     * @param annonce
     * @return l'annonce
     */
    @PutMapping("candidater/{idA}")
    public Annonce putAnnonceCandidater(@PathVariable Integer idA, @RequestBody Annonce annonce) {
        return annonceService.candidaterAnnonce(idA, annonce.getCandidat().getId(), annonce.getPrixCandidat());
    }
    
    /**
     * Cloturer une annonce
     * @param idA
     * @return l'annonce
     */
    @PutMapping("cloturer/{idA}")
    public Annonce putAnnonceCloturer(@PathVariable Integer idA) {
        return annonceService.cloturerAnnonce(idA);
    }
    
    /**
     * Poster un commentaire
     * @param idA
     * @param commentaire
     * @return l'annonce
     */
    @PostMapping("{idA}")
    public Annonce postCommentaire(@PathVariable Integer idA, @RequestBody Commentaire commentaire) {
        return annonceService.commenterAnnonce(idA, commentaire.getIdU(), commentaire.getTexte());
    }
}
