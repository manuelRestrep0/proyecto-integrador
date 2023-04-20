package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.model.Envio;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T08:31:13-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class EnvioMapperImpl implements EnvioMapper {

    @Override
    public EnvioDTO envioToEnvioDTO(Envio envio) {
        if ( envio == null ) {
            return null;
        }

        EnvioDTO envioDTO = new EnvioDTO();

        envioDTO.setCiudadOrigen( envio.getCiudadOrigen() );
        envioDTO.setCiudadDestino( envio.getCiudadDestino() );
        envioDTO.setDireccionDestino( envio.getDireccionDestino() );
        envioDTO.setNombreRecibe( envio.getNombreRecibe() );
        envioDTO.setNumRecibe( envio.getNumRecibe() );
        envioDTO.setValorEnvio( envio.getValorEnvio() );
        envioDTO.setEstadoEnvio( envio.getEstadoEnvio() );

        return envioDTO;
    }

    @Override
    public Envio envioDTOtoEnvio(EnvioDTO envioDTO) {
        if ( envioDTO == null ) {
            return null;
        }

        Envio envio = new Envio();

        envio.setCiudadOrigen( envioDTO.getCiudadOrigen() );
        envio.setCiudadDestino( envioDTO.getCiudadDestino() );
        envio.setDireccionDestino( envioDTO.getDireccionDestino() );
        envio.setNombreRecibe( envioDTO.getNombreRecibe() );
        envio.setNumRecibe( envioDTO.getNumRecibe() );
        envio.setEstadoEnvio( envioDTO.getEstadoEnvio() );
        envio.setValorEnvio( envioDTO.getValorEnvio() );

        return envio;
    }
}
