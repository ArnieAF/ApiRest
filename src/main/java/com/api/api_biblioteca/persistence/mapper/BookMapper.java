package com.api.api_biblioteca.persistence.mapper;

import com.api.api_biblioteca.domain.Book;
import com.api.api_biblioteca.persistence.entity.Libro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {AuthorMapper.class})
public interface BookMapper {

    @Mappings({
            @Mapping(source = "idLibro",target = "bookId"),
            @Mapping(source = "titulo",target = "title"),
            @Mapping(source = "autor",target = "author" ),
            @Mapping(source = "genero",target ="genre" ),
            @Mapping(source = "fechaPublicacion",target = "publicationDate"),
            @Mapping(source = "disponible",target = "available")
    })
    Book toBook(Libro libro);
    List<Book>toBooks(List<Libro>toLibros);


    @InheritInverseConfiguration
    Libro toLibro(Book book);


}
