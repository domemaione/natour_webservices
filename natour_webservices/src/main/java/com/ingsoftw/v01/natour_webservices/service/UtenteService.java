package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.repository.ItinerarioRepository;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService implements IUtenteService{

    @Autowired
    private UtenteRepository utenteRepository;


}
