package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.UtilisateurRepository;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.UtilisateurService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    
    //Repository d'Utilisateur
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    /**
     * Récupérer les informations d'un Utilisateur
     * @param idU
     * @return Utilisateur
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Utilisateur getUtilisateur(Integer idU) {
        Utilisateur u = utilisateurRepository.findById(idU);
        Collections.sort(u.getAnnoncesCreees(), Collections.reverseOrder());
        Collections.sort(u.getAnnoncesCandidatees(), Collections.reverseOrder());
        
        return u;
    }
    
    /**
     * Récupérer les informations d'un Utilisateur à partir de son pseudo
     * @param pseudo
     * @return Utilisateur
     */
    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) {
        return utilisateurRepository.findByPseudo(pseudo);
    }
}
