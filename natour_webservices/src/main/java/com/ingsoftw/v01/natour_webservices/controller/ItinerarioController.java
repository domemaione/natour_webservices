package com.ingsoftw.v01.natour_webservices.controller;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDTO;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.service.IItinerarioService;
import com.ingsoftw.v01.natour_webservices.service.ItinerarioService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itinerario") //tutte le api che implemento avranno sull'indirizzo il nome che metto su request mapping
public class ItinerarioController {
    @Autowired
    private IItinerarioService itinerarioService;

    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<List<ItinerarioDTO>> getAllItinerari() { 
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.getAll()); //200(OK) Richiesta andata a buon fine
    }
    
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDTO> getItinerario(@PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<Boolean> deleteItinerario(@PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.deleteItinerarioById(id));
    }

    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDTO> addItinerario(@RequestBody ItinerarioDTO itinerario) { 
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }

   //aggiungere una post con Add punto ad un determinato itinerario
   @PostMapping(value="/addcoordinata/{id}", produces = "application/json")
   public ResponseEntity<CoordinataDTO> addCoordinata(@RequestBody CoordinataDTO coordinata, @PathVariable long id) {
       return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addCoordinata(coordinata,id));
   }

}

