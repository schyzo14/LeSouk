/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.mongodb.domaine;

import java.util.Date;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Aurore
 */
@Document(collection = "commentaires")
public class Commentaire {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idC;
    
    private int idA;
    private int idU;
    private String texte;
    private Date dateCreation;

    public Commentaire(int idA, int idU, String texte, Date dateCreation) {
        this.idA = idA;
        this.idU = idU;
        this.texte = texte;
        this.dateCreation = dateCreation;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
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
