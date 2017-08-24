package com.company.domain.document.dto;

import javax.validation.constraints.Size;

public class TagDTO {

    @Size(min = 1, max = 10, message = "Tag name must be between {2} and {1}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Tag [%s]", name);
    }
}
