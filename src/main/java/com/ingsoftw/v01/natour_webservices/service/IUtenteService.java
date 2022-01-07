package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;

import java.util.List;

public interface IUtenteService {

    List<UtenteDto> getAll() throws Exception; //metodo astratto senza corpo
    UtenteDto getById(Long id) throws Exception;
    UtenteDto addUtente(UtenteDto utente) throws Exception;
    boolean deleteUtenteById(Long id) throws Exception;

}
