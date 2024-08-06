package com.itdhub.myapp.service;
import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.repository.EtudiantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant mettreAJourEtudiant(Long id, Etudiant infoEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(id).orElseThrow();
        etudiant.setNom(infoEtudiant.getNom());
        etudiant.setPrenom(infoEtudiant.getPrenom());
        etudiant.setAdresse(infoEtudiant.getAdresse());
        etudiant.setEmail(infoEtudiant.getEmail());
        etudiant.setTelephone(infoEtudiant.getTelephone());
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElseThrow();
    }

    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}

