package com.miage.lesouk;

import com.miage.lesouk.entite.Annonce;
import com.miage.lesouk.entite.Commentaire;
import com.miage.lesouk.entite.Utilisateur;
import com.miage.lesouk.repository.AnnonceRepository;
import com.miage.lesouk.repository.CommentaireRepository;
import com.miage.lesouk.repository.UtilisateurRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Initialisation des données de test
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */
@SpringBootApplication
public class LesoukApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
            SpringApplication.run(LesoukApplication.class, args);
    }
    
    @Autowired
    private CommentaireRepository commentaireRepository;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private AnnonceRepository annonceRepository;

    @Override
    public void run(String... strings) throws Exception {
        
         // Initialisation des données de Utilisateurs
        System.out.println("[JavaDB] Initialisation des utilisateurs");
        System.out.println("---- Suppression de tous les utilisateurs ----");
        utilisateurRepository.deleteAll();
        System.out.println("---- Ajout des utilisateurs ----");
        Utilisateur utilisateur1 = new Utilisateur("Fabarez", "Manon", "simplette", "simplette@bordeaux.fr", "s123", "bordeaux", "france");
        utilisateurRepository.save(utilisateur1);
        Utilisateur utilisateur2 = new Utilisateur("Darrab", "Youssef", "dormeur", "dormeur@maroc.fr", "d123", "tournefeuille", "france");
        utilisateurRepository.save(utilisateur2);
        Utilisateur utilisateur3 = new Utilisateur("Queille", "Aurore", "grincheuse", "grincheuse@toulouse.fr", "g123", "toulouse", "france");
        utilisateurRepository.save(utilisateur3);
        Utilisateur utilisateur4 = new Utilisateur("Vierge", "User", "vierge", "vierge@user.fr", "v123", "paris", "france");
        utilisateurRepository.save(utilisateur4);
        System.out.println("---- Données insérées (FindAll) ----");
        for (Utilisateur utilisateur : utilisateurRepository.findAll()) {
                System.out.println("id : " + utilisateur.getId() + " - Nom : " + utilisateur.getNom() + " - Prenom : " + utilisateur.getPrenom() + " - Mail : "+ utilisateur.getMail() + " - Pseudo : " + utilisateur.getPseudo() + " -  Mdp : " + utilisateur.getMdp() + " - ville : "+utilisateur.getCity() + " - pays : "+utilisateur.getCountry());
        }
        System.out.println("---- Fin de l'initialisation de Utilisateurs ----");
        
        
        // Initialisation des données de Annonces
        System.out.println("[JavaDB] Initialisation des Annonces");
        System.out.println("---- Suppression de tous les annonces ----");
        annonceRepository.deleteAll();
        System.out.println("---- Ajout des annonces ----");
        Annonce annonce1= new Annonce("TV 4K", "Neuve, 4K", 450.00, utilisateur3, new Date(System.currentTimeMillis()-900000000));
        annonce1.setCandidat(utilisateur1);
        annonce1.setPrixCandidat(300.00);
        annonce1.setDateCandidat(new Date());
        annonce1.setEtatA("Cloturée");
        annonceRepository.save(annonce1);
        Annonce annonce2= new Annonce("Canard de bain", "Jaune, flotte", 3.00, utilisateur1, new Date(System.currentTimeMillis()-800000000));
        annonce2.setCandidat(utilisateur2);
        annonce2.setPrixCandidat(2.50);
        annonce2.setEtatA("Optionnée");
        annonce2.setDateCandidat(new Date());
        annonceRepository.save(annonce2);
        Annonce annonce3= new Annonce("Table + chaises", "Table blanche avec 4 chaises laquees", 100.00, utilisateur2, new Date(System.currentTimeMillis()-700000000));
        annonce3.setCandidat(utilisateur3);
        annonce3.setPrixCandidat(80.00);
        annonce3.setEtatA("Optionnée");
        annonce3.setDateCandidat(new Date());
        annonceRepository.save(annonce3);
        annonceRepository.save(new Annonce("Audi A3", "Audi A 3 - II (2) Sportback 2.0 TDI 140 S Line 7CV", 13900.00, utilisateur3, new Date(System.currentTimeMillis()-600000000)));
        annonceRepository.save(new Annonce("Tableau NY", "Tableau New York, Neuf", 10.00, utilisateur1, new Date(System.currentTimeMillis()-500000000)));
        annonceRepository.save(new Annonce("Hand Spinner", "Hand Spinner, vert, neuf", 6.00, utilisateur2, new Date(System.currentTimeMillis()-400000000)));
        Annonce annonce7 = new Annonce("Lego Star Wars", "Lego vaisseau Star wars neuf, avec boite scéllée", 75.00, utilisateur3, new Date(System.currentTimeMillis()-300000000));
        annonce7.setEtatA("Cloturée");
        annonceRepository.save(annonce7);
        Annonce annonce8 = new Annonce("Livre C++", "Livre usé : Comment réussir son partiel de C++ haut la main !", 10.00, utilisateur1, new Date(System.currentTimeMillis()-200000000));
        annonce8.setEtatA("Cloturée");
        annonceRepository.save(annonce8);
        Annonce annonce9 = new Annonce("iPhone 6S", "iPhone 6S 64GO pour pièces détachées ou comme boomrang", 500.00, utilisateur2, new Date(System.currentTimeMillis()-100000000));
        annonce9.setEtatA("Cloturée");
        annonce9.setCandidat(utilisateur2);
        annonce9.setPrixCandidat(2.50);
        annonce9.setDateCandidat(new Date());
        annonceRepository.save(annonce9);
        System.out.println("---- Données insérées (FindAll) ----");
        for (Annonce annonce : annonceRepository.findAll()) {
                System.out.println("id : " + annonce.getIdA() + " - Nom : " + annonce.getNomA() + " - description : " + annonce.getDescriptionA() + " - prix : " + annonce.getPrixA() + " - Id créateur : " + annonce.getCreateur() + " - Date Création : " + annonce.getDateCreaA() + " - Id Candidat : " + annonce.getCandidat() + " - Prix candidat : " + annonce.getPrixCandidat() + " - Date Candidat : " + annonce.getDateCandidat() + " - Etat : " + annonce.getEtatA());
        }
        System.out.println("---- Fin de l'initialisation de Annonces ----");
        
        
        // Initialisation des données de MongoDB --> Commentaires
        System.out.println("[MongoDB] Initialisation des données");
        System.out.println("---- Suppression de tous les commentaires ----");
        commentaireRepository.deleteAll();
        System.out.println("---- Ajout des commentaires ----");
        commentaireRepository.save(new Commentaire(1, 2, "On peut être livré par la poste ?", new Date(System.currentTimeMillis()-900000000)));
        commentaireRepository.save(new Commentaire(1, 3, "On peut le faire, mais je ne rembourse pas les dégats lors de la livraison.", new Date(System.currentTimeMillis()-800000000)));
        commentaireRepository.save(new Commentaire(1, 2, "La télécommande est fournie ?", new Date(System.currentTimeMillis()-700000000)));
        commentaireRepository.save(new Commentaire(2, 2, "Jolie petit canard", new Date(System.currentTimeMillis()-600000000)));
        commentaireRepository.save(new Commentaire(2, 3, "Déjà utilisé je pense...", new Date(System.currentTimeMillis()-500000000)));
        commentaireRepository.save(new Commentaire(3, 1, "Pouvez-vous m'envoyer une photo par mail à 4ever@bordeaux.fr ?", new Date(System.currentTimeMillis()-400000000)));
        commentaireRepository.save(new Commentaire(3, 3, "Les chaises sont de quelle couleur ?", new Date(System.currentTimeMillis()-300000000)));
        commentaireRepository.save(new Commentaire(4, 1, "La carte grise est avec ?", new Date(System.currentTimeMillis()-200000000)));
        System.out.println("---- Données insérées (FindAll) ----");
        for (Commentaire commentaire : commentaireRepository.findAll()) {
                System.out.println("idC : " + commentaire.getIdC() + " - idA : " + commentaire.getIdA() + " - idU : " + commentaire.getIdU() + " - texte : " + commentaire.getTexte() + " - dateCreation : " + commentaire.getDateCreation());
        }
        System.out.println("---- Fin de l'initialisation de MongoDB ----");

    }
}
