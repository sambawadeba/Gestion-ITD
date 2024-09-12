package com.itdhub.myapp.service;

import com.itdhub.myapp.domain.Notes;
import com.itdhub.myapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    public List<Notes> getNotesByEtudiantId(Long etudiantId) {

        return notesRepository.findByEtudiantId(etudiantId);
    }
}

