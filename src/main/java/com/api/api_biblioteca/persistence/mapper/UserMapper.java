package com.api.api_biblioteca.persistence.mapper;

import com.api.api_biblioteca.domain.service.User;
import com.api.api_biblioteca.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario",target = "userId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "fechaRegistro",target = "registerDate"),
            @Mapping(source = "email",target = "email")
    })
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);

}
