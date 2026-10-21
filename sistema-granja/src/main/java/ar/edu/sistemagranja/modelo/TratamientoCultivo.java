package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class TratamientoCultivo extends Cultivo {

    private LocalDate fecha;
    private String descripcion;
    private String producto;
    private String dosis;
    private String observaciones;
    private final Cultivo cultivo;

    public TratamientoCultivo(int id, LocalDate fecha, String descripcion,
                             String producto, String dosis,
                             String observaciones, Cultivo cultivo) {
        super(id, cultivo);
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.producto = producto;
        this.dosis = dosis;
        this.observaciones = observaciones;
        this.cultivo = cultivo;
    }

    @Override
    public void registrar() {
        validarId();

        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalStateException(
                "La descripción del tratamiento es obligatoria."
            );
        }

        cultivo.agregarTratamiento(this);
        marcarRegistrado();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
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
}