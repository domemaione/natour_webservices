package com.ingsoftw.v01.natour_webservices.controller;


import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;
import com.ingsoftw.v01.natour_webservices.service.IItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itinerario") //tutte le api che implemento avranno sull'indirizzo il nome che metto su request mapping
public class ItinerarioController {
    @Autowired
    private IItinerarioService itinerarioService;

    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> getAllItinerari() throws Exception {

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),itinerarioService.getAll());

        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }
    
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDto> getItinerario(@PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> deleteItinerario(@PathVariable long id) {

        boolean flag = itinerarioService.deleteItinerarioById(id);
        String message = flag ? " itinerario cancellato" : " itinerario non è stato cancellato";

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS + message,HttpStatus.OK.value(),itinerarioService.getAll());
        return ResponseEntity.ok(body);
    }

    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDto> addItinerario(@RequestBody ItinerarioDto itinerario) {
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }

   //aggiungere una post con Add punto ad un determinato itinerario
   @PostMapping(value="/addcoordinata/{id}", produces = "application/json")
   public ResponseEntity<Boolean> addCoordinata(@RequestBody CoordinataDto coordinata, @PathVariable long id) {
       return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addCoordinata(coordinata,id));
   }

}

