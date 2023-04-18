package com.manuel.proyectointegrador.Mapper;

import com.manuel.proyectointegrador.dto.EmpleadoDTO;
import com.manuel.proyectointegrador.model.Empleado;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T17:21:16-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Override
    public EmpleadoDTO empleadoToEmpleadoDTO(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        empleadoDTO.setCedula( empleado.getCedula() );
        empleadoDTO.setNombre( empleado.getNombre() );
        empleadoDTO.setApellido( empleado.getApellido() );
        empleadoDTO.setCelular( empleado.getCelular() );
        empleadoDTO.setDireccionResidencial( empleado.getDireccionResidencial() );
        empleadoDTO.setCiudad( empleado.getCiudad() );
        empleadoDTO.setAntiguedad( empleado.getAntiguedad() );
        empleadoDTO.setRh( empleado.getRh() );
        empleadoDTO.setTipoEmpleado( empleado.getTipoEmpleado() );

        return empleadoDTO;
    }

    @Override
    public Empleado empleadoDTOtoEmpleado(EmpleadoDTO empleadoDTO) {
        if ( empleadoDTO == null ) {
            return null;
        }

        Empleado empleado = new Empleado();

        if ( empleadoDTO.getCedula() != null ) {
            empleado.setCedula( empleadoDTO.getCedula() );
        }
        empleado.setNombre( empleadoDTO.getNombre() );
        empleado.setApellido( empleadoDTO.getApellido() );
        empleado.setCelular( empleadoDTO.getCelular() );
        empleado.setDireccionResidencial( empleadoDTO.getDireccionResidencial() );
        empleado.setCiudad( empleadoDTO.getCiudad() );
        empleado.setAntiguedad( empleadoDTO.getAntiguedad() );
        empleado.setRh( empleadoDTO.getRh() );
        empleado.setTipoEmpleado( empleadoDTO.getTipoEmpleado() );

        return empleado;
    }
}
