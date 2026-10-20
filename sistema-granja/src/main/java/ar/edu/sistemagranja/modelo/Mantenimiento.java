package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class Mantenimiento {
    private int id;
    private LocalDate fecha;
    private String elemento;
    private String descripcion;
    private double costo;
    private String responsable;
    private EstadoMantenimiento estado;

    public Mantenimiento() {
    }

    public Mantenimiento(int id, LocalDate fecha, String elemento, String descripcion, double costo, String responsable, EstadoMantenimiento estado) {
        this.id = id;
        this.fecha = fecha;
        this.elemento = elemento;
        this.descripcion = descripcion;
        this.costo = costo;
        this.responsable = responsable;
        this.estado = estado;
    }

    public void registrar() {
    }

    public void cambiarEstado(EstadoMantenimiento nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public EstadoMantenimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoMantenimiento estado) {
        this.estado = estado;
    }
}