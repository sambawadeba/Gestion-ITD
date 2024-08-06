package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.repository.EtudiantRepository;
import com.itdhub.myapp.service.EtudiantService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant creerEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.creerEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant mettreAJourEtudiant(@PathVariable Long id, @RequestBody Etudiant infoEtudiant) {
        return etudiantService.mettreAJourEtudiant(id, infoEtudiant);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
        return ResponseEntity.ok().build();
    }
}
