package com.miage.lesouk.entite;

import java.util.Date;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Document Commentaire présent dans MongoDB
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Document(collection = "commentaires")
public class Commentaire {
    
    // Id du commentaire autogénéré
    @Id
    private String idC;
    // Id de l'annonce
    private int idA;
    // Id de l'utilisateur
    private int idU;
    // Texte du commentaire
    private String texte;
    // Date de création du commentaire
    private Date dateCreation;

    /**
     * Constructeur d'un commentaire
     * @param idA           Id de l'annonce
     * @param idU           Id de l'utilisateur
     * @param texte         Texte du commentaire
     * @param dateCreation  Date de création du commentaire
     */
    public Commentaire(int idA, int idU, String texte, Date dateCreation) {
        this.idA = idA;
        this.idU = idU;
        this.texte = texte;
        this.dateCreation = dateCreation;
    }

    /**
     * Récupère l'id du commentaire
     * @return  id du commentaire
     */
    public String getIdC() {
        return idC;
    }

    /**
     * Saisir l'id du commentaire
     * @param idC   id du commentaire
     */
    public void setIdC(String idC) {
        this.idC = idC;
    }

    /**
     * Récupère l'id de l'annonce
     * @return  id de l'annonce
     */
    public int getIdA() {
        return idA;
    }

    /**
     * Saisir l'id de l'annonce
     * @param idA   id de l'annonce
     */
    public void setIdA(int idA) {
        this.idA = idA;
    }

    /**
     * Récupère l'id de l'utilisateur
     * @return  id de l'utilisateur
     */
    public int getIdU() {
        return idU;
    }

    /**
     * Saisir l'id de l'utilisateur
     * @param idU   id de l'utilisateur
     */
    public void setIdU(int idU) {
        this.idU = idU;
    }

    /**
     * Récupère le texte
     * @return  le texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Saisir le texte
     * @param texte     le texte du commentaire
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * Récupère la date de création du commentaire
     * @return  date de création du commentaire
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Saisir la date de création du commentaire
     * @param dateCreation  la date de création du commentaire
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
}