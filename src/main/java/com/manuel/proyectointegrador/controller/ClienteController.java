package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.ClienteDTO;
import com.manuel.proyectointegrador.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.manuel.proyectointegrador.model.Cliente;

@RestController
@RequestMapping("api/v1")
public class ClienteController {
    ClienteService clienteService;
    @Autowired
    public void ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    //crear cliente
    @PostMapping("/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO cliente){
        return this.clienteService.crearCliente(cliente);
    }
    //actualizar cliente
    @PatchMapping("/cliente")
    public void actualizarCliente(@RequestBody ClienteDTO cliente){

    }
    //eliminar cliente
    @DeleteMapping("/cliente/{cedula}")
    public String eliminarCliente(@PathVariable("cedula") int cedula){
        this.clienteService.eliminarCliente(cedula);
        return "Se elimino correctamente";
    }

    //obtener cliente con num cedula
    @GetMapping("/cliente/{cedula}")
    public ClienteDTO obtenerCliente(@PathVariable("cedula") int cedula){
        return this.clienteService.obtenerCliente(cedula);
    }

}
