package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.domain.repository.BookRepository;
import com.api.api_biblioteca.domain.service.Author;
import com.api.api_biblioteca.domain.service.Book;
import com.api.api_biblioteca.domain.service.Genre;
import com.api.api_biblioteca.persistence.crud.LibroCrudRepository;
import com.api.api_biblioteca.persistence.entity.Autor;
import com.api.api_biblioteca.persistence.entity.Genero;
import com.api.api_biblioteca.persistence.entity.Libro;
import com.api.api_biblioteca.persistence.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository implements BookRepository {

    @Autowired
    private LibroCrudRepository libroCrudRepository;

    @Autowired
    private BookMapper mapper;

    @Override
    public List<Book> findByTitleContaining(String title) {
        List<Libro>libros = libroCrudRepository.findByTituloContaining(title);
        return mapper.toBooks(libros);

    }

    @Override
    public Optional<Book> findByTitle(String title) {
        Optional<Libro>libro =libroCrudRepository.findByTitulo(title);
        return libro.map(libro1 -> mapper.toBook(libro1));
    }

    @Override
    public List<Book> findByAuthorId(int authorId) {
        List<Libro> libros = libroCrudRepository.findByAutor_IdAutor(authorId);
        return mapper.toBooks(libros);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        Genero genero = null;

        try {
            genero = Genero.valueOf(genre.toUpperCase());

            if (genero != Genero.FICTION && genero != Genero.SCIENCE_FICTION && genero != Genero.FANTASY &&
                    genero != Genero.BIOGRAPHY && genero != Genero.HISTORY && genero != Genero.MYSTERY && genero != Genero.ROMANCE) {
                throw new IllegalArgumentException("Género no válido: " + genre);
            }

        } catch (IllegalArgumentException e) {
            // Si el genre no es válido o no corresponde a un valor del enum
            throw new IllegalArgumentException("Género no válido: " + genre);
        }

        List<Libro> libros = libroCrudRepository.findByGenero(genero);
        return mapper.toBooks(libros);
    }


    @Override
    public List<Book> findByAvailableTrue() {
        List<Libro>libros = libroCrudRepository.findByDisponibleTrue();
        return mapper.toBooks(libros);
    }

    @Override
    public List<Book> findByPublicationDateAfter(LocalDateTime date) {
        List<Libro>libros = libroCrudRepository.findByFechaPublicacionAfter(date);
        return mapper.toBooks(libros);
    }

    @Override
    public List<Book> findByPublicationDateBefore(LocalDateTime date) {
        List<Libro>libros = libroCrudRepository.findByFechaPublicacionBefore(date);
        return mapper.toBooks(libros);
    }

    @Override
    public Book save(Book book) {
        Libro libro = mapper.toLibro(book);
        return mapper.toBook(libroCrudRepository.save(libro));
    }

    @Override
    public void delete(int bookId) {
        libroCrudRepository.deleteById(bookId);
    }
}
