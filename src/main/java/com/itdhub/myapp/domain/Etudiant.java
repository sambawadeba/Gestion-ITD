package com.itdhub.myapp.domain;

import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroEtudiant;

    @Column(nullable = false, unique = true)
    private String idEtudiant;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    private String adresse;
    private String telephone;

    // Constructeurs
    public Etudiant() {}

    public Etudiant(String idEtudiant, String nom, String prenom, String email, String adresse, String telephone) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Getters et Setters
    public Long getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(Long numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
