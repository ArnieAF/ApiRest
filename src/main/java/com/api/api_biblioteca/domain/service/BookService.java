package com.api.api_biblioteca.domain.service;

import com.api.api_biblioteca.domain.Book;
import com.api.api_biblioteca.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByAuthorId(int authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> findByAvailableTrue() {
        return bookRepository.findByAvailableTrue();
    }

    public List<Book> findByPublicationDateAfter(LocalDateTime date) {
        return bookRepository.findByPublicationDateAfter(date);
    }

    public List<Book> findByPublicationDateBefore(LocalDateTime date) {
        return bookRepository.findByPublicationDateBefore(date);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public boolean delete(String name) {
        return findByTitle(name).map(book -> {
            bookRepository.delete(book.getBookId());
            return true;
        }).orElse(false);
    }
}
