package com.miage.lesouk.web;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.service.AnnonceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/annonces")
public class AnnonceController {
    @Autowired
    public AnnonceService annonceService;
    
    @GetMapping("{idA}")
    public Annonce getAnnonce(@PathVariable Long idA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping("{motsCles}")
    public List<Annonce> getAnnonces(@PathVariable String motsCles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping
    public Annonce postAnnonce(@RequestBody Annonce annonce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PutMapping("{idA}")
    public Annonce putAnnonceCandidater(@PathVariable Long idA, @RequestBody Annonce annonce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PutMapping("{idA}")
    public Annonce putAnnonceCloturer(@PathVariable Long idA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping("{idA}")
    public Annonce postCommentaire(@PathVariable Long idA, @RequestBody Commentaire commentaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
