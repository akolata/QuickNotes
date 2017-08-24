package com.company.repository;

import com.company.domain.document.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository
extends MongoRepository<Tag, String>{

    List<Tag> findByNameIgnoreCase(String name);

}
