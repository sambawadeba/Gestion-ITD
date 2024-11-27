package com.itdhub.myapp.repository;
import com.itdhub.myapp.domain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface NotesRepository extends JpaRepository<Notes, Long> {
        List<Notes> findByEtudiantId(Long etudiantId);
        Optional<Notes> findById(Long id);
    }


