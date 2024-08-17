package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Professeur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    private List<Professeur> professeurs = new ArrayList<>();
    private Long idCounter = 1L;

    // Ajout de deux exemples de professeurs directement dans le service
    public ProfesseurService() {
        professeurs.add(new Professeur(idCounter++, "Bousso", "Samba", "Dakar", "samba.bousso@example.com", "76 543 32 34", "Philo"));
        professeurs.add(new Professeur(idCounter++, "Durand", "Marie", "789 Rue des Lilas, Marseille", "marie.durand@example.com", "0712345678", "Chimie"));
    }

    public Professeur creer(Professeur professeur) {
        professeur.setId(idCounter++);
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
        Professeur professeur = lireParId(id).orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
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

