package com.api.api_biblioteca.persistence.repository;

import com.api.api_biblioteca.domain.repository.UserRepository;
import com.api.api_biblioteca.domain.User;
import com.api.api_biblioteca.persistence.crud.UsuarioCrudRepository;
import com.api.api_biblioteca.persistence.entity.Usuario;
import com.api.api_biblioteca.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public Optional<User> findByEmail(String email) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByEmail(email);
        return usuario.map(usuario1 -> mapper.toUser(usuario1));
    }

    @Override
    public List<User> findByNameContaining(String name) {
        List<Usuario>usuarios = usuarioCrudRepository.findByNombreContaining(name);
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> findById(int userId) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByIdUsuario(userId);
        return usuario.map(usuario1 -> mapper.toUser(usuario1));
    }

    @Override
    public List<User> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        List<Usuario>usuarios = usuarioCrudRepository.findByFechaRegistroBetween(start,end);
        return mapper.toUsers(usuarios);
    }

    public boolean existsByEmail(String email){
        return usuarioCrudRepository.existsByEmail(email);
    }

    @Override
    public long countByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        return usuarioCrudRepository.countByFechaRegistroBetween(start,end);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(int userId) {
       usuarioCrudRepository.deleteById(userId);
    }


}
