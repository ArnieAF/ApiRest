package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.persistence.crud.ReservaCrudRepository;
import com.api.api_biblioteca.persistence.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getByUsuarioByIdUsuario(int usuarioId){
        return reservaCrudRepository.findByUsuario_IdUsuario(usuarioId);
    }

    public List<Reserva>getByLibroByIdLibro(int libroId){
        return reservaCrudRepository.findByLibro_IdLibro(libroId);
    }

    public Optional<Reserva> getByUsuarioByIdUsuarioAndLibroByIdLibro(int usuarioId, int libroId){
        return reservaCrudRepository.findByUsuario_IdUsuarioAndLibro_IdLibro(usuarioId,libroId);
    }

    public  List<Reserva>getByFechaReservaAfter(LocalDateTime fecha){
        return reservaCrudRepository.findByFechaReservaAfter(fecha);
    }

    public  List<Reserva>getByFechaReservaBefore(LocalDateTime fecha){
        return reservaCrudRepository.findByFechaReservaBefore(fecha);
    }

    public List<Reserva>getByFechaExpiracionAfter(LocalDateTime now){
        return reservaCrudRepository.findByFechaExpiracionAfter(now);
    }

    public List<Reserva>getByFechaExpiracionBefore(LocalDateTime now){
        return reservaCrudRepository.findByFechaExpiracionBefore(now);
    }

    public long countByFechaExpiracionAfter(LocalDateTime now){
        return reservaCrudRepository.countByFechaExpiracionAfter(now);
    }

    public boolean existsByIdReservaAndFechaExpiracionBefore(Integer idReserva, LocalDateTime now){
        return reservaCrudRepository.existsByIdReservaAndFechaExpiracionBefore(idReserva,now);
    }



}
