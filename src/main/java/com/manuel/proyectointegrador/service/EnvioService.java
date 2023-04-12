package com.manuel.proyectointegrador.service;

import com.manuel.proyectointegrador.dto.EnvioDTO;
import com.manuel.proyectointegrador.exception.ApiRequestException;
import com.manuel.proyectointegrador.model.Cliente;
import com.manuel.proyectointegrador.model.Empleado;
import com.manuel.proyectointegrador.model.Envio;
import com.manuel.proyectointegrador.model.Paquete;
import com.manuel.proyectointegrador.repository.ClienteRepository;
import com.manuel.proyectointegrador.repository.EmpleadoRepository;
import com.manuel.proyectointegrador.repository.EnvioRepository;
import com.manuel.proyectointegrador.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnvioService {

    private EnvioRepository envioRepository;
    private ClienteRepository clienteRepository;
    private EmpleadoRepository empleadoRepository;
    private PaqueteRepository paqueteRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository, ClienteRepository clienteRepository, EmpleadoRepository empleadoRepository, PaqueteRepository paqueteRepository) {
        this.envioRepository = envioRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
        this.paqueteRepository = paqueteRepository;
    }

    public String crearEnvio(EnvioDTO envioDTO){
        if(envioDTO.getCedulaCliente()==null || envioDTO.getCiudadDestino()==null ||
            envioDTO.getCiudadOrigen()==null || envioDTO.getDireccionDestino()==null
                || envioDTO.getNombreRecibe()==null || envioDTO.getNumRecibe()==null
                || envioDTO.getValorDeclaradoPaquete()==null || envioDTO.getPeso()==null){
            throw new ApiRequestException("Hace falta llenar todos los campos");
        }
        Optional<Cliente> cliente = this.clienteRepository.findById(envioDTO.getCedulaCliente());
        if(cliente.isPresent()){
            Paquete paquete = new Paquete(asignarTipoPaquete(envioDTO.getPeso()),envioDTO.getPeso(),envioDTO.getValorDeclaradoPaquete());
            this.paqueteRepository.save(paquete);
            Envio envio = new Envio(
                cliente.get(),envioDTO.getCiudadOrigen(),envioDTO.getCiudadDestino(),envioDTO.getDireccionDestino(),
                    envioDTO.getNombreRecibe(),envioDTO.getNumRecibe(),asignarHora(),"RECIBIDO",asignarPrecioEnvio(paquete.getTipoPaquete())
                    ,paquete
            );
            this.envioRepository.save(envio);
            return envio.toString();
        } else{
            throw new ApiRequestException("El cliente con cedula "+envioDTO.getCedulaCliente()+" debe de estar registrado para poder enviar el paquete.");
        }
    }
    public EnvioDTO buscarEnvio(Integer guia){
        Optional<Envio> envio = this.envioRepository.findById(guia);
        if(envio.isPresent()){
            EnvioDTO envioDTO = new EnvioDTO(
                    envio.get().getCliente().getCedula()
                    ,envio.get().getCiudadOrigen()
                    ,envio.get().getCiudadDestino()
                    ,envio.get().getDireccionDestino()
                    ,envio.get().getNombreRecibe()
                    ,envio.get().getNumeroRecibe()
                    ,envio.get().getPaquete().getValorDeclarado()
                    ,envio.get().getPaquete().getPeso()
            );
            envioDTO.setEstadoEnvio(envio.get().getEstadoEnvio());
            envioDTO.setValorEnvio(envio.get().getValorEnvio());
            return envioDTO;
        }
        throw new ApiRequestException("El numero guia no se encuentra registrado");
    }

    public String actualizarEstado(Integer numGuia, Integer cedulaEmpleado, String estado){
        Optional<Empleado> empleado = this.empleadoRepository.findById(cedulaEmpleado);
        if(empleado.isPresent()){
            String tipo = empleado.get().getTipoEmpleado();
            if(tipo.equals("REPARTIDOR") || tipo.equals("COORDINADOR")){
                Optional<Envio> envio = this.envioRepository.findById(numGuia);
                if(envio.isPresent()){
                    String estadoEnvio = envio.get().getEstadoEnvio();
                    if(estadoEnvio.equals("RECIBIDO")){
                        if(estado.equals("EN RUTA")){
                            envio.get().setEstadoEnvio(estado);
                            this.envioRepository.save(envio.get());
                            return "{\n" +
                                    "numeroGuia=" + numGuia +
                                    "\nultimoEstado='" + estado + "'\n" +
                                    '}';
                        }
                        throw new ApiRequestException("El cambio de estado no cumple con las validaciones");
                    } else if(estadoEnvio.equals("EN RUTA")){
                        if(estado.equals("ENTREGADO")){
                            envio.get().setEstadoEnvio(estado);
                            return "{\n" +
                                "numeroGuia=" + numGuia +
                                        "\nultimoEstado='" + estado + "'\n" +
                                        '}';
                        }
                    }
                    throw new ApiRequestException("El envio ya ha sido entregado");
                }
                throw new ApiRequestException("El numero guia no se encuentra registrado");
            }
            throw new ApiRequestException("Este empleado no puede realizar el cambio solicitado");
        }
        throw new ApiRequestException("El empleado con cedula "+cedulaEmpleado+" no existe en nuestra compania");
    }

    public List<EnvioDTO> filtrar(String estado, Integer cedulaEmpleado){
        Optional<Empleado> empleado = this.empleadoRepository.findById(cedulaEmpleado);
        if(empleado.isPresent()){
            List<Envio> envios = this.envioRepository.findAll();
            envios = envios.stream()
                    .filter(envio -> envio.getEstadoEnvio().equals(estado))
                    .collect(Collectors.toList());
            List<EnvioDTO> enviosDTO = new ArrayList<>();
            envios.stream()
                    .forEach(envio -> enviosDTO.add(new EnvioDTO(
                            envio.getCliente().getCedula(),
                            envio.getCiudadOrigen(),
                            envio.getCiudadDestino(),
                            envio.getDireccionDestino(),
                            envio.getNombreRecibe(),
                            envio.getNumeroRecibe(),
                            envio.getPaquete().getValorDeclarado(),
                            envio.getPaquete().getPeso(),
                            envio.getValorEnvio(),
                            envio.getEstadoEnvio(),
                            envio.getNumeroGuia()
                    )));
            return enviosDTO;
        }
        throw new ApiRequestException("El empleado con cedula "+cedulaEmpleado+" no existe en nuestra compania");
    }

    public String asignarTipoPaquete(Integer peso){
        if(peso<2){
            return "LIVIANO";
        } else if(peso>=2 && peso<5){
            return "MEDIANO";
        }
        return "GRANDE";
    }
    public Double asignarPrecioEnvio(String tipo){
        if(tipo.equals("GRANDE")){
            return 50000.0;
        } else if(tipo.equals("MEDIANO")){
            return 40000.0;
        }
        return 30000.0;
    }
    public String asignarHora(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
