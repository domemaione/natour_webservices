package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDto;
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
    date = "2021-12-06T11:41:13+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class ItinerarioMapperImpl implements ItinerarioMapper {

    @Override
    public ItinerarioDto toDto(Itinerario itinerario) {
        if ( itinerario == null ) {
            return null;
        }

        ItinerarioDto itinerarioDto = new ItinerarioDto();

        Set<Coordinata> set = itinerario.getCoordinate();
        if ( set != null ) {
            itinerarioDto.setCoordinate( new HashSet<Coordinata>( set ) );
        }
        itinerarioDto.setId( itinerario.getId() );
        itinerarioDto.setNome( itinerario.getNome() );
        itinerarioDto.setDurata( itinerario.getDurata() );
        itinerarioDto.setDifficolta( itinerario.getDifficolta() );
        itinerarioDto.setPunteggio( itinerario.getPunteggio() );

        return itinerarioDto;
    }

    @Override
    public Itinerario toModel(ItinerarioDto itinerarioDto) {
        if ( itinerarioDto == null ) {
            return null;
        }

        Itinerario itinerario = new Itinerario();

        itinerario.setId( itinerarioDto.getId() );
        itinerario.setNome( itinerarioDto.getNome() );
        itinerario.setDurata( itinerarioDto.getDurata() );
        itinerario.setDifficolta( itinerarioDto.getDifficolta() );
        itinerario.setPunteggio( itinerarioDto.getPunteggio() );
        Set<Coordinata> set = itinerarioDto.getCoordinate();
        if ( set != null ) {
            itinerario.setCoordinate( new HashSet<Coordinata>( set ) );
        }

        return itinerario;
    }

    @Override
    public List<ItinerarioDto> toDtos(List<Itinerario> itinerarioList) {
        if ( itinerarioList == null ) {
            return null;
        }

        List<ItinerarioDto> list = new ArrayList<ItinerarioDto>( itinerarioList.size() );
        for ( Itinerario itinerario : itinerarioList ) {
            list.add( toDto( itinerario ) );
        }

        return list;
    }

    @Override
    public List<Itinerario> toModels(List<ItinerarioDto> itinerarioDtoList) {
        if ( itinerarioDtoList == null ) {
            return null;
        }

        List<Itinerario> list = new ArrayList<Itinerario>( itinerarioDtoList.size() );
        for ( ItinerarioDto itinerarioDto : itinerarioDtoList ) {
            list.add( toModel( itinerarioDto ) );
        }

        return list;
    }
}
