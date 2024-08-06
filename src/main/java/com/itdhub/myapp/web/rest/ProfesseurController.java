package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.service.ProfesseurService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @PostMapping("/professeurs")
    public ResponseEntity<Professeur> creer(@RequestBody Professeur professeur) {
        Professeur result = professeurService.creer(professeur);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/professeurs")
    public List<Professeur> getAll() {
        return professeurService.getAll();
    }

    @GetMapping("/professeurs/{id}")
    public ResponseEntity<Professeur> getById(@PathVariable Long id) {
        return professeurService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/professeurs")
    public ResponseEntity<Professeur> mettreAJour(@RequestBody Professeur professeur) {
        Professeur result = professeurService.mettreAJour(professeur);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/professeurs/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        professeurService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}


