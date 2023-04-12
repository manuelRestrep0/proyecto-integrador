package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.model.Envio;
import com.manuel.proyectointegrador.service.EnvioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Envio", description = "Controller Envio")
public class EnvioController {
    EnvioService envioService;
    @Autowired
    public void EnvioController(EnvioService envioService){
        this.envioService = envioService;
    }

    @ApiOperation(value = "Generar envio", notes = "Se recibe por el body un un objeto de tipo envioDTO y" +
            "se registra en la base de datos si cumple todas las validaciones.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/envio")
    public String crearEnvio(@RequestBody EnvioDTO envio){
        return this.envioService.crearEnvio(envio);
    }

    @ApiOperation(value = "Obtener envio", notes = "Se recibe por la url el numero guia del envio y " +
            "se devuelve la informacion del envio de estar registrado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/envio/{numeroGuia}")
    public EnvioDTO obtenerEnvio(@PathVariable("numeroGuia") int numeroGuia){
        return this.envioService.buscarEnvio(numeroGuia);
    }

    @ApiOperation(value = "Actualizar estado de envio", notes = "Se recibe por la url el numero guia del envio," +
            "el estado al que se quiere actualizar el envio y la cedula del empleado para determinar si " +
            "tiene los permisos para realizar la operacion.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PatchMapping("/envio")
    public String actualizarEstadoEnvio(@RequestParam("guia") Integer numGuia, @RequestParam("estado") String estadoEnvio, @RequestParam("empleado") Integer cedulaEmpleado){
        return this.envioService.actualizarEstado(numGuia,cedulaEmpleado,estadoEnvio);
    }

    @ApiOperation(value = "Obtener lista de envios por estado de envio", notes = "Se recibe por la url el estado de envio " +
            "que se quiere filtrar y la cedula del empleado para saber si esta registrado en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/envio")
    public List<EnvioDTO> filtrarEnvios(@RequestParam String estadoEnvio, @RequestParam Integer cedulaEmpleado){
        //tener en cuenta las validaciones.
        return this.envioService.filtrar(estadoEnvio,cedulaEmpleado);
    }

}
