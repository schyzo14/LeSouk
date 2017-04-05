package com.miage.lesouk.service;

import com.miage.lesouk.entite.Commentaire;
import java.util.Date;

/**
 * 
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface CommentaireService {
    
    /**
     * Créer un commentaire
     * @param idU       id de l'utilisateur
     * @param idA       id de l'annonce
     * @param texte     texte du commentaire
     * @param date      date du commentaire
     * @return          le commentaire créé
     */
    public Commentaire createCommentaire(int idU, int idA, String texte, Date date);
}
