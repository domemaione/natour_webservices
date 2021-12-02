package com.ingsoftw.v01.natour_webservices.controller;

import com.ingsoftw.v01.natour_webservices.service.IUtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utente")
public class UtenteController {

    @Autowired
    private IUtenteService utenteService;
}
