package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.service.AnnonceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService {
    
/*    @Autowired
    private AnnonceRepository annonceRepository;*/
    
    /*
    @Autowired
    private CommentaireRepository commentaireRepository;
    */

    @Override
    public Annonce getAnnonce(Integer idA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Annonce> getAnnonces(String motsCles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce creerAnnonce(String nomA, String descriptionA, Long prixA, Integer idUCreateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce candidaterAnnonce(Integer idA, Integer idUCandidat, Long prixCandidat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce cloturerAnnonce(Integer idA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annonce commenterAnnonce(Integer idA, Integer idUser, String texte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
