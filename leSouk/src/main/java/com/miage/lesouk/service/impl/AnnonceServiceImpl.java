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

/**
 * Classe AnnonceServiceImpl implémentation d'AnnonceService
 */
@Service
public class AnnonceServiceImpl implements AnnonceService {
    
    @Autowired
    private AnnonceRepository annonceRepository;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private CommentaireService commentaireService;

    /**
     * Récupérer une annonce par son id
     * @param idA
     * @return Annonce
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce getAnnonce(Integer idA) {
        //Récupération de l'annonce
        Annonce a = annonceRepository.findByIdA(idA);
        
        //Ajout des commentaires à l'annonce
        a.setListeCommentaires(commentaireService.getCommentairesByIdA(idA));
        
        return a;
    }

    /**
     * Récupérer les annonces de la recherche
     * @param idU
     * @param motsCles
     * @return liste d'annonces trouvées
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Annonce> getAnnonces(Integer idU, String motsCles) {
        return annonceRepository.findByMotsClesAndSort(idU, motsCles);
    }

    /**
     * Créer une annonce
     * @param nomA
     * @param descriptionA
     * @param prixA
     * @param idUCreateur
     * @return l'annonce créée
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce creerAnnonce(String nomA, String descriptionA, Double prixA, Integer idUCreateur) {
        //Récupération de l'utilisateur
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCreateur);
        
        //Création de l'annonce
        Annonce annonce = new Annonce(nomA, descriptionA, prixA, utilisateur);
        
        //Si l'utilisateur n'a aucune annonce, on crée la liste
        if(utilisateur.getAnnoncesCreees() == null) {
            List<Annonce> annoncesCreees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCreees(annoncesCreees);
        }
        //Ajout de l'annonce à la liste des annonces de l'utilisateur
        utilisateur.getAnnoncesCreees().add(annonce);
        
        return annonceRepository.save(annonce);
    }

    /**
     * Candidater à une annonce
     * @param idA
     * @param idUCandidat
     * @param prixCandidat
     * @return l'annonce
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce candidaterAnnonce(Integer idA, Integer idUCandidat, Double prixCandidat) {
        //Récupération de l'annonce et de l'utilisateur
        Annonce annonce = annonceRepository.findByIdA(idA);
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUCandidat);
        
        //Attribution des paramètres
        annonce.setCandidat(utilisateurService.getUtilisateur(idUCandidat));
        annonce.setPrixCandidat(prixCandidat);
        annonce.setEtatA("Optionnée");
        annonce.setDateCandidat(new Date());
        
        //Si l'utilisateur n'a jamais candidaté, on crée la liste
        if(utilisateur.getAnnoncesCandidatees() == null) {
            List<Annonce> annoncesCandidatees = new ArrayList<Annonce>();
            utilisateur.setAnnoncesCandidatees(annoncesCandidatees);
        }
        //Ajout de l'annonce à la liste des candidatures
        utilisateur.getAnnoncesCandidatees().add(annonce);
        
        return annonceRepository.save(annonce);
    }

    /**
     * Cloturer une annonce
     * @param idA
     * @return l'annonce
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce cloturerAnnonce(Integer idA) {
        //Récupération de l'annonce
        Annonce annonce = annonceRepository.findByIdA(idA);
        
        //Changement de l'état
        annonce.setEtatA("Cloturée");
        
        return annonceRepository.save(annonce);
    }

    /**
     * Commenter une annonce
     * @param idA
     * @param idUser
     * @param texte
     * @return l'annonce
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Annonce commenterAnnonce(Integer idA, Integer idUser, String texte) {
        //Création du commentaire
        commentaireService.createCommentaire(idUser, idA, texte, new Date());
        
        //Récupération de l'annonce
        return getAnnonce(idA);
    }
    
}
