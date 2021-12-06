package com.ingsoftw.v01.natour_webservices.controller;


import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;
import com.ingsoftw.v01.natour_webservices.service.IItinerarioService;

import com.ingsoftw.v01.natour_webservices.service.ItinerarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.connector.Response;
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

    @ApiOperation("Restituisce l'elenco completo degli itinerari")
    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> getAllItinerari() throws Exception {

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),itinerarioService.getAll());

        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }

    @ApiOperation("Restituisce l'itinerario in base all'id inserito in input")
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDto> getItinerario(@ApiParam("itinerarioId") @PathVariable long id) {

        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @ApiOperation("Cancella l'itinerario in base all'id inserito in input")
    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)

    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> deleteItinerario(@ApiParam("itinerarioId") @PathVariable long id) {

        boolean flag = itinerarioService.deleteItinerarioById(id);
        String message = flag ? " itinerario cancellato" : " itinerario non è stato cancellato";

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS + message,HttpStatus.OK.value(),itinerarioService.getAll());
        return ResponseEntity.ok(body);

    }

    @ApiOperation("Aggiunge un itinerario con id auto-incremento")
    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDto> addItinerario(@RequestBody ItinerarioDto itinerario) {
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }

   //aggiungere una post con Add punto ad un determinato itinerario

    @ApiOperation("Aggiunge una coordinata ad un determinato itinerario preso in input tramite id")
    @PostMapping(value="/addcoordinata/{id}", produces = "application/json")
    public ResponseEntity<Boolean> addCoordinata(@ApiParam("itinerarioId") @RequestBody CoordinataDto coordinata, @PathVariable long id) {
       return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addCoordinata(coordinata,id));
    }

}

