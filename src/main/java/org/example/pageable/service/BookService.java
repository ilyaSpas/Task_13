package org.example.pageable.service;

import org.example.pageable.entity.Book;
import org.example.pageable.exception.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book findById(Long id);

    Page<Book> findAll(Pageable pageable);
    Book update(Long id, Book book);

    void deleteById (Long id);
}
