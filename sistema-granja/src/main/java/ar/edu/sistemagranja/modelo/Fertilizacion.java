
package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Fertilizacion {

    private int id;
    private LocalDate fecha;
    private String producto;
    private double cantidad;
    private String observaciones;
    private final Cultivo cultivo;

    // Constructor
    public Fertilizacion(int id, LocalDate fecha, String producto,
                         double cantidad, String observaciones,
                         Cultivo cultivo) {

        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.cultivo = Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio"
        );
    }

    // Validar los datos de la fertilización
    public void validar() {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser positivo"
            );
        }

        if (fecha == null) {
            throw new IllegalArgumentException(
                "La fecha es obligatoria"
            );
        }

        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException(
                "El producto es obligatorio"
            );
        }

        if (!Double.isFinite(cantidad) || cantidad <= 0) {
            throw new IllegalArgumentException(
                "La cantidad debe ser mayor a cero"
            );
        }

        if (cultivo.getFechaSiembra() == null) {
            throw new IllegalStateException(
                "El cultivo debe tener fecha de siembra"
            );
        }

        if (fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "La fertilización no puede ser anterior a la siembra"
            );
        }
    }

    // Registrar en la lista del cultivo (en memoria)
    public void registrar() {
        validar();
        cultivo.agregarFertilizacion(this);
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
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

        if (cultivo.getFechaSiembra() == null ||
                fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "La fecha no puede ser anterior a la siembra"
            );
        }

        this.fecha = fecha;
    }

    public void setProducto(String producto) {
        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException(
                "El producto es obligatorio"
            );
        }

        this.producto = producto;
    }

    public void setCantidad(double cantidad) {
        if (!Double.isFinite(cantidad) || cantidad <= 0) {
            throw new IllegalArgumentException(
                "La cantidad debe ser mayor a cero"
            );
        }

        this.cantidad = cantidad;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
