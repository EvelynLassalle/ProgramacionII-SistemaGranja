package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

import ar.edu.sistemagranja.modelo.enums.TipoIngreso;

public class Ingreso extends Movimiento {

    private TipoIngreso tipoIngreso;

    public Ingreso(int id, LocalDate fecha, String concepto, double monto, String descripcion, TipoIngreso tipoIngreso) {
        super(id, fecha, concepto, monto, descripcion);
        this.tipoIngreso = tipoIngreso;
    }

    public TipoIngreso getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngreso tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }


}
