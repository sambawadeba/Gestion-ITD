package com.itdhub.myapp.domain;

import jakarta.persistence.*;
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomFichier;

    @Lob
    private byte[] donneesFichier;

    @Column(nullable = false)
    private String typeFichier;

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public byte[] getDonneesFichier() {
        return donneesFichier;
    }

    public void setDonneesFichier(byte[] donneesFichier) {
        this.donneesFichier = donneesFichier;
    }

    public String getTypeFichier() {
        return typeFichier;
    }

    public void setTypeFichier(String typeFichier) {
        this.typeFichier = typeFichier;
    }
}
