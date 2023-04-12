package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.model.Envio;
import com.manuel.proyectointegrador.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EnvioController {
    EnvioService envioService;
    @Autowired
    public void EnvioController(EnvioService envioService){
        this.envioService = envioService;
    }

    // crear envio
    @PostMapping("/envio")
    public String crearEnvio(@RequestBody EnvioDTO envio){
        return this.envioService.crearEnvio(envio);
    }

    // obtener envio numero guia
    @GetMapping("/envio/{numeroGuia}")
    public EnvioDTO obtenerEnvio(@PathVariable("numeroGuia") int numeroGuia){
        return this.envioService.buscarEnvio(numeroGuia);
    }

    // actualizar estado envio
    @PatchMapping("/envio")
    public String actualizarEstadoEnvio(@RequestParam("guia") Integer numGuia, @RequestParam("estado") String estadoEnvio, @RequestParam("empleado") Integer cedulaEmpleado){
        return this.envioService.actualizarEstado(numGuia,cedulaEmpleado,estadoEnvio);
    }

    @GetMapping("/envio")
    public List<EnvioDTO> filtrarEnvios(@RequestParam String estadoEnvio, @RequestParam Integer cedulaEmpleado){
        //tener en cuenta las validaciones.
        return this.envioService.filtrar(estadoEnvio,cedulaEmpleado);
    }

}
