package com.example.wposs_user.polariscoreandroid;

public class Terminal {


String serial,marca,modelo, tecnologia,estado,fechaLimite;


    public Terminal(String serial, String marca, String modelo, String tecnologia, String estado, String fechaLimite) {
        this.serial = serial;
        this.marca = marca;
        this.modelo = modelo;
        this.tecnologia = tecnologia;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
    }


    public Terminal() {
    }


    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}

