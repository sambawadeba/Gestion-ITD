package com.itdhub.myapp.web.rest.vm;


import com.itdhub.myapp.domain.EEmploiDuTemps;
import com.itdhub.myapp.service.mapper.EEmploiDuTempsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api")
    public class EEmploiDuTempsController {
    @Autowired

        private final EEmploiDuTempsService eEmploiDuTempsService;

        public EEmploiDuTempsController(EEmploiDuTempsService eEmploiDuTempsService) {
            this.eEmploiDuTempsService= eEmploiDuTempsService;
        }

        @GetMapping("/emploi/{etudiantId}")
        public List<EEmploiDuTemps> getEmploiDuTemps(Long etudiantId) {
            return eEmploiDuTempsService.findByEtudiantId(etudiantId);
        }
    }


