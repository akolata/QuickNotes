package com.company.domain.document;

import com.company.domain.document.dto.TagDTO;
import org.springframework.data.annotation.Id;

public class Tag {

    public static final String FIND_ALL_TAGS = "TAGS_ALL";

    @Id
    private String id;

    private String name;

    public Tag(){}

    public Tag(String name){
        this.name = name;
    }

    public Tag(TagDTO tagDTO){
        this.name = tagDTO.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return id.equals(tag.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Tag[%s]",name);
    }

}
