package com.miage.lesouk.entite;

import com.miage.lesouk.interfacepublic.ParticipantPublic;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entité Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Entity
public class Utilisateur implements ParticipantPublic, UtilisateurPublic {
    // Id de l'utilisateur autogénéré
    @Id
    @GeneratedValue
    private long id;
    // Nom de l'utilisateur
    private String nom;
    // Prénom de l'utilisateur
    private String prenom;
    // Mail de l'utilisateur
    private String mail;
    // Pseudo de l'utilisateur
    private String pseudo;
    // Mot de passe de l'utilisateur
    private String mdp;
    // Id de localisation
    private Integer idL;

    /**
     * Constructeur par défaut
     */
    public Utilisateur() {
    }

    /**
     * Constructeur d'un Utlisateur
     * @param nom       Nom de l'utilisateur
     * @param prenom    Prénom de l'utilisateur
     * @param mail      Mail de l'utilisateur
     * @param pseudo    Pseudo de l'utilisateur
     * @param mdp       Mot de passe de l'utilisateur
     * @param idL       Id de localisation
     */
    public Utilisateur(String nom, String prenom, String pseudo, String mail, String mdp, Integer idL) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mail = mail;
        this.mdp = mdp;
        this.idL = idL;
    }

    /**
     * Récupérer id de l'utilisateur
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Saisir idUtilisateur
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Récupérer le nom de l'utilisateur
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifier le nom de l'utilisateur
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupérer le Prénom de l'utilisateur
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifier le prénom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Récupérer le mail de l'utilisateur
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Modifier le mail de l'utilisateur
     * @param mail 
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Récupérer le pseudo de l'utilisateur
     * @return pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Modifier le pseudo de l'utilisateur
     * @param pseudo 
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Récupérer le mot de passe de l'utilisateur
     * @return mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Modifier le mot de passe de l'utilisateur
     * @param mdp 
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Récupérer l'id de localisation
     * @return idL
     */
    public Integer getIdL() {
        return idL;
    }

    /**
     * Modifier l'id de localisation
     * @param idL 
     */
    public void setIdL(Integer idL) {
        this.idL = idL;
    }
    
    
}
