package com.miage.lesouk.entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entité Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Entity
public class Utilisateur implements Serializable {
    // Id de l'utilisateur autogénéré
    @Id
    @GeneratedValue
    private long id;
    // Nom de l'utilisateur
    private String nom;
    // Prénom de l'utilisateur
    private String prenom;

    /**
     * Constructeur par défaut
     */
    public Utilisateur() {
    }

    /**
     * Constructeur d'un Utlisateur
     * @param nom       Nom de l'utilisateur
     * @param prenom    Prénom de l'utilisateur
     */
    public Utilisateur(String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
