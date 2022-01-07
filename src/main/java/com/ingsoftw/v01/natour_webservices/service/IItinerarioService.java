package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;



public interface IItinerarioService { //

    List<ItinerarioDto> getAll() throws Exception; //metodo astratto senza corpo
    ItinerarioDto getById(Long id) throws Exception;
    ItinerarioDto addItinerario(ItinerarioDto itinerario) throws Exception;
    boolean deleteItinerarioById(Long id) throws Exception;
    CoordinataDto addCoordinata(CoordinataDto coordinata,long itinerarioId) throws Exception;
    ItinerarioDto addDifficolta(Integer difficolta, long itinerarioId) throws Exception;
}



