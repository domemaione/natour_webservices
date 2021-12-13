package com.ingsoftw.v01.natour_webservices.mapper;

import com.ingsoftw.v01.natour_webservices.dto.ActivationTokenDto;
import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivationTokenMapper {

    ActivationTokenDto toDto(ActivationToken activationToken);
    ActivationToken toModel(ActivationTokenDto activationTokenDTO);

    List<ActivationTokenDto> toDtos(List<ActivationToken> activationTokenList);
    List<ActivationToken> toModels(List<ActivationTokenDto> activationTokenDtoList);
}
