package com.miage.lesouk.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe Annonce
 */
@Entity
@Table(name="Annonce")
public class Annonce implements Serializable, Comparable<Annonce> {
    
    /** id Annonce */
    @Id
    @GeneratedValue
    private Integer idA; //auto-généré
    
    /** titre Annonce */
    private String nomA;
    
    /** description Annonce */
    private String descriptionA;
    
    /** prix Annonce */
    private Double prixA;
    
    /** date creation Annonce */
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateCreaA;
    
    /** etat Annonce */
    private String etatA; //à améliorer avec une enum
    
    /** id Createur */
 //   private Integer idUCreateur;
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"annoncesCandidatees", "annoncesCreees"})
    private Utilisateur createur;
    
    /** id Candidat */
    @ManyToOne
    @JoinColumn(name="id2")
    @JsonIgnoreProperties({"annoncesCandidatees", "annoncesCreees"})
    private Utilisateur candidat;
    
    /** prix Candidat */
    private Double prixCandidat;
    
    /** date creation Annonce */
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateCandidat;
    
    /** commentaires */
    @Transient
    private List<Commentaire> listeCommentaires;

    public Annonce() {
    }
    
    public Annonce(String nomA, String descriptionA, Double prixA, Utilisateur UCreateur) {
        this.nomA = nomA;
        this.descriptionA = descriptionA;
        this.prixA = prixA;
        this.createur = UCreateur;
        
        // paramètres par défaut
        this.dateCreaA = new Date();
        this.etatA = "Active";
    }

    public Annonce(String nomA, String descriptionA, Double prixA, Utilisateur UCreateur, Date dateCrea) {
        this.nomA = nomA;
        this.descriptionA = descriptionA;
        this.prixA = prixA;
        this.createur = UCreateur;
        this.dateCreaA = dateCrea;
        
        // paramètres par défaut
        this.etatA = "Active";
    }
    
    /**
     * Récupérer id Annonce
     * @return idA
     */
    public Integer getIdA() {
        return idA;
    }

    /**
     * Saisir id Annonce
     * @param idA 
     */
    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    /**
     * Récupérer nom Annonce
     * @return nomA
     */
    public String getNomA() {
        return nomA;
    }

    /**
     * Saisir nom Annonce
     * @param nomA 
     */
    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    /**
     * Récupérer description Annonce
     * @return descriptionA
     */
    public String getDescriptionA() {
        return descriptionA;
    }

    /**
     * Saisir description Annonce
     * @param descriptionA 
     */
    public void setDescriptionA(String descriptionA) {
        this.descriptionA = descriptionA;
    }

    /**
     * Récupérer prix Annonce
     * @return prixA
     */
    public Double getPrixA() {
        return prixA;
    }

    /**
     * Saisir prix Annonce
     * @param prixA 
     */
    public void setPrixA(Double prixA) {
        this.prixA = prixA;
    }

    /**
     * Récupérer date de création Annonce
     * @return dateCreaA
     */
    public Date getDateCreaA() {
        return dateCreaA;
    }

    /**
     * Saisir date de création Annonce
     * @param dateCreaA 
     */
    public void setDateCreaA(Date dateCreaA) {
        this.dateCreaA = dateCreaA;
    }

    /**
     * Récupérer état Annonce
     * @return etatA
     */
    public String getEtatA() {
        return etatA;
    }

    /**
     * Saisir état Annonce
     * @param etatA 
     */
    public void setEtatA(String etatA) {
        this.etatA = etatA;
    }

    /**
     * Récupérer créateur Annonce
     * @param UCreateur 
     */
    public void setCreateur(Utilisateur UCreateur) {
        this.createur = UCreateur;
    }
    
    /**
     * Saisir créateur Annonce
     * @return  createur
     */
    public Utilisateur getCreateur() {
        return createur;
    }

    /**
     * Récupérer candidat Annonce
     * @return candidat
     */
    public Utilisateur getCandidat() {
        return candidat;
    }

    /**
     * Saisir candidat Annonce
     * @param candidat 
     */
    public void setCandidat(Utilisateur candidat) {
        this.candidat = candidat;
    }

    /**
     * Récupérer prix proposé par candidat pour Annonce
     * @return prixCandidat
     */
    public Double getPrixCandidat() {
        return prixCandidat;
    }

    /**
     * Saisir prix proposé par candidat pour Annonce
     * @param prixCandidat 
     */
    public void setPrixCandidat(Double prixCandidat) {
        this.prixCandidat = prixCandidat;
    }

    /**
     * Récupérer date de candidature
     * @return date de candidature
     */
    public Date getDateCandidat() {
        return dateCandidat;
    }

    /**
     * Saisir date de candidature
     * @param dateCandidat 
     */
    public void setDateCandidat(Date dateCandidat) {
        this.dateCandidat = dateCandidat;
    }
    
    

    /**
     * Récupérer la liste des commentaires
     * @return Liste Commentaires
     */
    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    /**
     * Saisir une liste de Commentaires
     * @param listeCommentaires 
     */
    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idA);
        hash = 97 * hash + Objects.hashCode(this.nomA);
        hash = 97 * hash + Objects.hashCode(this.descriptionA);
        hash = 97 * hash + Objects.hashCode(this.prixA);
        hash = 97 * hash + Objects.hashCode(this.dateCreaA);
        hash = 97 * hash + Objects.hashCode(this.etatA);
        hash = 97 * hash + Objects.hashCode(this.createur);
        hash = 97 * hash + Objects.hashCode(this.candidat);
        hash = 97 * hash + Objects.hashCode(this.prixCandidat);
        hash = 97 * hash + Objects.hashCode(this.dateCandidat);
        hash = 97 * hash + Objects.hashCode(this.listeCommentaires);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Annonce other = (Annonce) obj;
        if (!Objects.equals(this.nomA, other.nomA)) {
            return false;
        }
        if (!Objects.equals(this.descriptionA, other.descriptionA)) {
            return false;
        }
        if (!Objects.equals(this.etatA, other.etatA)) {
            return false;
        }
        if (!Objects.equals(this.idA, other.idA)) {
            return false;
        }
        if (!Objects.equals(this.prixA, other.prixA)) {
            return false;
        }
        if (!Objects.equals(this.dateCreaA, other.dateCreaA)) {
            return false;
        }
        if (!Objects.equals(this.createur, other.createur)) {
            return false;
        }
        if (!Objects.equals(this.candidat, other.candidat)) {
            return false;
        }
        if (!Objects.equals(this.prixCandidat, other.prixCandidat)) {
            return false;
        }
        if (!Objects.equals(this.dateCandidat, other.dateCandidat)) {
            return false;
        }
        if (!Objects.equals(this.listeCommentaires, other.listeCommentaires)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Annonce o) {
        return getDateCreaA().compareTo(o.getDateCreaA());
    }
}
