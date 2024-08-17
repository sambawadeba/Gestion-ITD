package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Professeur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    private List<Professeur> professeurs = new ArrayList<>();
    private Long idcompter = 1L;

    // Ajout de deux exemples de professeurs directement dans le service
    public ProfesseurService() {
        professeurs.add(new Professeur(idcompter++, "Bousso", "Samba", "Dakar", "samba.bousso@gmail.com", "76 543 32 34", "Philo"));
        professeurs.add(new Professeur(idcompter++, "Sow", "Marie", "mbour", "marie.sow@gmail.com", "75 432 76 89", "Chimie"));
        professeurs.add(new Professeur(idcompter++, "ka", "Bouba", "kobacoro", "bouba.ka@gmail.com", "74 438 96 00", "Physique"));
    }

    public Professeur creer(Professeur professeur) {
        professeur.setId(idcompter++);
        professeurs.add(professeur);
        return professeur;
    }

    public List<Professeur> lireTous() {
        return professeurs;
    }

    public Optional<Professeur> lireParId(Long id) {
        return professeurs.stream().filter(professeur -> professeur.getId().equals(id)).findFirst();
    }
    public Professeur mettreAJour(Long id, Professeur professeurDetails) {
        Professeur professeur = lireParId(id)
            .orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
        professeur.setNom(professeurDetails.getNom());
        professeur.setPrenom(professeurDetails.getPrenom());
        professeur.setAdresse(professeurDetails.getAdresse());
        professeur.setEmail(professeurDetails.getEmail());
        professeur.setTelephone(professeurDetails.getTelephone());
        professeur.setMatiere(professeurDetails.getMatiere());
        return professeur;
    }

    public void supprimer(Long id) {
        Professeur professeur = lireParId(id).orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
        professeurs.remove(professeur);
    }
}

