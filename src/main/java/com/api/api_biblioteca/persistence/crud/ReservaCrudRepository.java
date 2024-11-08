package com.api.api_biblioteca.persistence.crud;

import com.api.api_biblioteca.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaCrudRepository extends JpaRepository<Reserva,Integer> {

    List<Reserva>findByUsuario_IdUsuario(int usuarioId); // Buscar reservas por usuario
    List<Reserva>findByLibro_IdLibro(int libroId); //Buscar reservas de un libro
    Optional<Reserva>findByUsuario_IdUsuarioAndLibro_IdLibro(int usuarioId, int libroId);//Verificar si un usuario ya reservó un libro específico
    List<Reserva>findByFechaReservaAfter(LocalDateTime fecha); //Encontrar las reservas despues de una fecha
    List<Reserva>findByFechaReservaBefore(LocalDateTime fecha); //Encontrar las reservas antes de una fecha
    List<Reserva>findByFechaExpiracionAfter(LocalDateTime now); //Reservas que no han expirado
    List<Reserva>findByFechaExpiracionBefore(LocalDateTime now); // Reservas que han expirado
    long countByFechaExpiracionAfter(LocalDateTime now); //Contar reservas activas
    boolean existsByIdReservaAndFechaExpiracionBefore(Integer idReserva, LocalDateTime now); // Verificar si una reserva ha expirado



}
