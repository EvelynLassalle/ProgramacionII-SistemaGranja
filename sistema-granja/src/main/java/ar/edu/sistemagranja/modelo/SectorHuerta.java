
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

    // Constructor
    public SectorHuerta(int id, String codigo, String nombre,
                        String ubicacion, double superficie) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
    }

    // Validar los datos del sector
    public void validar() {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID del sector debe ser positivo"
            );
        }

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                "El código del sector es obligatorio"
            );
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre del sector es obligatorio"
            );
        }

        if (!Double.isFinite(superficie) || superficie <= 0) {
            throw new IllegalArgumentException(
                "La superficie del sector debe ser positiva"
            );
        }
    }

    // Registrar el sector en memoria
    public void registrar() {
        validar();
        registrado = true;
    }

    // Asociar un cultivo con este sector
    public void agregarCultivo(Cultivo cultivo) {

        Objects.requireNonNull(
            cultivo, "El cultivo es obligatorio"
        );

        if (cultivo.getSector() != this) {
            throw new IllegalArgumentException(
                "El cultivo pertenece a otro sector"
            );
        }

        cultivo.validar();

        if (!cultivos.contains(cultivo)) {
            cultivos.add(cultivo);
        }
    }

    // Consultar los cultivos del sector
    public List<Cultivo> listarCultivos() {
        return Collections.unmodifiableList(cultivos);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    // Setters con validaciones
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                "El ID debe ser positivo"
            );
        }
        this.id = id;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                "El código es obligatorio"
            );
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre es obligatorio"
            );
        }
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setSuperficie(double superficie) {
        if (!Double.isFinite(superficie) || superficie <= 0) {
            throw new IllegalArgumentException(
                "La superficie debe ser positiva"
            );
        }
        this.superficie = superficie;
    }
}
