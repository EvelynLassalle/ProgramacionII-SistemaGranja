package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class Riego extends Cultivo {

    // El atributo id y sus accesores se heredan de Cultivo.
    private LocalDate fecha;
    private double cantidadAgua;
    private String observaciones;
    private final Cultivo cultivo;

    public Riego(int id, LocalDate fecha, double cantidadAgua,
                 String observaciones, Cultivo cultivo) {
        super(id, cultivo);
        this.fecha = fecha;
        this.cantidadAgua = cantidadAgua;
        this.observaciones = observaciones;
        this.cultivo = cultivo;
    }

    @Override
    public void registrar() {
        validarId();

        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria.");
        }

        if (!Double.isFinite(cantidadAgua) || cantidadAgua <= 0) {
            throw new IllegalStateException(
                "La cantidad de agua debe ser positiva."
            );
        }

        cultivo.agregarRiego(this);
        marcarRegistrado();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCantidadAgua() {
        return cantidadAgua;
    }

    public void setCantidadAgua(double cantidadAgua) {
        this.cantidadAgua = cantidadAgua;
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