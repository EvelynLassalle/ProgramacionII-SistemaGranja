
package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Riego {

    private int id;
    private LocalDate fecha;
    private double cantidadAgua;
    private String observaciones;
    private final Cultivo cultivo;

    // Constructor
    public Riego(int id, LocalDate fecha, double cantidadAgua,
                 String observaciones, Cultivo cultivo) {

        this.id = id;
        this.fecha = fecha;
        this.cantidadAgua = cantidadAgua;
        this.observaciones = observaciones;
        this.cultivo = Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio"
        );
    }

    // Validaciones
    public void validar() {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID del riego debe ser positivo"
            );
        }

        if (fecha == null) {
            throw new IllegalArgumentException(
                "La fecha del riego es obligatoria"
            );
        }

        if (!Double.isFinite(cantidadAgua) ||
                cantidadAgua <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de agua debe ser mayor a cero"
            );
        }

        if (fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "El riego no puede ser anterior a la siembra"
            );
        }
    }

    // Registrar el riego en la lista del cultivo
    public void registrar() {
        validar();
        cultivo.agregarRiego(this);
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidadAgua() {
        return cantidadAgua;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }

    // Setters
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser positivo"
            );
        }
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        Objects.requireNonNull(fecha, "La fecha es obligatoria");

        if (fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "El riego no puede ser anterior a la siembra"
            );
        }

        this.fecha = fecha;
    }

    public void setCantidadAgua(double cantidadAgua) {
        if (!Double.isFinite(cantidadAgua) ||
                cantidadAgua <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de agua debe ser positiva"
            );
        }
        this.cantidadAgua = cantidadAgua;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
