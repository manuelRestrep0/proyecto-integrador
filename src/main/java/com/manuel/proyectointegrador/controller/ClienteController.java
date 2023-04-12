package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.ClienteDTO;
import com.manuel.proyectointegrador.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.manuel.proyectointegrador.model.Cliente;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Cliente", description = "Controller Cliente")
public class ClienteController {
    ClienteService clienteService;
    @Autowired
    public void ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @ApiOperation(value = "Registrar cliente", notes = "Se recibe por el body un objeto de tipo clienteDTO y este se registra en la " +
            "base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO cliente){
        return this.clienteService.crearCliente(cliente);
    }
    //actualizar cliente
    /*
    @PatchMapping("/cliente")
    public void actualizarCliente(@RequestBody ClienteDTO cliente){
    }
     */
    @ApiOperation(value = "Eliminar cliente", notes = "Se recibe por la url la cedula del cliente y se " +
            "elimina este de la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo la operacion correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @DeleteMapping("/cliente/{cedula}")
    public String eliminarCliente(@PathVariable("cedula") int cedula){
        this.clienteService.eliminarCliente(cedula);
        return "Se elimino correctamente";
    }

    @ApiOperation(value = "Obtener cliente", notes = "Se recibe por la url la cedula del cliente y " +
            "se devuelve la informacion del cliente de estar registrado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/cliente/{cedula}")
    public ClienteDTO obtenerCliente(@PathVariable("cedula") int cedula){
        return this.clienteService.obtenerCliente(cedula);
    }

}
