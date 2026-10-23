package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.sistemagranja.modelo.enums.CategoriaGasto;

public class Compra extends Gasto {

    private List<DetalleCompra> detalles = new ArrayList<>();

    public Compra(int id, LocalDate fecha, String concepto, double monto, String descripcion, CategoriaGasto categoria) {
        super(id, fecha, concepto, monto, descripcion, categoria);
    }
    
    public void agregarDetalle(DetalleCompra detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException("El detalle no puede ser nulo");
        }
        detalles.add(detalle);
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    
    @Override
    public void validar() {
        super.validar();
        if (detalles.isEmpty()) {
            throw new IllegalArgumentException("La compra debe tener al menos un detalle.");
        }

        for (DetalleCompra detalle : detalles) {
            if (detalle == null) {
                throw new IllegalArgumentException(
                    "La compra no puede contener detalles nulos"
                );
            }
        }
        if (calcularTotal() != getMonto()) {
            throw new IllegalArgumentException("El monto de la compra no coincide con la suma de los detalles.");
        }
    }

    @Override
    public double calcularImpacto() {
        return 0;
    }

    public double calcularTotal() {
        double acumulador = 0;
        for (DetalleCompra d : detalles) {
            acumulador += d.calcularSubtotal();
        }
        return acumulador;
        
    }
}
