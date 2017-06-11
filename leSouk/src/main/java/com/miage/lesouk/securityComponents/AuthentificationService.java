package com.miage.lesouk.securityComponents;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.service.UtilisateurService;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Authentification
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Service
public class AuthentificationService implements UserDetailsService {
    
    // Service de Utilisateur
    @Autowired
    private UtilisateurService utilisateurService;

    /**
     * Chargement de l'utilisateur pour l'authentification
     * @param pseudo                        pseudo de connexion
     * @return                              UserDetails
     * @throws UsernameNotFoundException    L'utilisateur n'existe pas
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {

        // Récupération de l'utilisateur avec son pseudo
        Utilisateur utilisateur = this.utilisateurService.getUtilisateurByPseudo(pseudo);
        
        // Si l'utilisateur n'existe pas, il ne peut pas se connecter
        if(utilisateur == null){
            // Exception pour un Pseudo inconnu
            throw new UsernameNotFoundException("Pseudo not found : " + pseudo);
        }
        
        // Récupération des roles de l'utilisateur
        Set<GrantedAuthority> authorities = new HashSet<>();
        // Pour chaque role, on les ajoute dans les Authorities
        for(String role : utilisateur.getRoles()){
            // Création des roles sous la forme Authority
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            // Ajout de l'Authority
            authorities.add(authority);
        }
        
        // Retourne un User avec son pseudo, son mdp et ses Authorities
        return new User(pseudo, utilisateur.getMdp(), authorities);
    }
}
