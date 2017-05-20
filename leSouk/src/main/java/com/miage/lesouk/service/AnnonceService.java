package com.miage.lesouk.service;

import com.miage.lesouk.entite.Annonce;
import java.util.List;
import java.util.Set;

public interface AnnonceService {
    public Annonce getAnnonce(Integer idA);
    public List<Annonce> getAnnoncesCreees(Integer idUCreateur);
    public List<Annonce> getAnnoncesCandidatees(Integer idUCandidat);
    public Set<Annonce> getAnnonces(String motsCles);
    public Annonce creerAnnonce(String nomA, String descriptionA, Double prixA,
            Integer idUCreateur);
    public Annonce candidaterAnnonce(Integer idA, Integer idUCandidat, 
            Double prixCandidat);
    public Annonce cloturerAnnonce(Integer idA);
    public Annonce commenterAnnonce(Integer idA, Integer idUser, String texte);
}
