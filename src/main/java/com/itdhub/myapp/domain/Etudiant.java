package com.itdhub.myapp.domain;

import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String idEtudiant;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String motDePasse;

    // Constructeurs

    public Etudiant(String idEtudiant, String nom, String prenom, String email, String adresse, String telephone, String motDePasse) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.motDePasse=motDePasse;
    }

    public Etudiant() {

    }

    // Getters et Setters
   /* public Long getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(Long numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}


