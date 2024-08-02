package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.repository.EtudiantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    public Etudiant createOrUpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}*/
@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    public Etudiant ajourEtudiant(Long id, Etudiant etudiant1) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("l'etudiant n'est pas dans la liste"));
        etudiant.setNom(etudiant1.getNom());
        etudiant.setPrenom(etudiant1.getPrenom());
        etudiant.setAdresse(etudiant1.getAdresse());
        etudiant.setEmail(etudiant1.getEmail());
        etudiant.setTelephone(etudiant1.getTelephone());
        return etudiantRepository.save(etudiant);
    }
    public void supprimeEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
