package com.ingsoftw.v01.natour_webservices.controller;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.service.IUtenteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utente")
public class UtenteController {

    @Autowired
    private IUtenteService utenteService;

    @ApiOperation("Restituisce l'elenco completo degli utenti")
    @GetMapping(value="/all", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto<List<UtenteDto>>> getAllUsers() throws Exception {

        JsonResponseDto <List<UtenteDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS, HttpStatus.OK.value(),utenteService.getAll());
        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }

    @ApiOperation("Restituisce l'utente in base all'id inserito in input")
    @GetMapping(value="/get/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto <UtenteDto>> getUtente(@ApiParam("utenteId") @PathVariable long id) {

        JsonResponseDto <UtenteDto> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),utenteService.getById(id));
        return ResponseEntity.ok(body);
    }

    @ApiOperation("Cancella l'utente in base all'id inserito in input")
    @DeleteMapping(value="/delete/{id}", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)

    public ResponseEntity<JsonResponseDto <List<UtenteDto>>> deleteUtente(@ApiParam("utenteId") @PathVariable long id) {

        boolean flag = utenteService.deleteUtenteById(id);
        String message = flag ? " utente cancellato" : " utente non è stato cancellato";

        JsonResponseDto <List<UtenteDto>> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS + message,HttpStatus.OK.value(),utenteService.getAll());
        return ResponseEntity.ok(body);

    }

    @ApiOperation("Aggiunge un utente con id auto-incremento")
    @PostMapping(value="/add", produces = "application/json")
    public ResponseEntity<JsonResponseDto <UtenteDto>> addUtente(@RequestBody UtenteDto utente) {

        JsonResponseDto <UtenteDto> body = new JsonResponseDto<>(JsonResponseDto.SUCCESS,HttpStatus.OK.value(),utenteService.addUtente(utente));
        return ResponseEntity.ok(body);
    }

    
}
