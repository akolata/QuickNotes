package com.company.repository;

import com.company.domain.document.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository
extends MongoRepository<Note, String>{

    Note findOneByDescription(String description);
}
