package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class Fertilizacion extends Cultivo {

    private LocalDate fecha;
    private String producto;
    private double cantidad;
    private String observaciones;
    private final Cultivo cultivo;

    public Fertilizacion(int id, LocalDate fecha, String producto,
                         double cantidad, String observaciones,
                         Cultivo cultivo) {
        super(id, cultivo);
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.cultivo = cultivo;
    }

    @Override
    public void registrar() {
        validarId();

        if (fecha == null) {
            throw new IllegalStateException("La fecha es obligatoria.");
        }

        if (producto == null || producto.trim().isEmpty()) {
            throw new IllegalStateException("El producto es obligatorio.");
        }

        if (!Double.isFinite(cantidad) || cantidad <= 0) {
            throw new IllegalStateException(
                "La cantidad de fertilizante debe ser positiva."
            );
        }

        cultivo.agregarFertilizacion(this);
        marcarRegistrado();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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