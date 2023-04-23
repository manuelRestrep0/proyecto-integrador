package com.manuel.proyectointegrador.dto;

public class EnvioFilterDTO {

    private String estadoEnvio;
    private Integer cedulaEmpleado;

    public EnvioFilterDTO(String estadoEnvio, Integer cedulaEmpleado) {
        this.estadoEnvio = estadoEnvio;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }
}
