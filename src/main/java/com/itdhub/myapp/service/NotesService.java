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

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;

    }


    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    public Notes save(Notes notes) {
        return notesRepository.save(notes);
    }
    public Notes findById(Long id) {
        return notesRepository.findById(id).get();
    }
    public void delete(Long id) {
        notesRepository.deleteById(id);
    }
    public Notes update(Long id,Notes notes) {
        Notes newNotes = notesRepository.findById(id).get();
        if (newNotes != null) {
            newNotes.setNotes(notes.getNotes());
            return notesRepository.save(newNotes);
        }
        return null;

    }
}

