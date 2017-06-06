package com.miage.lesouk.repository;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import com.miage.lesouk.securityComponents.UserCredential;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository de Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
    
        /**
         * Récupère tous les utilisateurs
         * @return      liste de tous utilisateurs
         */
        public Iterable<Utilisateur> findAll();
        
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
                
        /**
         * Chercher un utilisateur par son mail
         * @param mail
         * @return Utilisateur
         */
        public Utilisateur findByMail(String mail);
}
