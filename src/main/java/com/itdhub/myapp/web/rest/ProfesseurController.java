package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.service.ProfesseurService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Long id) {
        Optional<Professeur> professeur = professeurService.getProfesseurById(id);
        return professeur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Professeur creerProfesseur(@RequestBody Professeur professeur) {
        return professeurService.creerOuajouterProfesseur(professeur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> ajouteProfesseur(@PathVariable Long id, @RequestBody Professeur professeur) {
        if (!professeurService.getProfesseurById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professeur.setId(id);
        Professeur ajouteProfesseur = professeurService.creerOuajouterProfesseur(professeur);
        return ResponseEntity.ok(ajouteProfesseur);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimeProfesseur(@PathVariable Long id) {
        if (!professeurService.getProfesseurById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professeurService.supprimeProfesseur(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/creer/proffesseur/{nom}/{prenom}/{adresse}/{telephone}/{email}/{matiere}")
    public Professeur createProfesseur(@PathVariable String nom,@PathVariable String prenom,@PathVariable String adresse,@PathVariable String telephone,@PathVariable String email,@PathVariable String matiere) {
        Professeur professeur = professeurService.getprofesseur(nom,prenom,adresse,telephone,email,matiere);
        return professeur;
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimeProfesseur(@PathVariable Long id) {
        if (!professeurService.getProfesseurById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professeurService.supprimeProfesseur(id);
        return ResponseEntity.noContent().build();
    }
}
