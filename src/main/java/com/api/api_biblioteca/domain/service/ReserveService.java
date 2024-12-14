package com.api.api_biblioteca.domain.service;

import com.api.api_biblioteca.domain.Reservation;
import com.api.api_biblioteca.domain.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public List<Reservation> findByUserId(int userId) {
        return reserveRepository.findByUserId(userId);
    }

    public List<Reservation> findByBookId(int bookId) {
        return reserveRepository.findByBookId(bookId);
    }

    public Optional<Reservation> findByUserIdAndBookId(int userId, int bookId) {
        return reserveRepository.findByUserIdAndBookId(userId, bookId);
    }

    public List<Reservation> findByReservationDateAfter(LocalDateTime date) {
        return reserveRepository.findByReservationDateAfter(date);
    }

    public List<Reservation> findByExpirationDateBefore(LocalDateTime date) {
        return reserveRepository.findByExpirationDateBefore(date);
    }

    public long countByExpirationDateAfter(LocalDateTime date) {
        return reserveRepository.countByExpirationDateAfter(date);
    }

    public boolean existsByIdAndExpirationDateBefore(int reservationId, LocalDateTime date) {
        return reserveRepository.existsByIdAndExpirationDateBefore(reservationId, date);
    }

    public Reservation save(Reservation reservation) {
        return reserveRepository.save(reservation);
    }

    public boolean delete(int userId, int bookId) {
        return reserveRepository.findByUserIdAndBookId(userId, bookId).map(reservation -> {
            reserveRepository.delete(reservation.getReservationId());
            return true;
        }).orElse(false);
    }
}
