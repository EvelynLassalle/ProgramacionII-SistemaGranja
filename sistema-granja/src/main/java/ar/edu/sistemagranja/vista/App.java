package ar.edu.sistemagranja.vista;

import ar.edu.sistemagranja.conexion.ConexionBD;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Iniciando Sistema Granja...");
        ConexionBD.obtenerConexion();
    }
}
