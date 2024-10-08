package com.itdhub.myapp.domain;

import jakarta.persistence.*;
@Entity

public class Professeur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String idProfesseur;

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
    @Column(nullable = false)
    private String matiere;

        // Constructeurs

        public Professeur(String idProfesseur, String nom, String prenom, String email, String adresse, String telephone, String motDePasse, String matiere) {
            this.idProfesseur = idProfesseur;
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.adresse = adresse;
            this.telephone = telephone;
            this.motDePasse=motDePasse;
            this.matiere=matiere;
        }

    public Professeur() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(String idProfesseur) {
        this.idProfesseur = idProfesseur;
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

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
