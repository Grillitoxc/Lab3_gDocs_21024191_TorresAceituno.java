package documento;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Acceso{" + "nombre=" + nombre + ", permiso=" + permiso + '}';
    }
    
    // METHODS
    public static ArrayList<Acceso> crearPermisos(ArrayList<String> nombres, char permiso){
        Acceso accesoTemp;
        ArrayList<Acceso> listaAccesos = new ArrayList<>();
        String userAccesoTemp;
        for(int i = 0; i < nombres.size(); i++){
            userAccesoTemp = nombres.get(i);
            accesoTemp = new Acceso(userAccesoTemp, permiso);
            listaAccesos.add(accesoTemp);
        }
        return listaAccesos;
    }
    
    
}
