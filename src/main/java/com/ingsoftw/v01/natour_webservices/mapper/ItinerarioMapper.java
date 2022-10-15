package com.ingsoftw.v01.natour_webservices.mapper;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItinerarioMapper {

    ItinerarioDto toDto(Itinerario itinerario);
    Itinerario toModel(ItinerarioDto itinerarioDto);
    List<ItinerarioDto> toDtos(List<Itinerario> itinerarioList);
    List<Itinerario> toModels(List<ItinerarioDto> itinerarioDtoList);
    
}


