package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-12-06T11:12:32+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 16.0.2 (Azul Systems, Inc.)"
=======
    date = "2021-12-05T19:47:15+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.jar, environment: Java 11.0.8 (AdoptOpenJDK)"
>>>>>>> 91b2fe7e9982010364ac76236fc05cabdc802b4a
)
@Component
public class CoordinataMapperImpl implements CoordinataMapper {

    @Override
    public CoordinataDto toDto(Coordinata coordinata) {
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

        CoordinataDto coordinataDto = new CoordinataDto( id, lat, lon, createdAt, itinerario );

        return coordinataDto;
    }

    @Override
    public Coordinata toModel(CoordinataDto coordinataDTO) {
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
    public List<CoordinataDto> toDtos(List<Coordinata> coordinataList) {
        if ( coordinataList == null ) {
            return null;
        }

        List<CoordinataDto> list = new ArrayList<CoordinataDto>( coordinataList.size() );
        for ( Coordinata coordinata : coordinataList ) {
            list.add( toDto( coordinata ) );
        }

        return list;
    }

    @Override
    public List<Coordinata> toModels(List<CoordinataDto> coordinataDTOList) {
        if ( coordinataDTOList == null ) {
            return null;
        }

        List<Coordinata> list = new ArrayList<Coordinata>( coordinataDTOList.size() );
        for ( CoordinataDto coordinataDto : coordinataDTOList ) {
            list.add( toModel( coordinataDto ) );
        }

        return list;
    }
}
