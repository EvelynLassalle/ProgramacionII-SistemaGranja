package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ar.edu.sistemagranja.modelo.enums.EstadoCultivo;

public class Cultivo {

    private int id;
    private String nombre;
    private String variedad;
    private LocalDate fechaSiembra;
    private double superficie;
    private double cantidadSembrada;
    private EstadoCultivo estado;
    private LocalDate fechaEstimadaCosecha;

    private final SectorHuerta sector;
    private boolean registrado;

    private final List<Cosecha> cosechas = new ArrayList<>();
    private final List<Riego> riegos = new ArrayList<>();
    private final List<Fertilizacion> fertilizaciones = new ArrayList<>();
    private final List<PlagaEnfermedad> plagasEnfermedades = new ArrayList<>();
    private final List<TratamientoCultivo> tratamientos = new ArrayList<>();
    private final List<String> historial = new ArrayList<>();

    public Cultivo(int id, String nombre, String variedad,
                   LocalDate fechaSiembra, double superficie,
                   double cantidadSembrada, EstadoCultivo estado,
                   LocalDate fechaEstimadaCosecha, SectorHuerta sector) {
        this.id = id;
        this.nombre = nombre;
        this.variedad = variedad;
        this.fechaSiembra = fechaSiembra;
        this.superficie = superficie;
        this.cantidadSembrada = cantidadSembrada;
        this.estado = Objects.requireNonNull(
            estado, "El estado es obligatorio."
        );
        this.fechaEstimadaCosecha = fechaEstimadaCosecha;
        this.sector = Objects.requireNonNull(
            sector, "El sector es obligatorio."
        );
    }

 
    public void registrar() {
        validar();

        sector.agregarCultivo(this);

        if (!registrado) {
            registrado = true;
            historial.add("Cultivo registrado: " + nombre);
        }
    }

    public void validar() {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre es obligatorio"
            );
        }

        if (fechaSiembra == null) {
            throw new IllegalArgumentException(
                "La fecha de siembra es obligatoria"
            );
        }

        if (!Double.isFinite(superficie) || superficie <= 0) {
            throw new IllegalArgumentException(
                "La superficie debe ser mayor que cero"
            );
        }

        if (!Double.isFinite(cantidadSembrada) ||
                cantidadSembrada <= 0) {
            throw new IllegalArgumentException(
                "La cantidad sembrada debe ser mayor que cero"
            );
        }

        if (fechaEstimadaCosecha != null &&
                fechaEstimadaCosecha.isBefore(fechaSiembra)) {
            throw new IllegalArgumentException(
                "La cosecha estimada no puede ser anterior a la siembra"
            );
        }
    }


    public void cambiarEstado(EstadoCultivo nuevoEstado) {
        Objects.requireNonNull(nuevoEstado, "El estado es obligatorio.");

        if (estado != nuevoEstado) {
            historial.add("Estado: " + estado + " -> " + nuevoEstado);
            estado = nuevoEstado;
        }
    }

    public double consultarProduccion() {
        if (cosechas.isEmpty()) {
            return 0;
        }

        String unidad = cosechas.get(0).getUnidad();
        double total = 0;

        for (Cosecha cosecha : cosechas) {
            if (!Objects.equals(unidad, cosecha.getUnidad())) {
                throw new IllegalStateException(
                    "Las cosechas deben usar la misma unidad."
                );
            }

            total += cosecha.getCantidad();
        }

        return total;
    }

    public List<String> consultarHistorial() {
        return Collections.unmodifiableList(historial);
    }

    void agregarCosecha(Cosecha cosecha) {
        verificarCultivo(cosecha.getCultivo());

        if (!cosechas.contains(cosecha)) {
            cosechas.add(cosecha);
            historial.add("Cosecha registrada: " + cosecha.getFecha());
        }
    }

    void agregarRiego(Riego riego) {
        verificarCultivo(riego.getCultivo());

        if (!riegos.contains(riego)) {
            riegos.add(riego);
            historial.add("Riego registrado: " + riego.getFecha());
        }
    }

    void agregarFertilizacion(Fertilizacion fertilizacion) {
        verificarCultivo(fertilizacion.getCultivo());

        if (!fertilizaciones.contains(fertilizacion)) {
            fertilizaciones.add(fertilizacion);
            historial.add(
                "Fertilización registrada: " + fertilizacion.getFecha()
            );
        }
    }

    void agregarPlagaEnfermedad(PlagaEnfermedad plaga) {
        verificarCultivo(plaga.getCultivo());

        if (!plagasEnfermedades.contains(plaga)) {
            plagasEnfermedades.add(plaga);
            historial.add(
                "Plaga o enfermedad registrada: " + plaga.getFecha()
            );
        }
    }

    void agregarTratamiento(TratamientoCultivo tratamiento) {
        verificarCultivo(tratamiento.getCultivo());

        if (!tratamientos.contains(tratamiento)) {
            tratamientos.add(tratamiento);
            historial.add(
                "Tratamiento registrado: " + tratamiento.getFecha()
            );
        }
    }

    private void verificarCultivo(Cultivo cultivo) {
        if (cultivo != this) {
            throw new IllegalArgumentException(
                "El registro pertenece a otro cultivo."
            );
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getVariedad() { return variedad; }
    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public LocalDate getFechaSiembra() { return fechaSiembra; }
    public void setFechaSiembra(LocalDate fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public double getSuperficie() { return superficie; }
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getCantidadSembrada() { return cantidadSembrada; }
    public void setCantidadSembrada(double cantidadSembrada) {
        this.cantidadSembrada = cantidadSembrada;
    }

    public EstadoCultivo getEstado() { return estado; }
    public void setEstado(EstadoCultivo estado) {
        cambiarEstado(estado);
    }

    public LocalDate getFechaEstimadaCosecha() {
        return fechaEstimadaCosecha;
    }

    public void setFechaEstimadaCosecha(LocalDate fechaEstimadaCosecha) {
        this.fechaEstimadaCosecha = fechaEstimadaCosecha;
    }

    public SectorHuerta getSector() {
        return sector;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public List<Cosecha> getCosechas() {
        return Collections.unmodifiableList(cosechas);
    }

    public List<Riego> getRiegos() {
        return Collections.unmodifiableList(riegos);
    }

    public List<Fertilizacion> getFertilizaciones() {
        return Collections.unmodifiableList(fertilizaciones);
    }

    public List<PlagaEnfermedad> getPlagasEnfermedades() {
        return Collections.unmodifiableList(plagasEnfermedades);
    }

    public List<TratamientoCultivo> getTratamientos() {
        return Collections.unmodifiableList(tratamientos);
    }
}