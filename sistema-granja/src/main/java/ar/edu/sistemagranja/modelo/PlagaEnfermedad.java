
package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class PlagaEnfermedad {

    private int id;
    private LocalDate fecha;
    private String tipo;
    private String descripcion;
    private String nivelAfectacion;
    private final Cultivo cultivo;

    // Constructor
    public PlagaEnfermedad(int id, LocalDate fecha, String tipo,
                          String descripcion, String nivelAfectacion,
                          Cultivo cultivo) {

        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelAfectacion = nivelAfectacion;
        this.cultivo = Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio"
        );
    }

    // Validaciones de los datos
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

        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                "El tipo de plaga o enfermedad es obligatorio"
            );
        }

        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                "La descripción es obligatoria"
            );
        }

        if (nivelAfectacion == null || nivelAfectacion.isBlank()) {
            throw new IllegalArgumentException(
                "El nivel de afectación es obligatorio"
            );
        }

        if (cultivo.getFechaSiembra() == null) {
            throw new IllegalStateException(
                "El cultivo debe tener fecha de siembra"
            );
        }

        if (fecha.isBefore(cultivo.getFechaSiembra())) {
            throw new IllegalArgumentException(
                "La fecha de la plaga no puede ser anterior a la siembra"
            );
        }
    }

    // Registrar la plaga en el cultivo (en memoria)
    public void registrar() {
        validar();
        cultivo.agregarPlagaEnfermedad(this);
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivelAfectacion() {
        return nivelAfectacion;
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

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                "El tipo es obligatorio"
            );
        }
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                "La descripción es obligatoria"
            );
        }
        this.descripcion = descripcion;
    }

    public void setNivelAfectacion(String nivelAfectacion) {
        if (nivelAfectacion == null || nivelAfectacion.isBlank()) {
            throw new IllegalArgumentException(
                "El nivel de afectación es obligatorio"
            );
        }
        this.nivelAfectacion = nivelAfectacion;
    }
}
