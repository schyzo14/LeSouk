package com.miage.lesouk.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.miage.lesouk.interfacepublic.ParticipantPublic;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import com.miage.lesouk.interfacepublic.VueUtilisateur;
import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entité Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Entity
public class Utilisateur implements ParticipantPublic, UtilisateurPublic {
    // Id de l'utilisateur autogénéré
    @Id
    @GeneratedValue
    @JsonView(VueUtilisateur.Simple.class)
    private Integer id;
    @JsonView(VueUtilisateur.Simple.class)
    private Integer id2;
    // Nom de l'utilisateur
    @JsonView(VueUtilisateur.Complet.class)
    private String nom;
    // Prénom de l'utilisateur
    @JsonView(VueUtilisateur.Complet.class)
    private String prenom;
    // Mail de l'utilisateur
    @JsonView(VueUtilisateur.Complet.class)
    private String mail;
    // Pseudo de l'utilisateur
    @JsonView(VueUtilisateur.Simple.class)
    private String pseudo;
    // Mot de passe de l'utilisateur
    private String mdp;
    // Ville
    @JsonView(VueUtilisateur.Simple.class)
    private String city;
    // Pays
    @JsonView(VueUtilisateur.Simple.class)
    private String country;
    // Liste Annonces Crées
    @OneToMany(targetEntity=Annonce.class, mappedBy="createur")
    @JsonIgnoreProperties({"createur", "candidat"})
    @JsonView(VueUtilisateur.Simple.class)
    private List<Annonce> annoncesCreees;
    // Liste Annonces Candidatées
    @OneToMany(targetEntity=Annonce.class, mappedBy="candidat")
    @JsonIgnoreProperties({"createur", "candidat"})
    @JsonView(VueUtilisateur.Simple.class)
    private List<Annonce> annoncesCandidatees;

        @ElementCollection
    private Set<String> roles;
        
    /**
     * Constructeur par défaut
     */
    public Utilisateur() {
        this.id2 = id;
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
        this.id2 = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mail = mail;
        this.mdp = mdp;
        this.country = pays;
        this.city = ville;
    }

    /**
     * Récupérer id de l'utilisateur
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Saisir idUtilisateur
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Récupérer id 2 de l'utilisateur
     * @return id
     */
    public Integer getId2() {
        id2 = id;
        return id2;
    }

    /**
     * Saisir idUtilisateur 2
     * @param id 
     */
    public void setId2(Integer id) {
        this.id2 = id;
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
     * Récupérer la city de localisation
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Modifier la city de localisation
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Récupérer le country de localisation
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Modifier le country de localisation
     * @param country 
     */
    public void setCountry(String country) {
        this.country = country;
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
    
    /**
     * Récupérer le rôle de l'utilisateur 
     * @return roles
     */
    public Set<String> getRoles() {
        return roles;
    }

    /**
     * Cherche un rôle dans la liste des rôles
     * @param r
     * @return true/false
     */
    public boolean containsRole(String r) {
        return roles.contains(r);
    }

    /**
     * Ajouter un rôle
     * @param r
     * @return true/false
     */
    public boolean addRole(String r) {
        return roles.add(r);
    }

    /**
     * Supprimer un rôle
     * @param r
     * @return true/false
     */
    public boolean removeRole(String r) {
        return roles.remove(r);
    }
}
