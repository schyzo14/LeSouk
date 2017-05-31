package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface Repository classe Annonce
 */
public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Integer> {
    /**
     * Chercher une annonce par son id
     * @param idA
     * @return Annonce
     */
    public Annonce findByIdA(Integer idA);
    
    /**
     * Chercher les annonces d'une personne
     * @param idUCreateur
     * @return List Annonce
     */
    public List<Annonce> findBycreateur(Utilisateur createur);
    
    /**
     * Chercher les annonces d'un candidat
     * @param idUCandidat
     * @return List Annonce
     */
    public List<Annonce> findByCandidat(Utilisateur candidat);
    
    /**
     * Chercher les titres d'annonces par mot-clé
     * @param motsCles
     * @return List Annonce
     */
    public List<Annonce> findByNomAContaining(String motsCles);
    
    /**
     * Chercher les descriptions d'annonces par mot-clé
     * @param motsCles
     * @return List Annonce
     */
    public List<Annonce> findByDescriptionAContaining(String motsCles);
}
