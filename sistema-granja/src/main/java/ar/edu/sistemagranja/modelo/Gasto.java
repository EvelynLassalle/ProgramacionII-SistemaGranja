package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

import ar.edu.sistemagranja.modelo.enums.CategoriaGasto;

public class Gasto extends Movimiento {

    private CategoriaGasto categoria;

    public Gasto(int id, LocalDate fecha, String concepto, double monto, String descripcion, CategoriaGasto categoria) {
        super(id, fecha, concepto, monto, descripcion);
        this.categoria = categoria;
    }

    public CategoriaGasto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaGasto categoria) {
        this.categoria = categoria;
    }

    @Override
    public void registrar() {
    }

    @Override
    public void validar() {
    }

    @Override
    public double calcularImpacto() {
        return 0;
    }
}
