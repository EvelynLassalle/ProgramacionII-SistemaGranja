package ar.edu.sistemagranja.modelo;
import ar.edu.sistemagranja.modelo.enums.Rol;
public class Usuario {
    
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido,
                   String usuario, String contraseña, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void registrar() {
        // La lógica de registro se implementará posteriormente.
    }

    public boolean validarCredenciales() {
        // La validación real se implementará posteriormente.
        return false;
    }
}



