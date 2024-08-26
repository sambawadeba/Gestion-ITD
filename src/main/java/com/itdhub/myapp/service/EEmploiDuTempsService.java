package com.itdhub.myapp.service.mapper;

import com.itdhub.myapp.domain.EEmploiDuTemps;
import com.itdhub.myapp.repository.EEmploiDuTempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EEmploiDuTempsService {

    @Autowired
    private EEmploiDuTempsRepository emploiDuTempsRepository;

    public List<EEmploiDuTemps> findByEtudiantId(Long etudiantId) {
        return emploiDuTempsRepository.findByEtudiantId(etudiantId);
    }
}



