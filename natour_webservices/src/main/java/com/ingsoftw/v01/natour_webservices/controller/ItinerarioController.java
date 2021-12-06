package com.ingsoftw.v01.natour_webservices.controller;

import java.util.List;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDTO;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.service.IItinerarioService;
import com.ingsoftw.v01.natour_webservices.service.ItinerarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation("Restituisce l'elenco completo degli itinerari")
    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <List<ItinerarioDTO>>> getAllItinerari() throws Exception {

        JsonResponseDto <List<ItinerarioDTO>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),itinerarioService.getAll());

        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }

    @ApiOperation("Restituisce l'itinerario in base all'id inserito in input")
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDTO> getItinerario(@ApiParam("itinerarioId") @PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @ApiOperation("Cancella l'itinerario in base all'id inserito in input")
    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<Boolean> deleteItinerario(@ApiParam("itinerarioId") @PathVariable long id) {
        return ResponseEntity.ok(itinerarioService.deleteItinerarioById(id));
    }

    @ApiOperation("Aggiunge un itinerario con id auto-incremento")
    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDTO> addItinerario(@RequestBody ItinerarioDTO itinerario) { 
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }

    @ApiOperation("Aggiunge una coordinata ad un determinato itinerario preso in input tramite id")
    @PostMapping(value="/addcoordinata/{id}", produces = "application/json")
    public ResponseEntity<Boolean> addCoordinata(@ApiParam("itinerarioId") @RequestBody CoordinataDTO coordinata, @PathVariable long id) {
       return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addCoordinata(coordinata,id));
    }

}

