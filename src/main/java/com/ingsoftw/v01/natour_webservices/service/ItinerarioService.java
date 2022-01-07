package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;
import java.util.Optional;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
import com.ingsoftw.v01.natour_webservices.exception.ItininerarioException;
import com.ingsoftw.v01.natour_webservices.mapper.CoordinataMapper;
import com.ingsoftw.v01.natour_webservices.mapper.ItinerarioMapper;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.repository.CoordinataRepository;
import com.ingsoftw.v01.natour_webservices.repository.ItinerarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItinerarioService implements IItinerarioService{ //questa è l'implementazione dell'interfaccia IItinerarioService
    @Autowired //sto definendo un bean, ovvero una variabile già definita e precaricata in memoria da spring
    private ItinerarioRepository itinerarioRepository;

    @Autowired
    private CoordinataRepository coordinataRepository;

    @Autowired
    private ItinerarioMapper itinerarioMapper;

    @Autowired
    private CoordinataMapper coordinataMapper;

    @Override
    public List<ItinerarioDto> getAll() {
        List<Itinerario> itinerariList = itinerarioRepository.findAll(); //findAll metodo di default della Repository
        return itinerarioMapper.toDtos(itinerariList);
    }

    @Override
    public ItinerarioDto getById(Long id) throws Exception {

        Optional<Itinerario> itinerario=itinerarioRepository.findById(id);
        if(itinerario.isPresent())
            return itinerarioMapper.toDto(itinerario.get());
        else
            return null;

    }


    @Override
    public ItinerarioDto addItinerario(ItinerarioDto itinerario) throws Exception {
        
        return itinerarioMapper.toDto(itinerarioRepository.save(itinerarioMapper.toModel(itinerario))); //prende questo oggetto e lo mette nel db
    }

    @Override
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

    @Override
    public CoordinataDto addCoordinata(CoordinataDto coordinata, long itinerarioId) throws Exception{
        Optional<Itinerario> itinerario = this.itinerarioRepository.findById(itinerarioId);
        if(itinerario.isEmpty())
            throw new ItininerarioException("Itinerario non trovato");

        coordinata.setItinerario(itinerario.get());
        CoordinataDto coordinataDto = coordinataMapper.toDto(this.coordinataRepository.save(coordinataMapper.toModel(coordinata)));
        return coordinataDto;
    }

    @Override
    public ItinerarioDto addDifficolta(Integer difficolta, long itinerarioId) throws Exception {
        Optional<Itinerario> itinerario = this.itinerarioRepository.findById(itinerarioId);

        if(itinerario.isEmpty())
            throw new ItininerarioException("Itinerario non trovato");

        return null;
    }



}
