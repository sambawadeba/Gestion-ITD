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
    private ProfesseurRepository professeurRepository;

    /*public Professeur getprofesseur(String nom, String prenom,String adresse, String telephone, String email, String matiere) {
         Professeur professeur = new Professeur();
         professeur.setNom(nom);
         professeur.setPrenom(prenom);
         professeur.setAdresse(adresse);
         professeur.setTelephone(telephone);
         professeur.setEmail(email);
         professeur.setMatiere(matiere);
         return professeur;
     }
    public void supprimeProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }
    public Optional<Professeur> getProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }*/

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> getProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }

    public Professeur creerOuajouterProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public void supprimeProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }
}
