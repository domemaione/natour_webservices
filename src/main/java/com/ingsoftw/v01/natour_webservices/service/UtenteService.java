package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;
import com.ingsoftw.v01.natour_webservices.exception.UserNotFoundException;
import com.ingsoftw.v01.natour_webservices.mapper.UtenteMapper;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.utils.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

  
    public List<UtenteDto> getAll() {
        List<Utente> utentiList = utenteRepository.findAll();
        return utenteMapper.toDtos(utentiList);
    }


    public UtenteDto getById(Long id) throws UserNotFoundException {

        Optional<Utente> utente=utenteRepository.findById(id);
        if(utente.isEmpty())
            throw new UserNotFoundException("Utente non trovato");


        return utenteMapper.toDto(utente.get());
    }





    public UtenteDto addUtente(UtenteDto utente) throws EmailException {

        String email = utente.getEmail(); //prendiamo l'email dell'utente che abbiamo passato da utenteController
        if(!EmailValidator.patternMatches(email, EmailValidator.regexPattern))
            throw new EmailException("email non valida");

        return utenteMapper.toDto(utenteRepository.save(utenteMapper.toModel(utente))); //prende questo oggetto e lo mette nel db
    }


    public boolean deleteUtenteById(Long id) { //cancella utente attraverso l'id

        try{
            this.utenteRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        //return !(this.utenteRepository.existsById(id));

    }



}
