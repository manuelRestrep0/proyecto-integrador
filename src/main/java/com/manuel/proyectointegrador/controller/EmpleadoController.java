package com.manuel.proyectointegrador.controller;

import com.manuel.proyectointegrador.dto.EmpleadoDTO;
import com.manuel.proyectointegrador.service.EmpleadoService;
import com.manuel.proyectointegrador.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmpleadoController {
    EmpleadoService empleadoService;

    @Autowired public void EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    //crear empleado
    @PostMapping("/empleado")
    public void crearEmpleado(@RequestBody EmpleadoDTO empleado){
        this.empleadoService.crearEmpleado(empleado);

    }
    //actualizar empleado
    @PatchMapping("/empleado")
    public void actualizarEmpleado(@RequestBody EmpleadoDTO empleado){

    }

    //eliminar empleado
    @DeleteMapping("/empleados/{cedula}")
    public String eliminarEmpleado(@PathVariable("cedula") int cedula){
        this.eliminarEmpleado(cedula);
        return "Empleado eliminado";
    }

    //obtener empleado por cedula
    @GetMapping("/empleados/{cedula}")
    public EmpleadoDTO obtenerEmpleado(@PathVariable("cedula") int cedula){
        return this.empleadoService.getEmpleadoPorCedula(cedula);
    }
}
