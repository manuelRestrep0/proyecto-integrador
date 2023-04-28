package com.manuel.proyectointegrador.service;

import com.manuel.proyectointegrador.Mapper.ClienteMapper;
import com.manuel.proyectointegrador.dto.ClienteDTO;
import com.manuel.proyectointegrador.exception.ApiRequestException;
import com.manuel.proyectointegrador.model.Cliente;
import com.manuel.proyectointegrador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO){
        if(clienteDTO.getNombre()==null){
            throw new ApiRequestException("Se requiere el nombre");
        } else if(clienteDTO.getApellido()==null){
            throw new ApiRequestException("Se requiere el apellido");
        } else if(clienteDTO.getCedula()==null){
            throw new ApiRequestException("La cedula es nula");
        }
        List<Integer> cedulasRegistradas = new ArrayList<>();
        this.clienteRepository.findAll().stream()
                .forEach(cliente1 -> cedulasRegistradas.add(cliente1.getCedula()));
        if(cedulasRegistradas.contains(clienteDTO.getCedula())){
            throw new ApiRequestException("La cedula "+clienteDTO.getCedula()+" ya se encuentra registrada");
        }

        Cliente cliente = ClienteMapper.INSTANCE.clienteDTOtoCliente(clienteDTO);
        this.clienteRepository.save(cliente);
        return clienteDTO;
    }

    public ClienteDTO obtenerCliente(Integer cedula){
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);
        if(!cliente.isPresent()){
            throw new ApiRequestException("La cedula "+cedula+" no se encuentra registrada");
        }
        return ClienteMapper.INSTANCE.clienteToClienteDTO(cliente.get());
    }

    public void eliminarCliente(Integer cedula){
        Optional<Cliente> cliente = this.clienteRepository.findById(cedula);
        if(!cliente.isPresent()){
            throw new ApiRequestException("El cliente con cedula "+cedula+" no se encuentra registrado.");
        }
        this.clienteRepository.deleteById(cedula);
    }
}
