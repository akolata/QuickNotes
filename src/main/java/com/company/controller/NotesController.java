package com.company.controller;

import com.company.domain.document.Note;
import com.company.domain.document.Tag;
import com.company.domain.document.dto.NoteDTO;
import com.company.repository.NoteRepository;
import com.company.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NotesController {

    private static final String ADD_NOTE_PAGE_NAME = "add_note";

    private NoteRepository noteRepository;
    private TagRepository tagRepository;

    @Autowired
    public NotesController(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping("/add")
    public String prepareAddNoteForm(Model model){
        model.addAttribute("note", new NoteDTO());

        return ADD_NOTE_PAGE_NAME;
    }

    @PostMapping("/add")
    public String processAddNoteForm(@Valid @ModelAttribute(name = "note") NoteDTO noteDTO, BindingResult bindingResult,
                                     @RequestParam("tagsList") List<String> tagsList){

        if(bindingResult.hasErrors()){
            return ADD_NOTE_PAGE_NAME;
        }

        Note note = new Note(noteDTO);

        if(tagsList == null){
            note.setTags(new ArrayList<>());
        }else{
            note.setTagsFromStringList(tagsList);
        }

        noteRepository.save(note);

        return ADD_NOTE_PAGE_NAME;
    }

    @ModelAttribute("tags")
    public List<Tag> tags(){
        return tagRepository.findAll();
    }

}
