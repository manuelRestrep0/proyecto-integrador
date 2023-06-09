package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.EmpleadoDTO;
import com.manuel.proyectointegrador.service.EmpleadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Api(tags = "Empleado", description = "Controller Empleado")
public class EmpleadoController {
    EmpleadoService empleadoService;


    @Autowired public void EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    @ApiOperation(value = "Registrar empleado", notes = "Se recibe por el body un objeto de tipo empleadoDTO y este se registra en la " +
            "base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @PostMapping("/empleado")
    public EmpleadoDTO crearEmpleado(@RequestBody EmpleadoDTO empleado){
        this.empleadoService.crearEmpleado(empleado);
        return empleado;
    }
    @ApiOperation(value = "Eliminar Empleado", notes = "Se recibe por la url la cedula del empleado y se " +
            "elimina este de la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo la operacion correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @DeleteMapping("/empleado/{cedula}")
    public String eliminar(@PathVariable("cedula") int cedula){
        this.empleadoService.eliminarEmpleado(cedula);
        return "Empleado eliminado";
    }
    @ApiOperation(value = "Obtener empleado", notes = "Se recibe por la url la cedula del empleado y " +
            "se devuelve la informacion del empleado de estar registrado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se hizo el registro correctamente."),
            @ApiResponse(code = 400, message = "Bad Request. Algo ingresaste mal."),
            @ApiResponse(code = 500, message = "Error inespedaro del sistema.")
    })
    @GetMapping("/empleado/{cedula}")
    public EmpleadoDTO obtenerEmpleado(@PathVariable("cedula") int cedula){
        return this.empleadoService.getEmpleadoPorCedula(cedula);
    }
}
