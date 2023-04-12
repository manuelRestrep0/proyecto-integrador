package com.manuel.proyectointegrador.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Cliente")
public class ClienteDTO {

    @ApiModelProperty(position = 0)
    private Integer cedula;
    @ApiModelProperty(position = 1)
    private String nombre;
    @ApiModelProperty(position = 2)
    private String apellido;
    @ApiModelProperty(position = 3)
    private String celular;
    @ApiModelProperty(position = 4)
    private String correo;
    @ApiModelProperty(position = 5)
    private String direccionResidencial;
    @ApiModelProperty(position = 6)
    private String ciudad;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer cedula, String nombre, String apellido, String celular, String correo, String direccionResidencial, String ciudad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccionResidencial = direccionResidencial;
        this.ciudad = ciudad;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionResidencial() {
        return direccionResidencial;
    }

    public void setDireccionResidencial(String direccionResidencial) {
        this.direccionResidencial = direccionResidencial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
