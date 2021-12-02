package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.ItinerarioDTO;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-02T18:23:43+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class ItinerarioMapperImpl implements ItinerarioMapper {

    @Override
    public ItinerarioDTO toDto(Itinerario itinerario) {
        if ( itinerario == null ) {
            return null;
        }

        ItinerarioDTO itinerarioDTO = new ItinerarioDTO();

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
