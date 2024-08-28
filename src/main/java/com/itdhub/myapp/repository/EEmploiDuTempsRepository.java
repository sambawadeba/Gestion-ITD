package com.itdhub.myapp.repository;

import com.itdhub.myapp.domain.EEmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EEmploiDuTempsRepository extends JpaRepository<EEmploiDuTemps, Long> {
    List<EEmploiDuTemps> findByEtudiantId(Long etudiantId);
}
