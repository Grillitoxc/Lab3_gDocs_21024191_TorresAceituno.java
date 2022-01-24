package documento;

import java.util.ArrayList;

/**
 * Clase que sirve para crear los diversos tipos de acceso que se le dan a un
 * usuario en un documento específico
 * @author Christopher Torres
 */
public class Acceso {
    String nombre;
    char permiso;
    
    // CONSTRUCTOR
    /**
     * @param nombre -> Nombre usuario
     * @param permiso -> Tipo de permiso
     */
    public Acceso(String nombre, char permiso) {
        this.nombre = nombre;
        this.permiso = permiso;
    }
    
    // GETTERS
    /** 
     * @return String -> Nombre usuario
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @return char -> Tipo de permiso
     */
    public char getPermiso() {
        return permiso;
    }
    
    // SETTERS
    /** 
     * @param nombre -> Nombre usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @param permiso -> Tipo de permiso
     */
    public void setPermiso(char permiso) {
        this.permiso = permiso;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Acceso{" + "nombre=" + nombre + ", permiso=" + permiso + '}';
    }
    
    // METHODS
    /** 
     * Método que crea permisos desde un arreglo de nombres de usuario.
     * @param nombres
     * @param permiso
     * @return ArrayList<Acceso>
     */
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
