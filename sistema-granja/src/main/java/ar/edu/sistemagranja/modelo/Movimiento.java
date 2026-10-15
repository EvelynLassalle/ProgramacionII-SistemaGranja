package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import ar.edu.sistemagranja.modelo.enums.TipoMovimiento;

public class Movimiento {
    
    private int id;
    private LocalDate fecha;
    private String concepto;
    private double monto;
    private TipoMovimiento tipo;
    private String descripcion;

    public Movimiento(int id, LocalDate fecha, String concepto, 
    double monto, TipoMovimiento tipo, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.tipo = tipo;
        this.descripcion = descripcion;
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

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void registrar() {}

}

