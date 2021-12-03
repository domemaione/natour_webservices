package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T12:42:50+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class ItinerarioMapperImpl implements ItinerarioMapper {

    @Override
    public ItinerarioDTO toDto(Itinerario itinerario) {
        if ( itinerario == null ) {
            return null;
        }

        ItinerarioDTO itinerarioDTO = new ItinerarioDTO();

        Set<Coordinata> set = itinerario.getCoordinate();
        if ( set != null ) {
            itinerarioDTO.setCoordinate( new HashSet<Coordinata>( set ) );
        }
        itinerarioDTO.setId( itinerario.getId() );
        itinerarioDTO.setNome( itinerario.getNome() );
        itinerarioDTO.setDurata( itinerario.getDurata() );
        itinerarioDTO.setDifficolta( itinerario.getDifficolta() );
        itinerarioDTO.setPunteggio( itinerario.getPunteggio() );

        return itinerarioDTO;
    }

    @Override
    public Itinerario toModel(ItinerarioDTO itinerarioDTO) {
        if ( itinerarioDTO == null ) {
            return null;
        }

        Itinerario itinerario = new Itinerario();

        itinerario.setId( itinerarioDTO.getId() );
        itinerario.setNome( itinerarioDTO.getNome() );
        itinerario.setDurata( itinerarioDTO.getDurata() );
        itinerario.setDifficolta( itinerarioDTO.getDifficolta() );
        itinerario.setPunteggio( itinerarioDTO.getPunteggio() );
        Set<Coordinata> set = itinerarioDTO.getCoordinate();
        if ( set != null ) {
            itinerario.setCoordinate( new HashSet<Coordinata>( set ) );
        }

        return itinerario;
    }

    @Override
    public List<ItinerarioDTO> toDtos(List<Itinerario> itinerarioList) {
        if ( itinerarioList == null ) {
            return null;
        }

        List<ItinerarioDTO> list = new ArrayList<ItinerarioDTO>( itinerarioList.size() );
        for ( Itinerario itinerario : itinerarioList ) {
            list.add( toDto( itinerario ) );
        }

        return list;
    }

    @Override
    public List<Itinerario> toModels(List<ItinerarioDTO> itinerarioDTOList) {
        if ( itinerarioDTOList == null ) {
            return null;
        }

        List<Itinerario> list = new ArrayList<Itinerario>( itinerarioDTOList.size() );
        for ( ItinerarioDTO itinerarioDTO : itinerarioDTOList ) {
            list.add( toModel( itinerarioDTO ) );
        }

        return list;
    }
}
