package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
    
        /**
         * Récupère tous les utilisateurs
         * @return      liste de tous utilisateurs
         */
        public Iterable<Utilisateur> findAll();
}
