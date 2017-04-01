package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Annonce;
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
    public Annonce findByIdA(int idA);
    
    /**
     * Chercher les annonces d'une personne
     * @param idUCreateur
     * @return List Annonce
     */
    public List<Annonce> findByIdUCreateur(int idUCreateur);
    
    /**
     * Chercher les annonces d'un candidat
     * @param idUCandidat
     * @return List Annonce
     */
    public List<Annonce> findByIdUCandidat(int idUCandidat);
    
    /**
     * Chercher les annonces par mot-clé
     * @param motsCles
     * @return List Annonce
     */
    public List<Annonce> findByNomAContainingOrDescriptionAContaining
        (String motsCles);
}
