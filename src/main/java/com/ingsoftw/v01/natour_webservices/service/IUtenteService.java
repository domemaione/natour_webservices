package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;

import java.util.List;

public interface IUtenteService {

    List<UtenteDto> getAll(); //metodo astratto senza corpo
    UtenteDto getById(Long id);
    UtenteDto addUtente(UtenteDto utente);
    boolean deleteUtenteById(Long id);

}
