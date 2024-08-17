package com.itdhub.myapp.repository;
import com.itdhub.myapp.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    boolean existsByIdEtudiant(String idEtudiant);
    Etudiant findByIdEtudiant(String username);
}
