package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDTO;
import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-05T19:26:37+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 11.0.8 (AdoptOpenJDK)"
)
@Component
public class CoordinataMapperImpl implements CoordinataMapper {

    @Override
    public CoordinataDTO toDto(Coordinata coordinata) {
        if ( coordinata == null ) {
            return null;
        }

        long id = 0L;
        Double lat = null;
        Double lon = null;
        Date createdAt = null;
        Itinerario itinerario = null;

        id = coordinata.getId();
        lat = coordinata.getLat();
        lon = coordinata.getLon();
        createdAt = coordinata.getCreatedAt();
        itinerario = coordinata.getItinerario();

        CoordinataDTO coordinataDTO = new CoordinataDTO( id, lat, lon, createdAt, itinerario );

        return coordinataDTO;
    }

    @Override
    public Coordinata toModel(CoordinataDTO coordinataDTO) {
        if ( coordinataDTO == null ) {
            return null;
        }

        Coordinata coordinata = new Coordinata();

        coordinata.setId( coordinataDTO.getId() );
        coordinata.setLat( coordinataDTO.getLat() );
        coordinata.setLon( coordinataDTO.getLon() );
        coordinata.setCreatedAt( coordinataDTO.getCreatedAt() );
        coordinata.setItinerario( coordinataDTO.getItinerario() );

        return coordinata;
    }

    @Override
    public List<CoordinataDTO> toDtos(List<Coordinata> coordinataList) {
        if ( coordinataList == null ) {
            return null;
        }

        List<CoordinataDTO> list = new ArrayList<CoordinataDTO>( coordinataList.size() );
        for ( Coordinata coordinata : coordinataList ) {
            list.add( toDto( coordinata ) );
        }

        return list;
    }

    @Override
    public List<Coordinata> toModels(List<CoordinataDTO> coordinataDTOList) {
        if ( coordinataDTOList == null ) {
            return null;
        }

        List<Coordinata> list = new ArrayList<Coordinata>( coordinataDTOList.size() );
        for ( CoordinataDTO coordinataDTO : coordinataDTOList ) {
            list.add( toModel( coordinataDTO ) );
        }

        return list;
    }
}
