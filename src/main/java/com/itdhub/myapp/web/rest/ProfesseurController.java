package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Professeur;
import com.itdhub.myapp.service.ProfesseurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @PostMapping("/creer")
    public Professeur creer(@RequestBody Professeur professeur) {
        return professeurService.creer(professeur);
    }

    @GetMapping("/lireTous")
    public List<Professeur> lireTous() {
        return professeurService.lireTous();
    }

    @GetMapping("/lireParId/{id}")
    public Professeur lireParId(@PathVariable Long id) {
        return professeurService.lireParId(id).orElseThrow(() -> new RuntimeException("Professeur non trouvé"));
    }

    @PutMapping("/mettreAJour/{id}")
    public Professeur mettreAJour(@PathVariable Long id, @RequestBody Professeur professeurDetails) {
        return professeurService.mettreAJour(id, professeurDetails);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id) {
        professeurService.supprimer(id);
    }
}

