package ar.edu.sistemagranja.modelo;

public class DetalleCompra {
    
    private int cantidad;
    private double precioUnitario;

    public DetalleCompra (int cantidad, double precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        validar();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double calcularSubtotal() {

        return cantidad * precioUnitario;
    }

    public void validar() {

        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                "La cantidad debe ser mayor a cero"
            );
        }

        if (precioUnitario <= 0 || !Double.isFinite(precioUnitario)) {
            throw new IllegalArgumentException(
                "El precio unitario debe ser mayor a cero y válido"
            );
        }
    }
}
