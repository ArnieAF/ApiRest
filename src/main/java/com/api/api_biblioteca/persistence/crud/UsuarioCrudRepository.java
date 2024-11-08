package com.api.api_biblioteca.persistence.crud;

import com.api.api_biblioteca.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario>findByEmail(String email); //Buscar por email
    List<Usuario>findByNombreContaining(String nombre); //Busca nombre cuyo nombre tenga l secuencia de caracteres especificada(paremetro)(parcial)
    List<Usuario> findByNombre(String nombre); //Buscar por nombre(Lista)(Exacta)
    Optional<Usuario>findByIdUsuario(int idUsuario); //Buscar por id de usuario
    List<Usuario>findByFechaRegistroBetween(LocalDateTime fecha1,LocalDateTime fecha2); //Lista de usuarios que se registraron en un intervalo de fechas
    List<Usuario>findByFechaRegistroAfter(LocalDateTime fecha);//Lista de usuarios despues de una fecha
    List<Usuario>findByFechaRegistroBefore(LocalDateTime fecha);//Lista de usuarios antes de una fecha
    boolean existsByEmail(String email); //Ayuda a verifica un email si ya esta registrado(Util para evitar duplicados cuando se creen nuevos usuarios)
    long countByFechaRegistroBetween(LocalDateTime fecha1, LocalDateTime fecha2); //Cuantos usuarios se registraron en un periodo especifico


}
