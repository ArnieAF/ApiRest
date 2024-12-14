package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.domain.repository.ReserveRepository;
import com.api.api_biblioteca.domain.Reservation;
import com.api.api_biblioteca.persistence.crud.ReservaCrudRepository;
import com.api.api_biblioteca.persistence.entity.Reserva;
import com.api.api_biblioteca.persistence.mapper.ReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository implements ReserveRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    @Autowired
    private ReserveMapper mapper;


    @Override
    public List<Reservation> findByUserId(int userId) {
        List<Reserva> reservas = reservaCrudRepository.findByUsuario_IdUsuario(userId);
        return mapper.toReserves(reservas);
    }

    @Override
    public List<Reservation> findByBookId(int bookId) {
        List<Reserva> reservas = reservaCrudRepository.findByLibro_IdLibro(bookId);
        return mapper.toReserves(reservas);
    }

    @Override
    public Optional<Reservation> findByUserIdAndBookId(int userId, int bookId) {
        Optional<Reserva> reserva = reservaCrudRepository.findByUsuario_IdUsuarioAndLibro_IdLibro(userId,bookId);
        return reserva.map(reserva1 -> mapper.toReservation(reserva1));
    }

    @Override
    public List<Reservation> findByReservationDateAfter(LocalDateTime date) {
        List<Reserva>reservas = reservaCrudRepository.findByFechaReservaAfter(date);
        return mapper.toReserves(reservas);
    }

    @Override
    public List<Reservation> findByExpirationDateBefore(LocalDateTime date) {
        List<Reserva>reservas = reservaCrudRepository.findByFechaExpiracionAfter(date);
        return mapper.toReserves(reservas);
    }

    @Override
    public long countByExpirationDateAfter(LocalDateTime date) {
        return reservaCrudRepository.countByFechaExpiracionAfter(date);
    }

    @Override
    public boolean existsByIdAndExpirationDateBefore(int reservationId, LocalDateTime date) {
        return reservaCrudRepository.existsByIdReservaAndFechaExpiracionBefore(reservationId,date);
    }

    @Override
    public Reservation save(Reservation reservation) {
        Reserva reserva = mapper.toReserva(reservation);
        return mapper.toReservation(reservaCrudRepository.save(reserva));
    }

    @Override
    public void delete(int reservationId) {
        reservaCrudRepository.deleteById(reservationId);
    }

}
