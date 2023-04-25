package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.PaqueteDTO;
import com.manuel.proyectointegrador.model.Paquete;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T20:40:12-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class PaqueteMapperImpl implements PaqueteMapper {

    @Override
    public PaqueteDTO paqueteToPaqueteDTO(Paquete paquete) {
        if ( paquete == null ) {
            return null;
        }

        PaqueteDTO paqueteDTO = new PaqueteDTO();

        paqueteDTO.setPeso( paquete.getPeso() );
        paqueteDTO.setValorDeclarado( paquete.getValorDeclarado() );

        return paqueteDTO;
    }

    @Override
    public Paquete paqueteDTOtoPaquete(PaqueteDTO paqueteDTO) {
        if ( paqueteDTO == null ) {
            return null;
        }

        Paquete paquete = new Paquete();

        paquete.setPeso( paqueteDTO.getPeso() );
        paquete.setValorDeclarado( paqueteDTO.getValorDeclarado() );

        return paquete;
    }
}
