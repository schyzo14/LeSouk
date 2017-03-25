package com.miage.lesouk;

import com.miage.lesouk.mongodb.domaine.Commentaire;
import com.miage.lesouk.mongodb.domaine.CommentaireRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LesoukApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
            SpringApplication.run(LesoukApplication.class, args);
    }
    
    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public void run(String... strings) throws Exception {
        // Initialisation des données de MongoDB --> Commentaires
        System.out.println("[MongoDB] Initialisation des données");
        System.out.println("---- Suppression de tous les commentaires ----");
        commentaireRepository.deleteAll();
        System.out.println("---- Ajout des commentaires ----");
        commentaireRepository.save(new Commentaire(1, 1, "Jolie petit canard !", new Date()));
     //   commentaireRepository.save(new Commentaire(1, 2, "Est-ce commestible ?", new Date()));
     //   commentaireRepository.save(new Commentaire(2, 1, "Cela se mange-t-il ?", new Date()));
     //   commentaireRepository.save(new Commentaire(3, 3, "Trop cher !", new Date()));
        System.out.println("---- Données insérées (FindAll) ----");
        for (Commentaire commentaire : commentaireRepository.findAll()) {
                System.out.println("idC : " + commentaire.getIdC() + " - idA : " + commentaire.getIdA() + " - idU : " + commentaire.getIdU() + " - texte : " + commentaire.getTexte() + " - dateCreation : " + commentaire.getDateCreation());
        }
        System.out.println("---- Fin de l'initialisation de MongoDB ----");
    }
}
