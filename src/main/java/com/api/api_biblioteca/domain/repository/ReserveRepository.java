package com.api.api_biblioteca.domain.repository;

public interface ReserveRepository {

    List<Reservation> findByUserId(int userId);
    List<Reservation> findByBookId(int bookId);
    Optional<Reservation> findByUserIdAndBookId(int userId, int bookId);
    List<Reservation> findByReservationDateAfter(LocalDateTime date);
    List<Reservation> findByExpirationDateBefore(LocalDateTime date);
    long countByExpirationDateAfter(LocalDateTime date);
    boolean existsByIdAndExpirationDateBefore(int reservationId, LocalDateTime date);
    Reservation save(Reservation reservation);
    void delete(int reservationId);
}