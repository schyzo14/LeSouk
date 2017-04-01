package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Commentaire;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository de Commentaire
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>{
    
    /**
     * Recupérer tous les commentaires
     * @return      liste de commentaires
     */
    public Iterable<Commentaire> findAll();
}
