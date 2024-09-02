package com.itdhub.myapp.repository;

import com.itdhub.myapp.domain.Certification;
import com.itdhub.myapp.domain.StudentCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCertificationRepository extends JpaRepository<StudentCertification, Long> {

    @Query("SELECT c FROM Certification c JOIN StudentCertification sc ON c.id = sc.certificationId WHERE sc.studentId = :studentId AND sc.validated = true")
    List<Certification> findValidatedCertificationsByStudentId(@Param("studentId") Long studentId);
}


