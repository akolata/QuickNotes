package com.company.domain.document.dto;

import com.company.domain.document.Tag;

public class FindNoteDTO {

    private String title;

    private String description;

    private String tag;

    public FindNoteDTO(){
        this.title = "";
        this.description = "";
        this.tag = "";
    }

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean findAllTags(){
        return tag.equals(Tag.FIND_ALL_TAGS);
    }

    public boolean noCriteria(){
        return findAllTags() && title.equals("") && description.equals("");
    }

    public boolean searchByTitleOnly(){
        return !title.equals("") && description.equals("");
    }

    public boolean searchByDescriptionOnly(){
        return !description.equals("") && title.equals("");
    }

    public boolean searchByTagOnly(){
        return description.equals("") && title.equals("");
    }

    @Override
    public String toString() {
        return "FindNoteDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
