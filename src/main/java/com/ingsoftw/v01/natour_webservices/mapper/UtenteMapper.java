package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.UtenteDto;
import com.ingsoftw.v01.natour_webservices.model.Utente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteDto toDto(Utente utente);
    Utente toModel(UtenteDto utenteDto);
    List<UtenteDto> toDtos(List<Utente> utenteList);
    List<Utente> toModels(List<UtenteDto> utenteDtoList);
}
