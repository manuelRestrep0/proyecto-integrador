package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.dto.EnvioFilterDTO;
import com.manuel.proyectointegrador.dto.EnvioResponseDTO;
import com.manuel.proyectointegrador.dto.EnvioUpdateDTO;
import com.manuel.proyectointegrador.service.EnvioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public EnvioResponseDTO crearEnvio(@RequestBody EnvioDTO envio){
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
    @ApiOperation(value = "Actualizar estado de envio", notes = "Se recibe por el body el estado al que se " +
            "quiere actualizar el envio, la cedula del empleado y el numero guia del envio.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PatchMapping("/envio")
    public EnvioResponseDTO actualizarEstadoEnvio(@RequestBody EnvioUpdateDTO envioUpdateDTO){
        return this.envioService.actualizarEstado(envioUpdateDTO);
    }

    @GetMapping("/envios")
    public List<EnvioDTO> envios(){
        return this.envioService.retornarEnvios();
    }
    @ApiOperation(value = "Obtener lista de envios por estado de envio", notes = "Se recibe por la url el estado de envio " +
            "y la cedula del empleado para saber si esta registrado en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "funciona correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/envios/{estado}/{cedula}")
    public List<EnvioDTO> filtrarEnvios(@PathVariable("estado") String estadoEnvio, @PathVariable("cedula") Integer cedulaEmpleado){
        EnvioFilterDTO envioFilterDTO = new EnvioFilterDTO(estadoEnvio, cedulaEmpleado);
        return this.envioService.filtrar(envioFilterDTO);
    }

    @DeleteMapping("/envio/{numeroGuia}")
    public String eliminarEnvio(@PathVariable("numeroGuia") int numeroGuia){
        this.envioService.eliminarEnvioImpl(numeroGuia);
        return "Eliminacion exitosa";
    }

}
