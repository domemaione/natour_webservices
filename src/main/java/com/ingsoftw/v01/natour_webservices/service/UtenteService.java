package com.ingsoftw.v01.natour_webservices.service;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.exception.EmailException;
import com.ingsoftw.v01.natour_webservices.mapper.UtenteMapper;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.repository.UtenteRepository;
import com.ingsoftw.v01.natour_webservices.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class UtenteService implements IUtenteService{

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    @Override
    public List<UtenteDto> getAll() {
        List<Utente> utentiList = utenteRepository.findAll();
        return utenteMapper.toDtos(utentiList);
    }

    @Override
    public UtenteDto getById(Long id) {

        Optional<Utente> utente=utenteRepository.findById(id);
        if(utente.isPresent())
            return utenteMapper.toDto(utente.get());
        else
            return null;

    }




    @Override
    public UtenteDto addUtente(UtenteDto utente) {

        String email = utente.getEmail(); //prendiamo l'email dell'utente che abbiamo passato da utenteController
        if(!Validation.patternMatches(email, Validation.regexPattern))
            throw new EmailException("email non valida");

        return utenteMapper.toDto(utenteRepository.save(utenteMapper.toModel(utente))); //prende questo oggetto e lo mette nel db
    }

    @Override
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
