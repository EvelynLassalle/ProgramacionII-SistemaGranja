
package ar.edu.sistemagranja.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SectorHuerta {

    private int id;
    private String codigo;
    private String nombre;
    private String ubicacion;
    private double superficie;
    private boolean registrado;

    private final List<Cultivo> cultivos = new ArrayList<>();

    public SectorHuerta(int id, String codigo, String nombre,
                        String ubicacion, double superficie) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
    }

    public void registrar() {
        if (id <= 0) {
            throw new IllegalStateException("El ID debe ser positivo.");
        }

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalStateException("El código es obligatorio.");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalStateException("El nombre es obligatorio.");
        }

        if (!Double.isFinite(superficie) || superficie <= 0) {
            throw new IllegalStateException(
                "La superficie debe ser positiva."
            );
        }

        registrado = true;
    }

    public void agregarCultivo(Cultivo cultivo) {
        Objects.requireNonNull(cultivo, "El cultivo es obligatorio.");

        if (cultivo.getSector() != this) {
            throw new IllegalArgumentException(
                "El cultivo pertenece a otro sector."
            );
        }

        // Los registros heredan de Cultivo según el diagrama,
        // pero no se incorporan como cultivos independientes.
        if (cultivo instanceof Riego
                || cultivo instanceof Fertilizacion
                || cultivo instanceof PlagaEnfermedad
                || cultivo instanceof TratamientoCultivo) {
            throw new IllegalArgumentException(
                "Un registro no se agrega como cultivo del sector."
            );
        }

        if (!cultivos.contains(cultivo)) {
            cultivos.add(cultivo);
        }
    }

    public List<Cultivo> listarCultivos() {
        return Collections.unmodifiableList(cultivos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public boolean isRegistrado() {
        return registrado;
    }
}