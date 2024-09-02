package com.itdhub.myapp.repository;

import com.itdhub.myapp.domain.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
