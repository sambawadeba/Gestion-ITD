package com.itdhub.myapp.web.rest;

import com.itdhub.myapp.domain.Notes;
import com.itdhub.myapp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    public NotesController(NotesService notesService) {
        this.notesService = notesService;

    }
    @GetMapping("")
    public List<Notes> getAllNotes() {
        return notesService.findAll();
    }


    @GetMapping("/{id}")
    public Notes getNotes(@PathVariable Long id) {
        return notesService.findById(id);
    }

    @PostMapping("")
    public Notes createNotes(@RequestBody Notes notes) {
        return notesService.save(notes);
    }

    @PutMapping("/{id}")
    public Notes updateNotes(@PathVariable Long id, @RequestBody Notes notes) {
        return notesService.update(id, notes);
    }



    @DeleteMapping("/{id}")
    public void deleteNotes(@PathVariable Long id) {
        notesService.delete(id);
    }
}
