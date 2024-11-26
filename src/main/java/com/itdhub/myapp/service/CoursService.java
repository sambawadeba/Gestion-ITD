
package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Cours;
import com.itdhub.myapp.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    public String enregistrerFichier(MultipartFile fichier) throws IOException {
        Cours cours = new Cours();
        cours.setNomFichier(fichier.getOriginalFilename());
        cours.setTypeFichier(fichier.getContentType());
        cours.setDonneesFichier(fichier.getBytes());

        coursRepository.save(cours);
        return "Fichier chargé avec succès : " + fichier.getOriginalFilename();
    }

    public String modifierFichier(Long id, MultipartFile fichier) throws IOException {
        Optional<Cours> coursOptional = coursRepository.findById(id);
        if (coursOptional.isPresent()) {
            Cours cours = coursOptional.get();
            cours.setNomFichier(fichier.getOriginalFilename());
            cours.setTypeFichier(fichier.getContentType());
            cours.setDonneesFichier(fichier.getBytes());
            coursRepository.save(cours);
            return "Fichier modifié avec succès : " + fichier.getOriginalFilename();
        } else {
            return "Fichier non trouvé pour l'ID : " + id;
        }
    }

    public String supprimerFichier(Long id) {
        coursRepository.deleteById(id);
        return "Fichier supprimé avec succès pour l'ID : " + id;
    }

    public Cours getCours(Long id) {
        return coursRepository.findById(id).orElse(null);
    }
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }
}
