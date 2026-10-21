package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class PlagaEnfermedad extends Cultivo {

    private LocalDate fecha;
    private String tipo;
    private String descripcion;
    private String nivelAfectacion;
    private final Cultivo cultivo;

    public PlagaEnfermedad(int id, LocalDate fecha, String tipo,
                          String descripcion, String nivelAfectacion,
                          Cultivo cultivo) {
        super(id, cultivo);
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelAfectacion = nivelAfectacion;
        this.cultivo = cultivo;
    }

    @Override
    public void registrar() {
        validarId();

        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria.");
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalStateException(
                "El tipo de plaga o enfermedad es obligatorio."
            );
        }

        if (nivelAfectacion == null || nivelAfectacion.trim().isEmpty()) {
            throw new IllegalStateException(
                "El nivel de afectación es obligatorio."
            );
        }

        cultivo.agregarPlagaEnfermedad(this);
        marcarRegistrado();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelAfectacion() {
        return nivelAfectacion;
    }

    public void setNivelAfectacion(String nivelAfectacion) {
        this.nivelAfectacion = nivelAfectacion;
    }

    public Cultivo getCultivo() {
        return cultivo;
    }
}