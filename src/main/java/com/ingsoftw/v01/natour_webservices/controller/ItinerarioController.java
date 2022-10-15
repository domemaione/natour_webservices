package com.ingsoftw.v01.natour_webservices.controller;


import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;

import com.ingsoftw.v01.natour_webservices.service.ItinerarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//finalmente ci siamo riusciti
@RestController
@RequestMapping("itinerario") //tutte le api che implemento avranno sull'indirizzo il nome che metto su request mapping
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @ApiOperation("Restituisce l'elenco completo degli itinerari")
    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> getAllItinerari() throws Exception {

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),itinerarioService.getAll());

        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }

    @ApiOperation("Restituisce l'itinerario in base all'id inserito in input")
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<ItinerarioDto> getItinerario(@ApiParam("itinerarioId") @PathVariable long itinerarioId) throws Exception {

        return ResponseEntity.ok(itinerarioService.getById(itinerarioId));
    }

    @ApiOperation("Cancella l'itinerario in base all'id inserito in input")
    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)

    public ResponseEntity<JsonResponseDto <List<ItinerarioDto>>> deleteItinerario(@ApiParam("itinerarioId") @PathVariable long itinerarioId) throws Exception {

        boolean flag = itinerarioService.deleteItinerarioById(itinerarioId);
        String message = flag ? " itinerario cancellato" : " itinerario non è stato cancellato";

        JsonResponseDto <List<ItinerarioDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS + message,HttpStatus.OK.value(),itinerarioService.getAll());
        return ResponseEntity.ok(body);

    }

    @ApiOperation("Aggiunge un itinerario con id auto-incremento")
    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<ItinerarioDto> addItinerario(@RequestBody ItinerarioDto itinerario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addItinerario(itinerario));
    }

   //aggiungere una post con Add punto ad un determinato itinerario

    @ApiOperation("Aggiunge una coordinata ad un determinato itinerario preso in input tramite id")
    @PostMapping(value="/addcoordinata/{id}", produces = "application/json")
    public ResponseEntity<CoordinataDto> addCoordinata(
            @ApiParam("coordinata") @RequestBody CoordinataDto coordinata,
            @ApiParam("itinerarioId") @PathVariable long itinerarioId) throws Exception {
       return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addCoordinata(coordinata,itinerarioId));
    }


    //aggiungere in itinerario, la difficoltà di un utente e fare la media

    @ApiOperation("Aggiunge la difficoltà ad un itinerario")
    @PostMapping(value="/addDifficolta/{id}", produces = "application/json")
    public ResponseEntity<ItinerarioDto> addDifficolta(
            @ApiParam("difficolta") @RequestBody long difficolta,
            @ApiParam("itinerarioId")  @PathVariable(value = "itinerarioId") long itinerarioId,
            @ApiParam("utenteId")  @PathVariable(value = "utenteId") long utenteId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(itinerarioService.addDifficolta(difficolta,itinerarioId,utenteId));
    }

}

