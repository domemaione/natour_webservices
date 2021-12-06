package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;



public interface IItinerarioService { //

    List<ItinerarioDto> getAll(); //metodo astratto senza corpo
    ItinerarioDto getById(Long id);
    ItinerarioDto addItinerario(ItinerarioDto itinerario);
    boolean deleteItinerarioById(Long id);
    boolean addCoordinata(CoordinataDto coordinata,long idItinerario);
}



