package com.company.service.impl;

import com.company.domain.document.Tag;
import com.company.repository.TagRepository;
import com.company.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl
implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public boolean isTagInDatabase(String tagName) {
        return !tagRepository.findByName(tagName).isEmpty();
    }

    @Override
    public Tag insertTagIntoDatabase(Tag tag) {
        return tagRepository.insert(tag);
    }

}
