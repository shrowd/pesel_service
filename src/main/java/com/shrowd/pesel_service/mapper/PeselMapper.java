package com.shrowd.pesel_service.mapper;

import com.shrowd.pesel_service.core.Pesel;
import com.shrowd.pesel_service.dto.PeselRequest;
import com.shrowd.pesel_service.dto.PeselResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeselMapper {
    Pesel mapToPesel(PeselRequest peselRequest);
    PeselResponse mapToPeselResponse(Pesel pesel);
}
