package com.itdhub.myapp.web.rest;
import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public List<Professeur> lireTous() {
        return professeurService.lireTous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> lireParId(@PathVariable Long id) {
        Professeur professeur = professeurService.lireParId(id);
        if (professeur != null) {
            return new ResponseEntity<>(professeur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Professeur> creer(@RequestBody Professeur professeur) {
        Professeur nouveauProfesseur = professeurService.creer(professeur);
        return new ResponseEntity<>(nouveauProfesseur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> modifier(@PathVariable Long id, @RequestBody Professeur professeur) {
        Professeur professeurModifie = professeurService.modifier(id, professeur);
        if (professeurModifie != null) {
            return new ResponseEntity<>(professeurModifie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        professeurService.supprimer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



