package com.api.api_biblioteca.domain.repository;

public interface UserRepository {

    Optional<User> findByEmail(String email);
    List<User> findByNameContaining(String name);
    Optional<User> findById(int userId);
    List<User> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end);
    boolean existsByEmail(String email);
    long countByRegistrationDateBetween(LocalDateTime start, LocalDateTime end);
    User save(User user);
    void delete(int userId);

}
