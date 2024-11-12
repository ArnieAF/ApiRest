package com.api.api_biblioteca.domain.repository;

import com.api.api_biblioteca.domain.service.Book;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

public interface BookRepository {

    List<Book> findByTitleContaining(String title);
    Optional<Book> findByTitle(String title);
    List<Book> findByAuthorId(int authorId);
    List<Book> findByGenre(String genre);
    List<Book> findByAvailableTrue();
    List<Book> findByPublicationDateAfter(LocalDateTime date);
    List<Book> findByPublicationDateBefore(LocalDateTime date);
    Book save(Book book);
    void delete(int bookId);
}
