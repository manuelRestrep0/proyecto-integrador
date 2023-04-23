package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.ClienteDTO;
import com.manuel.proyectointegrador.model.Cliente;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T14:38:31-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCedula( cliente.getCedula() );
        clienteDTO.setNombre( cliente.getNombre() );
        clienteDTO.setApellido( cliente.getApellido() );
        clienteDTO.setCelular( cliente.getCelular() );
        clienteDTO.setCorreo( cliente.getCorreo() );
        clienteDTO.setDireccionResidencial( cliente.getDireccionResidencial() );
        clienteDTO.setCiudad( cliente.getCiudad() );

        return clienteDTO;
    }

    @Override
    public Cliente clienteDTOtoCliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( clienteDTO.getCedula() );
        cliente.setNombre( clienteDTO.getNombre() );
        cliente.setApellido( clienteDTO.getApellido() );
        cliente.setCelular( clienteDTO.getCelular() );
        cliente.setCorreo( clienteDTO.getCorreo() );
        cliente.setDireccionResidencial( clienteDTO.getDireccionResidencial() );
        cliente.setCiudad( clienteDTO.getCiudad() );

        return cliente;
    }
}
