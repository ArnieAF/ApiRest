package com.api.api_biblioteca.persistence.mapper;


import com.api.api_biblioteca.domain.Author;
import com.api.api_biblioteca.persistence.entity.Autor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {


    @Mappings({
            @Mapping(source = "idAutor",target = "autorId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "nacionalidad",target = "nacionality"),

    })
    Author toAuthor(Autor autor);
    List<Author>toAuthors(List<Autor>autors);

    @InheritInverseConfiguration
    Autor toAutor(Author author);
}
