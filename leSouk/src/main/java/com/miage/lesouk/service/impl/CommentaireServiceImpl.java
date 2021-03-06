package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.repository.CommentaireRepository;
import com.miage.lesouk.service.CommentaireService;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Implémentation du Service de Commentaire
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Service
public class CommentaireServiceImpl implements CommentaireService{

    // Repository d'un commentaire
    @Autowired
    private CommentaireRepository commentaireRepository;
    
    /**
     * Créer un commentaire
     * @param idU       id de l'utilisateur
     * @param idA       id de l'annonce
     * @param texte     texte du commentaire
     * @param date      date du commentaire
     * @return          le commentaire créé
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Commentaire createCommentaire(int idU, int idA, String texte, Date date) {
        // Construction du Commentaire
        Commentaire commentaire = new Commentaire(idA, idU, texte, date);
        // Enregistrement du commentaire dans la BD
        commentaireRepository.save(commentaire);
        // Retourne le commentaire créé
        return commentaire;
    }

    /**
     * Retourne les commentaires d'une annonce
     * @param idA       id de l'annonce
     * @return          liste d'annonce
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Commentaire> getCommentairesByIdA(Integer idA) {
        // Récupération des commentaires pour une annonce idA auprès de la BD
        List<Commentaire> listCommentaires = commentaireRepository.findByIdA(idA);
        // Tri des annonces par date décroissante
        Collections.sort(listCommentaires, Collections.reverseOrder());
        // Retourne la liste des commentaires
        return listCommentaires;
    }
}
