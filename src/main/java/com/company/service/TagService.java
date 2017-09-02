package com.company.service;

import com.company.domain.document.Tag;

import java.util.List;

public interface TagService {

    boolean isTagInDatabase(String tagName);

    Tag insertTagIntoDatabase(Tag tag);

    List<Tag> findAll();
}
