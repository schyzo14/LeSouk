package com.miage.lesouk.service;

import com.miage.lesouk.entite.Commentaire;
import java.util.Date;
import java.util.List;

/**
 * Service de Commentaire
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

    /**
     * Retourne les commentaires d'une annonce
     * @param idA       id de l'annonce
     * @return          liste d'annonce
     */
    public List<Commentaire> getCommentairesByIdA (Integer idA);
}
