package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Cosecha {

    private int id;
    private LocalDate fecha;
    private double cantidad;
    private String unidad;
    private String observaciones;
    private final Cultivo cultivo;
    private boolean registrado;

    public Cosecha(int id, LocalDate fecha, double cantidad,
                   String unidad, String observaciones, Cultivo cultivo) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.observaciones = observaciones;
        this.cultivo = Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio."
        );
    }
    
    public Cosecha(){
        this.cultivo = null;
    }

    public void registrar() {
        if (id <= 0) {
            throw new IllegalStateException("El ID debe ser positivo.");
        }

        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria.");
        }

        if (!Double.isFinite(cantidad) || cantidad <= 0) {
            throw new IllegalStateException(
                "La cantidad cosechada debe ser positiva."
            );
        }

        if (unidad == null || unidad.trim().isEmpty()) {
            throw new IllegalStateException("La unidad es obligatoria.");
        }

        cultivo.agregarCosecha(this);
        registrado = true;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    public boolean isRegistrado() {
        return registrado;
    }
}