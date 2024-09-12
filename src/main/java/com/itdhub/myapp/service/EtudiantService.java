package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.repository.EtudiantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> lireTous() {
        return etudiantRepository.findAll();
    }

    public Etudiant lireParId(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant creer(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant modifier(Long id, Etudiant etudiant) {
        Etudiant etudiantExistant = etudiantRepository.findById(id).orElse(null);
        if (etudiantExistant != null) {
            etudiantExistant.setNom(etudiant.getNom());
            etudiantExistant.setPrenom(etudiant.getPrenom());
            etudiantExistant.setEmail(etudiant.getEmail());
            etudiantExistant.setAdresse(etudiant.getAdresse());
            etudiantExistant.setTelephone(etudiant.getTelephone());
            etudiantExistant.setMotDePasse(etudiant.getMotDePasse());
            return etudiantRepository.save(etudiantExistant);
        }
        return null;
    }

    public void supprimer(Long id) {
        etudiantRepository.deleteById(id);
    }



}
