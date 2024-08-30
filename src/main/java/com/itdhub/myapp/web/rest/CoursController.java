package com.itdhub.myapp.web.rest;
import com.itdhub.myapp.domain.Cours;
import com.itdhub.myapp.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @PostMapping("/charger")
    public ResponseEntity<String> chargerCours(@RequestParam("fichier") MultipartFile fichier) throws IOException, IOException {
        String message = coursService.enregistrerFichier(fichier);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<String> modifierCours(@PathVariable("id") Long id, @RequestParam("fichier") MultipartFile fichier) throws IOException {
        String message = coursService.modifierFichier(id, fichier);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<String> supprimerCours(@PathVariable("id") Long id) {
        String message = coursService.supprimerFichier(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCours(@PathVariable("id") Long id) {
        Cours cours = coursService.getCours(id);
        if (cours != null) {
            return ResponseEntity.ok(cours);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/tous")
    public ResponseEntity<List<Cours>> getAllCours() {
        List<Cours> coursList = coursService.getAllCours();
        return ResponseEntity.ok(coursList);
    }
}

