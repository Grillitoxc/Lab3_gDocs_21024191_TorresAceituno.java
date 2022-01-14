package usuario;
// IMPORTS
import java.time.*;
import documento.*;
import java.util.ArrayList;

/**
 *
 * @author Grillitoxc
 */
public class Usuario {
    private int id;
    public static int usuariosCreados = -1;
    private String nombre;
    private String contrasena;
    private LocalDate fechaCreacionUser = LocalDate.now();
    private ArrayList<Documento> autorDeDocumentos = new ArrayList<>();
    
    // CONSTRUCTOR 
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        usuariosCreados++;
        id = Usuario.usuariosCreados;
    }
    
    // GETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDate getFechaCreacionUser() {
        return fechaCreacionUser;
    }

    public ArrayList<Documento> getAutorDeDocumentos() {
        return autorDeDocumentos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", fechaCreacionUser=" + fechaCreacionUser + ", autorDeDocumentos=" + autorDeDocumentos + '}';
    }

    
    // METHODS
    public void agregarDocAutor(Usuario user, Documento doc){
        user.getAutorDeDocumentos().add(doc);
    }
    
   
    
}
