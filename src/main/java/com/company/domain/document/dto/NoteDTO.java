package com.company.domain.document.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class NoteDTO {

    @Size(min = 4, max=50, message = "Title must be between {2} and {1}")
    private String title;

    @Size(min = 4, max = 200, message = "Description must be between {2} and {1}")
    private String description;

    @NotEmpty
    private List<String> tagsList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
