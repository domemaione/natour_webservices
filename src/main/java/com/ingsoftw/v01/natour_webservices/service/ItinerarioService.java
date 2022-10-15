package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;
import java.util.Optional;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.exception.ItininerarioException;
import com.ingsoftw.v01.natour_webservices.mapper.CoordinataMapper;
import com.ingsoftw.v01.natour_webservices.mapper.ItinerarioMapper;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import com.ingsoftw.v01.natour_webservices.model.Valutazione;
import com.ingsoftw.v01.natour_webservices.model.ValutazionePK;
import com.ingsoftw.v01.natour_webservices.repository.CoordinataRepository;
import com.ingsoftw.v01.natour_webservices.repository.ItinerarioRepository;

import com.ingsoftw.v01.natour_webservices.repository.ValutazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItinerarioService { //questa è l'implementazione dell'interfaccia IItinerarioService
    @Autowired //sto definendo un bean, ovvero una variabile già definita e precaricata in memoria da spring
    private ItinerarioRepository itinerarioRepository;

    @Autowired
    private CoordinataRepository coordinataRepository;

    @Autowired
    private ItinerarioMapper itinerarioMapper;

    @Autowired
    private CoordinataMapper coordinataMapper;

    @Autowired
    private ValutazioneRepository valutazioneRepository;


    public List<ItinerarioDto> getAll() {
        List<Itinerario> itinerariList = itinerarioRepository.findAll(); //findAll metodo di default della Repository
        return itinerarioMapper.toDtos(itinerariList);
    }


    public ItinerarioDto getById(Long id) throws Exception {

        Optional<Itinerario> itinerario=itinerarioRepository.findById(id);
        if(itinerario.isPresent())
            return itinerarioMapper.toDto(itinerario.get());
        else
            return null;

    }



    public ItinerarioDto addItinerario(ItinerarioDto itinerarioDto) throws Exception {

        Itinerario itinerarioSaved = itinerarioRepository.save(itinerarioMapper.toModel(itinerarioDto));
        ValutazionePK valutazionePK = new ValutazionePK(itinerarioSaved.getIdUser(), itinerarioSaved.getId());
        Valutazione valutazione = new Valutazione(valutazionePK,itinerarioSaved.getDifficulty(),itinerarioSaved.getScore());
        valutazioneRepository.save(valutazione);
        return itinerarioMapper.toDto(itinerarioSaved); //prende questo oggetto e lo mette nel db
    }


    public boolean deleteItinerarioById(Long id) { //cancella itinerario attraverso l'id

        try{
            this.itinerarioRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        //return !(this.itinerarioRepository.existsById(id));

    }


    public CoordinataDto addCoordinata(CoordinataDto coordinata, long itinerarioId) throws Exception{
        Optional<Itinerario> itinerario = this.itinerarioRepository.findById(itinerarioId);
        if(itinerario.isEmpty())
            throw new ItininerarioException("Itinerario non trovato");

        coordinata.setIdItinerary(itinerario.get().getId());
        CoordinataDto coordinataDto = coordinataMapper.toDto(this.coordinataRepository.save(coordinataMapper.toModel(coordinata)));
        return coordinataDto;
    }


    public ItinerarioDto addDifficolta(long difficolta, long itinerarioId, long utenteId) throws Exception {
        Optional<Itinerario> opt = this.itinerarioRepository.findById(itinerarioId);

        Utente utente = new Utente();
        utente.setId(utenteId);

        if(opt.isEmpty())
            throw new ItininerarioException("Itinerario non trovato");
        Itinerario itinerarioSaved = opt.get();
        ValutazionePK valutazionePK = new ValutazionePK(utente.getId(), itinerarioSaved.getId());
        Valutazione valutazione = new Valutazione(valutazionePK,itinerarioSaved.getDifficulty(),itinerarioSaved.getScore());
        valutazioneRepository.save(valutazione);

        //valutazionePK.setUtente_id(null);
       // List<Valutazione> lista =  this.valutazioneRepository.findByValutazionePKItinerario(itinerarioSaved);

        return null;
    }



}
