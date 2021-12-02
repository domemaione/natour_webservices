package com.ingsoftw.v01.natour_webservices.mapper;
import com.ingsoftw.v01.natour_webservices.dto.CoordinataDTO;
import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoordinataMapper {

    CoordinataDTO toDto(Coordinata coordinata);
    Coordinata toModel(CoordinataDTO coordinataDTO);

    List<CoordinataDTO> toDtos(List<Coordinata> coordinataList);
    List<Coordinata> toModels(List<CoordinataDTO> coordinataDTOList);
}
