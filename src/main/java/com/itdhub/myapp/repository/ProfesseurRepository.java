package com.itdhub.myapp.repository;
import com.itdhub.myapp.domain.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
