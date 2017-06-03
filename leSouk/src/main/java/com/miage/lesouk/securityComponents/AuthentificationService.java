package com.miage.lesouk.securityComponents;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.UtilisateurRepository;
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
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException {

        // Format data : pseudo-mdp
        String[] parts = data.split("-");
        String pseudo = parts[0];
        String mdp = parts[1];
        
        Utilisateur utilisateur = this.utilisateurRepository.findByPseudo(pseudo);
        
        if(utilisateur == null){
            throw new UsernameNotFoundException("Pseudo not found : " + pseudo);
        } else if (! utilisateur.getMdp().equals(mdp)) {
            throw new UsernameNotFoundException("MDP incorrect");
        }
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(String role : utilisateur.getRoles()){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            authorities.add(authority);
        }
        
        return new User(pseudo, utilisateur.getMdp(), authorities);
    }
    
}
