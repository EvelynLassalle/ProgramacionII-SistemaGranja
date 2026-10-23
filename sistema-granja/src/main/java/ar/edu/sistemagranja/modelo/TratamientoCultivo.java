package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class TratamientoCultivo {

    private int id;
    private LocalDate fecha;
    private String descripcion;
    private String producto;
    private String dosis;
    private String observaciones;
    private final Cultivo cultivo;

    public TratamientoCultivo(int id, LocalDate fecha,
                             String descripcion, String producto,
                             String dosis, String observaciones,
                             Cultivo cultivo) {

        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.producto = producto;
        this.dosis = dosis;
        this.observaciones = observaciones;
        this.cultivo = Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio"
        );
    }

    // Validaciones
    public void validar() {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser mayor que cero"
            );
        }

        if (fecha == null) {
            throw new IllegalArgumentException(
                "La fecha es obligatoria"
            );
        }

        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                "La descripción del tratamiento es obligatoria"
            );
        }

        if (cultivo.getFechaSiembra() == null) {
            throw new IllegalStateException(
                "El cultivo debe tener fecha de siembra"
            );
        }

        if (fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "El tratamiento no puede ser anterior a la siembra"
            );
        }

        // Si se utiliza un producto, debe indicarse una dosis
        if (producto != null && !producto.isBlank()) {
            if (dosis == null || dosis.isBlank()) {
                throw new IllegalArgumentException(
                    "Debe indicar la dosis del producto"
                );
            }
        }

        // Si hay una dosis, debe existir un producto
        if (dosis != null && !dosis.isBlank()) {
            if (producto == null || producto.isBlank()) {
                throw new IllegalArgumentException(
                    "Debe indicar el producto utilizado"
                );
            }
        }
    }

    // Registro en memoria
    public void registrar() {
        validar();
        cultivo.agregarTratamiento(this);
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getProducto() {
        return producto;
    }

    public String getDosis() {
        return dosis;
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

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                "La descripción es obligatoria"
            );
        }
        this.descripcion = descripcion;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
