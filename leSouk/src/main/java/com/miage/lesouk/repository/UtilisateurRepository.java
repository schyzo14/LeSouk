package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
            
        /**
         * Chercher un utilisateur par son id
         * @param idU
         * @return Utilisateur
         */
        public Utilisateur findById(Integer idU);
        
        /**
         * Chercher un utilisateur par son pseudo
         * @param pseudo
         * @return Utilisateur
         */
        public Utilisateur findByPseudo(String pseudo);
}
