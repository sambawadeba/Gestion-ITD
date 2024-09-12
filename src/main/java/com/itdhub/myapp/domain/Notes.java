package com.itdhub.myapp.domain;
import jakarta.persistence.*;


@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String module;
    private Double notes;

    @ManyToOne
    @JoinColumn(name = "etudiant_notes", nullable = false)
    private Etudiant etudiant;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Double getNotes() {
        return notes;
    }

    public void setNotes(Double note) {
        this.notes = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}


