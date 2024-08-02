package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.repository.EtudiantRepository;
import com.itdhub.myapp.service.EtudiantService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantById(id);
        return etudiant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        if (!etudiantService.getEtudiantById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        etudiant.setId(id);
        Etudiant updatedEtudiant = etudiantService.createOrUpdateEtudiant(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        if (!etudiantService.getEtudiantById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}*/
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant creerEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.creerEtudiant(etudiant);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id).orElseThrow(() -> new RuntimeException("l'etudiant n'est pas dans la liste"));
    }

    @PutMapping("/{id}")
    public Etudiant ajourEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant1) {
        return etudiantService.ajourEtudiant(id, etudiant1);
    }
    @DeleteMapping("/{id}")
    public void supprimeEtudiant(@PathVariable Long id) {
        etudiantService.supprimeEtudiant(id);
    }
}
