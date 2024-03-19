package org.example.pageable.service.imp;

import org.example.pageable.entity.Book;
import org.example.pageable.exception.BookNotFoundException;
import org.example.pageable.repository.BookRepository;
import org.example.pageable.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book update(Long id, Book book){
        Book bookFromDB = findById(id);
        bookFromDB.setTitle(book.getTitle());
        bookFromDB.setYearOfWriting(book.getYearOfWriting());
        bookFromDB.setAuthor(book.getAuthor());
        return bookRepository.save(bookFromDB);
    }

    public void deleteById (Long id) {
        bookRepository.deleteById(id);
    }
}
