package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.repository.ProfesseurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesseurService {
    @Autowired
    private final ProfesseurRepository professeurRepository;
    public ProfesseurService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public Professeur creer(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public List<Professeur> getAll() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> getById(Long id) {
        return professeurRepository.findById(id);
    }

    public Professeur mettreAJour(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public void supprimer(Long id) {
        professeurRepository.deleteById(id);
    }
}

