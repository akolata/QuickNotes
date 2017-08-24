package com.company.domain.document;

import com.company.domain.document.dto.NoteDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    private String title;
    private String description;

    @CreatedDate
    private LocalDateTime createdDate;

    private List<Tag> tags;

    public Note(){}

    public Note(NoteDTO noteDTO){
        this.title = noteDTO.getTitle();
        this.description = noteDTO.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setTagsFromStringList(List<String> tagsList) {
        List<Tag> tags = new LinkedList<>();

        for(String tag : tagsList){
            tags.add(new Tag(tag));
        }

        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("Note[%s,%s, %s, %s]TAGS =", id, title, description, createdDate.format(formatter)) + tags;
    }

}
