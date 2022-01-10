package usuario;
// IMPORTS
import java.time.*;

/**
 *
 * @author Grillitoxc
 */
public class Usuario {
    String nombre;
    String contrasena;
    LocalDate fechaCreacionUser = LocalDate.now();
    
    // CONSTRUCTOR 
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDate getFechaCreacionUser() {
        return fechaCreacionUser;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasena=" + contrasena + ", fechaCreacionUser=" + fechaCreacionUser + '}';
    }
    
}
