package com.miage.lesouk.web;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.service.AnnonceService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/annonces")
public class AnnonceController {
    @Autowired
    public AnnonceService annonceService;
    
    @GetMapping("{idA}")
    public Annonce getAnnonce(@PathVariable Integer idA) {
        return annonceService.getAnnonce(idA);
    }
    
    @GetMapping("liste/{motsCles}")
    public Set<Annonce> getAnnonces(@PathVariable String motsCles) {
        return annonceService.getAnnonces(motsCles);
    }
    
    @PostMapping
    public Annonce postAnnonce(@RequestBody Annonce annonce) {
        return annonceService.creerAnnonce(annonce.getNomA(), annonce.getDescriptionA(), annonce.getPrixA(),
                annonce.getCreateur().getId());
    }
    
    @PutMapping("candidater/{idA}")
    public Annonce putAnnonceCandidater(@PathVariable Integer idA, @RequestBody Annonce annonce) {
        return annonceService.candidaterAnnonce(idA, annonce.getCandidat().getId(), annonce.getPrixCandidat());
    }
    
    @PutMapping("cloturer/{idA}")
    public Annonce putAnnonceCloturer(@PathVariable Integer idA) {
        return annonceService.cloturerAnnonce(idA);
    }
    
    @PostMapping("{idA}")
    public Annonce postCommentaire(@PathVariable Integer idA, @RequestBody Commentaire commentaire) {
        return annonceService.commenterAnnonce(idA, commentaire.getIdU(), commentaire.getTexte());
    }
}
