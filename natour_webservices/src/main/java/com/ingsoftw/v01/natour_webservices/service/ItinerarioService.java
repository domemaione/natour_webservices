package com.ingsoftw.v01.natour_webservices.service;

import java.util.List;
import java.util.Optional;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.mapper.ItinerarioMapper;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.repository.ItinerarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItinerarioService implements IItinerarioService{ //questa è l'implementazione dell'interfaccia IItinerarioService
    @Autowired //sto definendo un bean, ovvero una variabile già definita e precaricata in memoria da spring
    ItinerarioRepository itinerarioRepository;

    @Autowired
    ItinerarioMapper itinerarioMapper;

    @Override
    public List<ItinerarioDTO> getAll() {
        List<Itinerario> itinerariList = itinerarioRepository.findAll();
        return itinerarioMapper.toDtos(itinerariList);
    }

    @Override
    public ItinerarioDTO getById(Long id) {

        Optional<Itinerario> itinerario=itinerarioRepository.findById(id);
        if(itinerario.isPresent())
            return itinerarioMapper.toDto(itinerario.get());
        else
            return null;

    }


    @Override
    public ItinerarioDTO addItinerario(ItinerarioDTO itinerario) {
        
        return itinerarioMapper.toDto(itinerarioRepository.save(itinerarioMapper.toModel(itinerario))); //prende questo oggetto e lo mette nel db
    }

    
}
