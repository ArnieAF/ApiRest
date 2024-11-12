package com.api.api_biblioteca.domain.repository;

public interface AuthorRepository {

    List<Author> findByNameContaining(String name);
    Optional<Author> findByName(String name);
    List<Author> findByNationality(String nationality);
    List<Author> findAllByOrderByNameAsc();
    List<Author> findAllByOrderByNameDesc();
    long countByNationality(String nationality);
    Author save(Author author);
    void delete(int authorId);
}
