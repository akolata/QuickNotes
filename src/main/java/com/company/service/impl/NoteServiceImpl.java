package com.company.service.impl;

import com.company.domain.document.Note;
import com.company.domain.document.dto.FindNoteDTO;
import com.company.repository.NoteRepository;
import com.company.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl
implements NoteService{

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note insert(Note note) {
        return noteRepository.insert(note);
    }

    @Override
    public List<Note> findNotesForGivenCriteria(FindNoteDTO findNoteCriteria) {


        if(findNoteCriteria.noCriteria()){
            return noteRepository.findAll();
        }else{

            List<Note> foundNotes = findNotesByTitleOrDescriptionWithoutTagCheck(findNoteCriteria);

            if(findNoteCriteria.findAllTags()){
                return foundNotes;
            }else{
                return foundNotes
                        .stream()
                        .filter((note) -> note.getTags().contains(findNoteCriteria.getTag()))
                        .collect(Collectors.toList());
            }
        }

    }

    @Override
    public void deleteNoteWithId(String id) {

        noteRepository.delete(id);
    }

    private List<Note> findNotesByTitleOrDescriptionWithoutTagCheck(FindNoteDTO findNoteCriteria){

        List<Note> foundNotes;

        if(findNoteCriteria.searchByDescriptionOnly()){
            foundNotes = noteRepository.findAllByDescriptionContainingIgnoreCase(findNoteCriteria.getDescription());
        }else if (findNoteCriteria.searchByTitleOnly()){
            foundNotes = noteRepository.findAllByTitleContainingIgnoreCase(findNoteCriteria.getTitle());
        }else if (findNoteCriteria.searchByTagOnly()){
            foundNotes = noteRepository.findAll();
        }else{
            foundNotes = noteRepository
                    .findAllByDescriptionContainingIgnoreCaseOrTitleContainingIgnoreCase(
                            findNoteCriteria.getDescription(), findNoteCriteria.getTitle());
        }

        return foundNotes;
    }
}
