package org.example.pageable.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.pageable.entity.Author;
import org.example.pageable.entity.Book;
import org.example.pageable.entity.view.Views;
import org.example.pageable.service.imp.AuthorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorServiceImp authorService;

    @Autowired
    public AuthorController(AuthorServiceImp authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/new")
    public ResponseEntity<Author> saveUser(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    @GetMapping
    @JsonView(Views.Author.class)
    public ResponseEntity<Page<Author>> findAll(Pageable pageable) {
        return new ResponseEntity<>(authorService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Author> updateUser(@PathVariable("id") Long id, @RequestBody Author author) {
        return new ResponseEntity<>(authorService.update(id, author), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public HttpStatus deleteById(@PathVariable("id") Long id) {
        authorService.deleteById(id);
        return HttpStatus.OK;
    }
}
