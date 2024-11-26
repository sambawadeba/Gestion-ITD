package com.itdhub.myapp.service;
import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> lireTous() {
        return professeurRepository.findAll();
    }

    public Professeur lireParId(Long id) {
        return professeurRepository.findById(id).orElse(null);
    }

    public Professeur creer(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public Professeur modifier(Long id, Professeur professeur) {
        Professeur professeurExistant = professeurRepository.findById(id).orElse(null);
        if (professeurExistant != null) {
            professeurExistant.setNom(professeur.getNom());
            professeurExistant.setPrenom(professeur.getPrenom());
            professeurExistant.setEmail(professeur.getEmail());
            professeurExistant.setAdresse(professeur.getAdresse());
            professeurExistant.setTelephone(professeur.getTelephone());
            professeurExistant.setMotDePasse(professeur.getMotDePasse());
            professeurExistant.setMatiere(professeur.getMatiere());
            return professeurRepository.save(professeurExistant);
        }
        return null;
    }

    public void supprimer(Long id) {
        professeurRepository.deleteById(id);
    }
}
