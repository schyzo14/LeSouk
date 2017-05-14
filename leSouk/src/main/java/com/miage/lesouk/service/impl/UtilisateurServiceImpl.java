/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.service.impl;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.repository.UtilisateurRepository;
import com.miage.lesouk.service.AnnonceService;
import com.miage.lesouk.service.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    
    @Autowired
    private AnnonceService annonceService;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Override
    public Utilisateur getUtilisateur(Integer idU) {
        return utilisateurRepository.findById(idU);
    }

    @Override
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur) {
        return annonceService.getAnnoncesCreees(idUCreateur);
    }

    @Override
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat) {
        return annonceService.getAnnoncesCandidatees(idUCandidat);
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }
}
