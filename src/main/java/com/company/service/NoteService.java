package com.company.service;

import com.company.domain.document.Note;
import com.company.domain.document.dto.FindNoteDTO;

import java.util.List;

public interface NoteService {

    List<Note> findNotesForGivenCriteria(FindNoteDTO findNoteCriteria);

    Note insert(Note note);

    void deleteNoteWithId(String id);

}
