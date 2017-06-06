package com.miage.lesouk.securityComponents;

import com.miage.lesouk.entite.Utilisateur;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entité Utilisateur
 * @author Youssef DARRAB - Manon FABAREZ - Aurore QUEILLE
 */

public class UserCredential implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id ;
    
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Utilisateur utilisateur;
    
    private String mdp;
    
    @ElementCollection
    private Set<String> roles;

    protected UserCredential() {
    }

    public UserCredential(Utilisateur utilisateur, String mdp) {
        this.utilisateur = utilisateur;
        this.mdp = mdp;
        this.roles = new HashSet<>();
    }

    public UserCredential(Utilisateur utilisateur, String mdp, Set<String> roles) {
        this.utilisateur = utilisateur;
        this.mdp = mdp;
        this.roles = roles;
    }

    public Utilisateur getUser() {
        return utilisateur;
    }

    public void setUser(Utilisateur user) {
        this.utilisateur = user;
    }

    public String getPassword() {
        return mdp;
    }

    public void setPassword(String password) {
        this.mdp = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public boolean containsRole(String r) {
        return roles.contains(r);
    }

    public boolean addRole(String r) {
        return roles.add(r);
    }

    public boolean removeRole(String r) {
        return roles.remove(r);
    }
    
}
