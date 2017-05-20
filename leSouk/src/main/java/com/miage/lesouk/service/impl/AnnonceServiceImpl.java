package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.CommentaireService;
import com.miage.lesouk.service.UtilisateurService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Annonce getAnnonce(Integer idA) {
        return annonceRepository.findByIdA(idA);
    }

    @Override
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur) {
        return annonceRepository.findByIdUCreateur(idUCreateur);
    }

    @Override
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat) {
        return annonceRepository.findByIdUCandidat(idUCandidat);
    }

    @Override
    public Set<Annonce> getAnnonces(String motsCles) {
        Set<Annonce> annonces = new TreeSet<>();
        
        for(Annonce a : annonceRepository.findByNomAContaining(motsCles)) {
            annonces.add(a);
        }
        
        for(Annonce a : annonceRepository.findByDescriptionAContaining(motsCles)) {
            annonces.add(a);
        }
        
        return annonces;
    }

    @Override
    public Annonce creerAnnonce(String nomA, String descriptionA, Long prixA, Integer idUCreateur) {
        Annonce annonce = new Annonce(nomA, descriptionA, prixA, idUCreateur);
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCreateur);
        
        if(utilisateur.getAnnoncesCreees() == null) {
            List<Annonce> annoncesCreees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCreees(annoncesCreees);
        }
        utilisateur.getAnnoncesCreees().add(annonce);
        
        utilisateurService.createUtilisateur(utilisateur);
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce candidaterAnnonce(Integer idA, Integer idUCandidat, Long prixCandidat) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCandidat);
        
        annonce.setIdUCandidat(idUCandidat);
        annonce.setPrixCandidat(prixCandidat);
        annonce.setEtatA("Optionnée");
        annonce.setDateCandidat(new Date());
        
        if(utilisateur.getAnnoncesCandidatees() == null) {
            List<Annonce> annoncesCandidatees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCandidatees(annoncesCandidatees);
        }
        utilisateur.getAnnoncesCandidatees().add(annonce);
        
        utilisateurService.createUtilisateur(utilisateur);
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce cloturerAnnonce(Integer idA) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        annonce.setEtatA("Cloturée");
        return annonceRepository.save(annonce);
    }

    @Override
    public Annonce commenterAnnonce(Integer idA, Integer idUser, String texte) {
        Annonce annonce = annonceRepository.findByIdA(idA);
        Date date = new Date();
        Commentaire commentaire = new Commentaire(idA, idUser, texte, date);
        
        if(annonce.getListeCommentaires() == null) {
            List<Commentaire> commentaires = new ArrayList<Commentaire>();
            annonce.setListeCommentaires(commentaires);
        }
        annonce.getListeCommentaires().add(commentaire);
        
        commentaireService.createCommentaire(commentaire.getIdU(), commentaire.getIdA(), commentaire.getTexte(),
                commentaire.getDateCreation());
        return annonceRepository.save(annonce);
    }
    
}
