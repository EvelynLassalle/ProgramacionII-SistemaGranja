
//RF25 – Registrar reproducción

public class Reproduccion {
    String fechaServicio;
    String hembra;
    String macho;
    String estado;
    String fechaProbableParto;

    public Reproduccion(String fechaServicio, String hembra, String macho, String estado, String fechaProbableParto) {
        
        this.fechaServicio = fechaServicio;
        this.hembra = hembra;
        this.macho = macho;
        this.estado = estado;
        this.fechaProbableParto = fechaProbableParto;
    }

    public void mostrarDatos() {
        System.out.println("Fecha de servicio: " + fechaServicio);
        System.out.println("Hembra: " + hembra);
        System.out.println("Macho: " + macho);
        System.out.println("Estado: " + estado);
        System.out.println("Fecha probable de parto: " + fechaProbableParto);
    }
}

//RF26 – Registrar nacimientos

public class Nacimiento {
    String fecha;
    String madre;
    int cantidadCrías;
    String sexo;
    double pesoAlNacer;
    String observaciones;

    public Nacimiento(String fecha, String madre, int cantidadCrías, String sexo, double pesoAlNacer, String observaciones) {
        
        this.fecha = fecha;
        this.madre = madre;
        this.cantidadCrías = cantidadCrías;
        this.sexo = sexo;
        this.pesoAlNacer = pesoAlNacer;
        this.observaciones = observaciones;
    }

    public void mostrarDatos() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Madre: " + madre);
        System.out.println("Cantidad de crías: " + cantidadCrías);
        System.out.println("Sexo: " + sexo);
        System.out.println("Peso al nacer: " + pesoAlNacer + " kg");
        System.out.println("Observaciones: " + observaciones);
    }
}


//RF27 – Registrar producción de animales 

public class Produccion {
    String fecha;
    String tipoProduccion;
    double cantidad;
    String unidad;
    String animalOGrupo;

    public Produccion(String fecha, String tipoProduccion, double cantidad, String unidad, String animalOGrupo) {
        
        this.fecha = fecha;
        this.tipoProduccion = tipoProduccion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.animalOGrupo = animalOGrupo;
    }

    public void mostrarDatos() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Producción: " + tipoProduccion);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Unidad: " + unidad);
        System.out.println("Animal o grupo: " + animalOGrupo);
    }
}


//RF28 – Gestionar lotes

import java.util.ArrayList;

public class Lote {
    String nombre;
    String descripcion;
    ArrayList<String> animales;

    public Lote(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(String animal) {
        animales.add(animal);
    }

    public void mostrarDatos() {
        System.out.println("Lote: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Animales del lote:");

        for (String animal : animales) {
            System.out.println(animal);
        }
    }
}


//RF29 – Consultar evolución de peso

import java.util.ArrayList;
import java.util.Collections;

public class EvolucionPeso {
    ArrayList<String> fechas;
    ArrayList<Double> pesos;

    public EvolucionPeso() {
        fechas = new ArrayList<>();
        pesos = new ArrayList<>();
    }

    public void registrarPeso(String fecha, double peso) {
        fechas.add(fecha);
        pesos.add(peso);
    }

    public void mostrarEvolucion() {
        for (int i = 0; i < pesos.size(); i++) {
            System.out.println("Fecha: " + fechas.get(i));
            System.out.println("Peso: " + pesos.get(i) + " kg");

            if (i > 0) {
                double diferencia = pesos.get(i) - pesos.get(i - 1);
                System.out.println("Diferencia: " + diferencia + " kg");
            }
        }
    }
}


//RF30 – Alertar controles sanitarios próximos o vencidos

import java.time.LocalDate;

public class ControlSanitario {
    String animal;
    LocalDate proximoControl;

    public ControlSanitario(String animal, LocalDate proximoControl) {
        this.animal = animal;
        this.proximoControl = proximoControl;
    }

    public void verificarControl() {
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(7);

        if (proximoControl.isBefore(hoy)) {
            System.out.println(animal + ": control vencido");
        } else if (!proximoControl.isAfter(limite)) {
            System.out.println(animal + ": control próximo");
        } else {
            System.out.println(animal + ": control al día");
        }
    }
}

