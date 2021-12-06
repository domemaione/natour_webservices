package com.ingsoftw.v01.natour_webservices.mapper;
import com.ingsoftw.v01.natour_webservices.dto.CoordinataDto;
import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoordinataMapper {

    CoordinataDto toDto(Coordinata coordinata);
    Coordinata toModel(CoordinataDto coordinataDTO);

    List<CoordinataDto> toDtos(List<Coordinata> coordinataList);
    List<Coordinata> toModels(List<CoordinataDto> coordinataDTOList);
}
