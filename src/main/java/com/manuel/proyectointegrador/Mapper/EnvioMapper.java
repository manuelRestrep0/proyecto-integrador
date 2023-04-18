package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.model.Envio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnvioMapper {

    EnvioMapper INSTANCE = Mappers.getMapper(EnvioMapper.class);


    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "paquete", ignore = true)
    EnvioDTO envioToEnvioDTO(Envio envio);

    Envio envioDTOtoEnvio(EnvioDTO envioDTO);
}
