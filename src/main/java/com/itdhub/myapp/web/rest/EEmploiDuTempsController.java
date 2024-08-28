package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.EEmploiDuTemps;
import com.itdhub.myapp.service.EEmploiDuTempsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EEmploiDuTempsController {

    private final EEmploiDuTempsService eEmploiDuTempsService;


    public EEmploiDuTempsController(EEmploiDuTempsService eEmploiDuTempsService) {
        this.eEmploiDuTempsService = eEmploiDuTempsService;
    }

    @GetMapping("/emploi/{etudiantId}")
    public List<EEmploiDuTemps> getEmploiDuTemps(@PathVariable ("etudiantId") Long etudiantId) {
        System.out.println("Received request for etudiantId: " + etudiantId);
        return eEmploiDuTempsService.findByEtudiantId(etudiantId);
    }
}
