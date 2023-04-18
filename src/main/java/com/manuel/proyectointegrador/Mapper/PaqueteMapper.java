package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.PaqueteDTO;
import com.manuel.proyectointegrador.model.Paquete;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaqueteMapper {

    PaqueteMapper INSTANCE = Mappers.getMapper(PaqueteMapper.class);

    PaqueteDTO paqueteToPaqueteDTO(Paquete paquete);

    Paquete paqueteDTOtoPaquete(PaqueteDTO paqueteDTO);
}
