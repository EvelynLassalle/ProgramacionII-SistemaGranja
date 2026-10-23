package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public abstract class Movimiento {

    private int id;
    private LocalDate fecha;
    private String concepto;
    private double monto;
    private String descripcion;

    public Movimiento(int id, LocalDate fecha, String concepto, double monto, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Movimiento() {

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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public  void validar(){
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es obligatoria");
        }

        if (concepto == null || concepto.isBlank()) {
            throw new IllegalArgumentException("El concepto no puede estar vacío");
        }

        if (monto <= 0 || !Double.isFinite(monto)) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero y válido");
        }
    }

    public  double calcularImpacto(){
        return monto;
    }
}
