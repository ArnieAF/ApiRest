package com.api.api_biblioteca.persistence.mapper;

import com.api.api_biblioteca.domain.Reservation;
import com.api.api_biblioteca.persistence.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,BookMapper.class})
public interface ReserveMapper {

    @Mappings({
            @Mapping(source = "idReserva",target = "reservationId"),
            @Mapping(source = "usuario",target = "user"),
            @Mapping(source = "libro",target = "book"),
            @Mapping(source = "fechaReserva",target = "reservationDate"),
            @Mapping(source = "fechaExpiracion",target = "expirationDate"),
    })
    Reservation toReservation(Reserva reserva);
    List<Reservation>toReserves(List<Reserva>toReservas);


    @InheritInverseConfiguration
    Reserva toReserva(Reservation reservation);

}
