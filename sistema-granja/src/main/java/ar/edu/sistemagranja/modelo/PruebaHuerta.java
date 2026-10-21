
package ar.edu.sistemagranja.modelo;

import java.time.LocalDate;

public class PruebaHuerta {

    public static void main(String[] args) {

        SectorHuerta sector = new SectorHuerta(
            1,
            "S01",
            "Sector norte",
            "Fondo de la huerta",
            100
        );
        sector.registrar();

        Cultivo tomate = new Cultivo(
            1,
            "Tomate",
            "Cherry",
            LocalDate.of(2026, 9, 1),
            20,
            50,
            EstadoCultivo.SEMBRADO,
            LocalDate.of(2026, 12, 1),
            sector
        );

        // También lo incorpora a la lista del sector.
        tomate.registrar();

        Riego riego = new Riego(
            1,
            LocalDate.of(2026, 9, 2),
            15,
            "Riego por la mañana",
            tomate
        );

        Fertilizacion fertilizacion = new Fertilizacion(
            2,
            LocalDate.of(2026, 9, 10),
            "Compost",
            3,
            "Aplicado al suelo",
            tomate
        );

        PlagaEnfermedad plaga = new PlagaEnfermedad(
            3,
            LocalDate.of(2026, 10, 1),
            "Pulgones",
            "Presencia en las hojas",
            "Bajo",
            tomate
        );

        TratamientoCultivo tratamiento = new TratamientoCultivo(
            4,
            LocalDate.of(2026, 10, 2),
            "Retiro manual de hojas afectadas",
            "No aplica",
            "No aplica",
            "Revisar evolución",
            tomate
        );

        /*
         * Polimorfismo:
         * todos heredan de Cultivo, pero cada objeto ejecuta
         * su propia implementación de registrar().
         */
        Cultivo[] registros = {
            riego,
            fertilizacion,
            plaga,
            tratamiento
        };

        for (Cultivo registro : registros) {
            registro.registrar();
        }

        tomate.cambiarEstado(EstadoCultivo.CRECIMIENTO);
        tomate.cambiarEstado(EstadoCultivo.LISTO_PARA_COSECHAR);

        Cosecha cosecha = new Cosecha(
            1,
            LocalDate.of(2026, 12, 1),
            8.5,
            "kg",
            "Primera cosecha",
            tomate
        );
        cosecha.registrar();

        tomate.cambiarEstado(EstadoCultivo.COSECHADO);

        System.out.println("Sector: " + sector.getNombre());
        System.out.println("Cultivos: " + sector.listarCultivos().size());
        System.out.println("Cultivo: " + tomate.getNombre());
        System.out.println("Estado: " + tomate.getEstado());
        System.out.println(
            "Producción: " + tomate.consultarProduccion() + " kg"
        );

        System.out.println("Riegos: " + tomate.getRiegos().size());
        System.out.println(
            "Fertilizaciones: " + tomate.getFertilizaciones().size()
        );
        System.out.println(
            "Plagas/enfermedades: " + tomate.getPlagasEnfermedades().size()
        );
        System.out.println(
            "Tratamientos: " + tomate.getTratamientos().size()
        );

        System.out.println("\nHistorial:");

        for (String evento : tomate.consultarHistorial()) {
            System.out.println("- " + evento);
        }
    }
}