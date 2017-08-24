package com.company.service;

import com.company.domain.document.Tag;

public interface TagService {

    boolean isTagInDatabase(String tagName);

    Tag insertTagIntoDatabase(Tag tag);
}
