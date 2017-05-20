package com.miage.lesouk.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe Annonce
 */
@Entity
@Table(name="Annonce")
public class Annonce implements Serializable {
    
    /** id Annonce */
    @Id
    @GeneratedValue
    private Integer idA; //auto-généré
    
    /** titre Annonce */
    private String nomA;
    
    /** description Annonce */
    private String descriptionA;
    
    /** prix Annonce */
    private Long prixA;
    
    /** date creation Annonce */
    private Date dateCreaA;
    
    /** etat Annonce */
    private String etatA; //à améliorer avec une enum
    
    /** id Createur */
    private Integer idUCreateur;
    
    /** id Candidat */
    private Integer idUCandidat;
    
    /** prix Candidat */
    private Long prixCandidat;
    
    /** date creation Annonce */
    private Date dateCandidat;
    
    /** commentaires */
    @Transient
    private List<Commentaire> listeCommentaires;

    public Annonce() {
    }
    
    public Annonce(String nomA, String descriptionA, Long prixA, int idUCreateur) {
        this.nomA = nomA;
        this.descriptionA = descriptionA;
        this.prixA = prixA;
        this.idUCreateur = idUCreateur;
        
        // paramètres par défaut
        this.dateCreaA = new Date();
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
    public Long getPrixA() {
        return prixA;
    }

    /**
     * Saisir prix Annonce
     * @param prixA 
     */
    public void setPrixA(Long prixA) {
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
     * Récupérer id créateur Annonce
     * @return idUCreateur
     */
    public Integer getIdUCreateur() {
        return idUCreateur;
    }

    /**
     * Saisir id créateur Annonce
     * @param idUCreateur 
     */
    public void setIdUCreateur(Integer idUCreateur) {
        this.idUCreateur = idUCreateur;
    }

    /**
     * Récupérer id candidat Annonce
     * @return idUCandidat
     */
    public Integer getIdUCandidat() {
        return idUCandidat;
    }

    /**
     * Saisir id candidat Annonce
     * @param idUCandidat 
     */
    public void setIdUCandidat(Integer idUCandidat) {
        this.idUCandidat = idUCandidat;
    }

    /**
     * Récupérer prix proposé par candidat pour Annonce
     * @return prixCandidat
     */
    public Long getPrixCandidat() {
        return prixCandidat;
    }

    /**
     * Saisir prix proposé par candidat pour Annonce
     * @param prixCandidat 
     */
    public void setPrixCandidat(Long prixCandidat) {
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
        hash = 97 * hash + Objects.hashCode(this.idUCreateur);
        hash = 97 * hash + Objects.hashCode(this.idUCandidat);
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
        if (!Objects.equals(this.idUCreateur, other.idUCreateur)) {
            return false;
        }
        if (!Objects.equals(this.idUCandidat, other.idUCandidat)) {
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
}
