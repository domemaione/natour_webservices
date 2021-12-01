package com.ingsoftw.v01.natour_webservices.controller;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.service.IItinerarioService;
import com.ingsoftw.v01.natour_webservices.service.ItinerarioService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("itinerario") //tutte le api che implemento avranno sull'indirizzo il nome che metto su request mapping
public class ItinerarioController {
    @Autowired
    IItinerarioService itinerarioService;

    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<List<ItinerarioDTO>> getAllItinerari() { 
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.getAll()); //200(OK) Richiesta andata a buon fine
    }
    
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDTO> getItinerario(@PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDTO> addItinerario(@RequestBody ItinerarioDTO itinerario) { 
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }



}

