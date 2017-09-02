package com.company.repository;

import com.company.domain.document.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository
extends MongoRepository<Note, String>{

    List<Note> findAllByDescriptionContainingIgnoreCase(String description);

    List<Note> findAllByTitleContainingIgnoreCase(String title);

    List<Note> findAllByDescriptionContainingIgnoreCaseOrTitleContainingIgnoreCase(String description, String title);

}
