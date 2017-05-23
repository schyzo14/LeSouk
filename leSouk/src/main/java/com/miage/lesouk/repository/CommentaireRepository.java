package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Commentaire;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository de Commentaire
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>{
    
    /**
     * Récupérer les commentaires avec l'id de l'article
     * @param idA       id de l'annonce
     * @return          liste des commentaires
     */
    public List<Commentaire> findByIdA(int idA);
}
