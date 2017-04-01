package com.miage.lesouk.entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
