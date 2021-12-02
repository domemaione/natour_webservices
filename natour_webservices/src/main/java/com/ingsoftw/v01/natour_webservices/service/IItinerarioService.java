package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDTO;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;



public interface IItinerarioService { //

    List<ItinerarioDTO> getAll(); //metodo astratto senza corpo
    ItinerarioDTO getById(Long id);
    ItinerarioDTO addItinerario(ItinerarioDTO itinerario);
    boolean deleteItinerarioById(Long id);
    CoordinataDTO addCoordinata(CoordinataDTO coordinata);
}



