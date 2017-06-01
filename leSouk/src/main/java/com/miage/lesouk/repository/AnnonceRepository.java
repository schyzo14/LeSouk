package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

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
     * @param createur
     * @return List Annonce
     */
    public List<Annonce> findBycreateur(Utilisateur createur);
    
    /**
     * Chercher les annonces d'un candidat
     * @param candidat
     * @return List Annonce
     */
    public List<Annonce> findByCandidat(Utilisateur candidat);
    
    /**
     * Chercher les annonces par mot-clé
     * @param idU
     * @param motscles
     * @return List Annonce
     */
    @Query("SELECT a FROM Annonce a WHERE a.etatA = 'Active' AND a.createur.id <> :idU AND (a.nomA like %:motscles% OR a.descriptionA like %:motscles%) ORDER BY a.dateCreaA DESC")
    public List<Annonce> findByMotsClesAndSort(@Param("idU") Integer idU, @Param("motscles") String motscles);
}
