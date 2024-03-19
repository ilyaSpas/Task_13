package org.example.pageable.service;

import org.example.pageable.entity.Author;
import org.example.pageable.exception.AuthorNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author findById(Long id);

    Page<Author> findAll(Pageable pageable);

    Author update(Long id, Author author);

    void deleteById (Long id);
}
