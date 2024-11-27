package com.itdhub.myapp.web.rest;
import com.itdhub.myapp.domain.Etudiant;
import com.itdhub.myapp.domain.Notes;
import com.itdhub.myapp.service.EtudiantService;
import com.itdhub.myapp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> lireTous() {
        return etudiantService.lireTous();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> lireParId(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.lireParId(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Etudiant> creer(@RequestBody Etudiant etudiant) {
        Etudiant nouveauEtudiant = etudiantService.creer(etudiant);
        return new ResponseEntity<>(nouveauEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> modifier(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiantModifie = etudiantService.modifier(id, etudiant);
        if (etudiantModifie != null) {
            return new ResponseEntity<>(etudiantModifie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        etudiantService.supprimer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }}
    /*@Autowired
    private NotesService notesService;

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<Notes>> getNotes(@PathVariable Long id, Principal principal) {

        if (!principal.getName().equals(id.toString())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        List<Notes> notes = notesService.getNotesByEtudiantId(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}*/

