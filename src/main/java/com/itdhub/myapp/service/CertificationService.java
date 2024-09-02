package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Certification;
import com.itdhub.myapp.repository.StudentCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    @Autowired
    private StudentCertificationRepository certificationRepository;

    @Autowired
    private StudentCertificationRepository studentCertificationRepository;

    public List<Certification> getValidatedCertifications(Long etudiantId) {
        return studentCertificationRepository.findValidatedCertificationsByStudentId(etudiantId);
    }
}

