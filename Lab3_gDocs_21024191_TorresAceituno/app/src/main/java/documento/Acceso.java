package documento;

/**
 *
 * @author Grillitoxc
 */
public class Acceso {
    String nombre;
    char permiso;
    
    // CONSTRUCTOR
    public Acceso(String nombre, char permiso) {
        this.nombre = nombre;
        this.permiso = permiso;
    }
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public char getPermiso() {
        return permiso;
    }
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPermiso(char permiso) {
        this.permiso = permiso;
    }
}
