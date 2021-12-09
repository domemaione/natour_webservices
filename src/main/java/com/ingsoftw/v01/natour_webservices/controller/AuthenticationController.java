package com.ingsoftw.v01.natour_webservices.controller;

import com.ingsoftw.v01.natour_webservices.dto.JsonResponseDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.service.IAuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @ApiOperation("Registra un utente") //descrizione swagger dell'endpoint
    @PostMapping(value="/registrazione", produces = "application/json") //l'id sarà visualizzato nell'url (produces = jso significa che il tipo di ritorno è un json)
    public ResponseEntity<JsonResponseDto<UtenteDto>> registerUser(
            @ApiParam("utente") @RequestBody UtenteDto utente) throws Exception {

        JsonResponseDto <UtenteDto> body = new JsonResponseDto<UtenteDto>(JsonResponseDto.SUCCESS, HttpStatus.OK.value(),authenticationService.registrazione(utente));

        return ResponseEntity.ok(body); //200(OK) Richiesta andata a buon fine

    }

    @PostMapping("/login")
    public String login() {

        String token = authenticationService.getJWTToken();

        return token;

    }


}
