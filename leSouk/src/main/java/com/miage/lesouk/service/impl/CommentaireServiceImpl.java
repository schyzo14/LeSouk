package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.repository.CommentaireRepository;
import com.miage.lesouk.service.CommentaireService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public class CommentaireServiceImpl implements CommentaireService{

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
    public Commentaire createCommentaire(int idU, int idA, String texte, Date date) {
        Commentaire commentaire = new Commentaire(idA, idU, texte, date);
        commentaireRepository.save(commentaire);
        return commentaire;
    }
    
}
