package com.company.domain.document.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NoteDTO {

    @NotEmpty
    @Size(min = 4, max=50, message = "Title must be between {2} and {1}")
    private String title;

    @NotEmpty
    @Size(min = 4, max = 200, message = "Description must be between {2} and {1}")
    private String description;

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


    @Override
    public String toString() {
        return "NoteDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
