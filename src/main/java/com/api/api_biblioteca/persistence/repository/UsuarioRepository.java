package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.persistence.crud.UsuarioCrudRepository;
import com.api.api_biblioteca.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public Optional<Usuario> getByEmail(String email){
        return usuarioCrudRepository.findByEmail(email);
    }

    public List<Usuario> getByNombreContaining(String nombre){
        return usuarioCrudRepository.findByNombreContaining(nombre);
    }

    public List<Usuario> getByNombre(String nombre){
        return usuarioCrudRepository.findByNombre(nombre);
    }

    public Optional<Usuario>getByIdUsuario(int idUsuario){
        return usuarioCrudRepository.findByIdUsuario(idUsuario);
    }

    public List<Usuario>getByFechaRegistroBetween(LocalDateTime fecha1, LocalDateTime fecha2){
        return usuarioCrudRepository.findByFechaRegistroBetween(fecha1,fecha2);
    }

    public List<Usuario>getByFechaRegistroAfter(LocalDateTime fecha){
        return usuarioCrudRepository.findByFechaRegistroAfter(fecha);
    }

    public  List<Usuario>getByFechaRegistroBefore(LocalDateTime fecha){
        return usuarioCrudRepository.findByFechaRegistroBefore(fecha);
    }

    public boolean existsByEmail(String email){
        return usuarioCrudRepository.existsByEmail(email);
    }

    public long countByFechaRegistroBetween(LocalDateTime fecha1, LocalDateTime fecha2){
        return usuarioCrudRepository.countByFechaRegistroBetween(fecha1,fecha2);
    }

}
