package com.miage.lesouk.entite;

import com.miage.lesouk.interfacepublic.ParticipantPublic;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

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
    // Ville
    private String ville;
    // Pays
    private String pays;
    // Liste Annonces Crées
    @Transient
    private List<Annonce> annoncesCreees;
    // Liste Annonces Candidatées
    @Transient
    private List<Annonce> annoncesCandidatees;

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
     * @param ville     Ville de l'utilisateur
     * @param pays      Pays de l'utilisateur
     */
    public Utilisateur(String nom, String prenom, String pseudo, String mail, String mdp, String ville, String pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mail = mail;
        this.mdp = mdp;
        this.pays = pays;
        this.ville = ville;
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
     * Récupérer la ville de localisation
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Modifier la ville de localisation
     * @param ville 
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    /**
     * Récupérer le pays de localisation
     * @return pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * Modifier le pays de localisation
     * @param pays 
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * Récupérer la liste des annonces créées
     * @return annoncesCreees
     */
    public List<Annonce> getAnnoncesCreees() {
        return annoncesCreees;
    }

    /**
     * Modifier la liste des annonces créées
     * @param annoncesCreees 
     */
    public void setAnnoncesCreees(List<Annonce> annoncesCreees) {
        this.annoncesCreees = annoncesCreees;
    }

    /**
     * Récupérer la liste des annonces candidatées
     * @return annoncesCandidatees
     */
    public List<Annonce> getAnnoncesCandidatees() {
        return annoncesCandidatees;
    }

    /**
     * Modifier la liste des annonces candidatées
     * @param annoncesCandidatees 
     */
    public void setAnnoncesCandidatees(List<Annonce> annoncesCandidatees) {
        this.annoncesCandidatees = annoncesCandidatees;
    }
}
