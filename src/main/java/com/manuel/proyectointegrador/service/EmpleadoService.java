package com.manuel.proyectointegrador.service;

import com.manuel.proyectointegrador.dto.EmpleadoDTO;
import com.manuel.proyectointegrador.exception.ApiRequestException;
import com.manuel.proyectointegrador.model.Empleado;
import com.manuel.proyectointegrador.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoDTO crearEmpleado(EmpleadoDTO empleadoDTO){
        if(empleadoDTO.getNombre()==null){
            throw new ApiRequestException("Se requiere el nombre");
        } else if(empleadoDTO.getApellido()==null){
            throw new ApiRequestException("Se requiere el apellido");
        } else if(empleadoDTO.getCedula()==null){
            throw new ApiRequestException("Se requiere una identificacion valida");
        }
        List<Integer> cedulasEmpleados = new ArrayList<>();
        this.empleadoRepository.findAll()
                .stream()
                .forEach(empleado1 -> cedulasEmpleados.add(empleado1.getCedula()));
        if(cedulasEmpleados.contains(empleadoDTO.getCedula())){
            throw new ApiRequestException("La cedula "+empleadoDTO.getCedula()+" ya se encuentra registrada");
        }
        Empleado empleado = new Empleado(
                empleadoDTO.getCedula(),
                empleadoDTO.getNombre(),
                empleadoDTO.getApellido(),
                empleadoDTO.getCelular(),
                empleadoDTO.getCorreo(),
                empleadoDTO.getDireccionResidencial(),
                empleadoDTO.getCiudad(),
                empleadoDTO.getAntiguedad(),
                empleadoDTO.getRh(),
                empleadoDTO.getTipoEmpleado()
        );
        this.empleadoRepository.save(empleado);
        return empleadoDTO;
    }

    public EmpleadoDTO getEmpleadoPorCedula(Integer cedula){
        Optional<Empleado> empleado = this.empleadoRepository.findById(cedula);
        if(empleado.isPresent()){
            EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                    empleado.get().getCedula(),
                    empleado.get().getNombre(),
                    empleado.get().getApellido(),
                    empleado.get().getCelular(),
                    empleado.get().getCorreoElectronico(),
                    empleado.get().getDireccionResidencial(),
                    empleado.get().getCiudad(),
                    empleado.get().getAntiguedad(),
                    empleado.get().getRh(),
                    empleado.get().getTipoEmpleado()
            );
            return empleadoDTO;
        }
        throw new ApiRequestException("La cedula "+cedula+" no se encuentra registrada");
    }

    public void eliminarEmpleado(Integer cedula){
        this.empleadoRepository.deleteById(cedula);
    }
}
