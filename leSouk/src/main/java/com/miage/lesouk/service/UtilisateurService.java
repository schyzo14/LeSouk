/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.lesouk.service;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.interfacepublic.UtilisateurPublic;
import java.util.List;

/**
 *
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
public interface UtilisateurService {
    public Utilisateur getUtilisateur(Integer idU);
    public Utilisateur getUtilisateurByPseudo(String pseudo);
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur);
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat);
    public Utilisateur createUtilisateur(Utilisateur u);
}
