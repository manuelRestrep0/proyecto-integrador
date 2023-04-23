package com.manuel.proyectointegrador.dto;

public class EnvioUpdateDTO {

    private Integer numGuia;
    private String estadoEnvio;
    private Integer cedulaEmpleado;

    public EnvioUpdateDTO(Integer numGuia, String estadoEnvio, Integer cedulaEmpleado) {
        this.numGuia = numGuia;
        this.estadoEnvio = estadoEnvio;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Integer getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(Integer numGuia) {
        this.numGuia = numGuia;
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
