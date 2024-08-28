package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.EEmploiDuTemps;
import com.itdhub.myapp.repository.EEmploiDuTempsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EEmploiDuTempsService {

    private final EEmploiDuTempsRepository emploiDuTempsRepository;


    public EEmploiDuTempsService(EEmploiDuTempsRepository emploiDuTempsRepository) {
        this.emploiDuTempsRepository = emploiDuTempsRepository;
    }

    public List<EEmploiDuTemps> findByEtudiantId(Long etudiantId) {
        return emploiDuTempsRepository.findByEtudiantId(etudiantId);
    }
}
