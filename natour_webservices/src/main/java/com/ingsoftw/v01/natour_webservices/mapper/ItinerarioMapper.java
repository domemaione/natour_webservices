package com.ingsoftw.v01.natour_webservices.mapper;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItinerarioMapper {

    ItinerarioDTO toDto(Itinerario itinerario);
    Itinerario toModel(ItinerarioDTO itinerarioDTO);


    List<ItinerarioDTO> toDtos(List<Itinerario> itinerarioList);
    List<Itinerario> toModels(List<ItinerarioDTO> itinerarioDTOList);
    
}


