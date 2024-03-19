package org.example.pageable.service.imp;

import org.example.pageable.entity.Author;
import org.example.pageable.exception.AuthorNotFoundException;
import org.example.pageable.repository.AuthorRepository;
import org.example.pageable.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    public Author update(Long id, Author author){
        Author authorFromDB = findById(id);
        authorFromDB.setName(author.getName());
        authorFromDB.setLastName(author.getLastName());
        authorFromDB.setBookList(author.getBookList());
        return authorRepository.save(authorFromDB);
    }

    public void deleteById (Long id) {
        authorRepository.deleteById(id);
    }
}
