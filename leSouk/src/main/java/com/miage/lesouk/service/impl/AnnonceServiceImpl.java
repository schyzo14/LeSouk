package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.CommentaireService;
import com.miage.lesouk.service.UtilisateurService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService {
    
    @Autowired
    private AnnonceRepository annonceRepository;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private CommentaireService commentaireService;

    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce getAnnonce(Integer idA) {
        Annonce a = annonceRepository.findByIdA(idA);
        a.setListeCommentaires(commentaireService.getCommentairesByIdA(idA));
        return a;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur) {
        return annonceRepository.findBycreateur(utilisateurService.getUtilisateur(idUCreateur));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat) {
        return annonceRepository.findByCandidat(utilisateurService.getUtilisateur(idUCandidat));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Annonce> getAnnonces(Integer idU, String motsCles) {
        return annonceRepository.findByMotsClesAndSort(idU, motsCles);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce creerAnnonce(String nomA, String descriptionA, Double prixA, Integer idUCreateur) {

        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCreateur);
                
        Annonce annonce = new Annonce(nomA, descriptionA, prixA, utilisateur);
        
        if(utilisateur.getAnnoncesCreees() == null) {
            List<Annonce> annoncesCreees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCreees(annoncesCreees);
        }
        utilisateur.getAnnoncesCreees().add(annonce);
        
        //utilisateurService.createUtilisateur(utilisateur);
        return annonceRepository.save(annonce);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce candidaterAnnonce(Integer idA, Integer idUCandidat, Double prixCandidat) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCandidat);
        
        annonce.setCandidat(utilisateurService.getUtilisateur(idUCandidat));
        annonce.setPrixCandidat(prixCandidat);
        annonce.setEtatA("Optionnée");
        annonce.setDateCandidat(new Date());
        
        if(utilisateur.getAnnoncesCandidatees() == null) {
            List<Annonce> annoncesCandidatees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCandidatees(annoncesCandidatees);
        }
        utilisateur.getAnnoncesCandidatees().add(annonce);
        
        //utilisateurService.createUtilisateur(utilisateur);
        return annonceRepository.save(annonce);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce cloturerAnnonce(Integer idA) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        annonce.setEtatA("Cloturée");
        return annonceRepository.save(annonce);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce commenterAnnonce(Integer idA, Integer idUser, String texte) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        
        commentaireService.createCommentaire(idUser, idA, texte, new Date());
        
        annonce.setListeCommentaires(commentaireService.getCommentairesByIdA(idA));
        
        return annonceRepository.save(annonce);
    }
    
}
