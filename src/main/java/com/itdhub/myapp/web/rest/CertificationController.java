package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Certification;
import com.itdhub.myapp.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping("/certifications/{etudiantId}")
    public ResponseEntity<List<Certification>> getValidatedCertifications(@PathVariable Long etudiantId) {
        List<Certification> certifications = certificationService.getValidatedCertifications(etudiantId);
        return ResponseEntity.ok(certifications);
    }
}

