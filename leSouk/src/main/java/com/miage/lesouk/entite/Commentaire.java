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

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
}
