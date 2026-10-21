package ar.edu.sistemagranja.modelo;

public class DetalleCompra {
    
    private int cantidad;
    private double precioUnitario;

    public DetalleCompra (int cantidad, double precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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
}
