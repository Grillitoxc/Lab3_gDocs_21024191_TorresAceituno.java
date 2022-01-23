package documento;
// IMPORTS
import java.util.ArrayList;
import java.time.*;
import java.util.Collections;

/**
 *
 * @author Grillitoxc
 */
public class Documento {
    private int id;
    public static int documentosCreados = -1;
    private String nombre;
    private String autor;
    private LocalDate fechaCreacion = LocalDate.now();
    private LocalDate fechaActualizacion;
    private ArrayList<Version> listaVersiones = new ArrayList<>();
    private ArrayList<Acceso> listaAccesos = new ArrayList<>();

    // CONSTRUCTOR
    public Documento(String nombre, String autor) {
        documentosCreados++;
        id = Documento.documentosCreados; 
        this.nombre = nombre;
        this.autor = autor;
    }
    
    // GETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public ArrayList<Version> getListaVersiones() {
        return listaVersiones;
    }

    public ArrayList<Acceso> getListaAccesos() {
        return listaAccesos;
    }
    
    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setListaVersiones(ArrayList<Version> listaVersiones) {
        this.listaVersiones = listaVersiones;
    }

    public void setListaAccesos(ArrayList<Acceso> listaAccesos) {
        this.listaAccesos = listaAccesos;
    }

    @Override
    public String toString() {
        return "\n\n   Documento numero: " + id
                + "\n   Titulo: " + nombre
                + "\n   Autor: " + autor
                + "\n   Fecha de creacion: " + fechaCreacion
                + "\n   Fecha de ultima actualizacion: " + fechaActualizacion
                + "\n   Contenido actual: " + listaVersiones.get(listaVersiones.size() - 1).getContenido()
                + "\n   Numero de versiones creadas: " + listaVersiones.size();
    }

    
    
    // METHODS
    public ArrayList<Acceso> actualizarPermisos(ArrayList<Acceso> listaAccesosNuevos){
        boolean flag = false;
        for(int i = 0; i < listaAccesosNuevos.size(); i++){
            for(int j = 0; j < listaAccesos.size(); j++){
                if(listaAccesosNuevos.get(i).getNombre().equals(listaAccesos.get(j).getNombre())){
                    listaAccesos.get(j).setPermiso(listaAccesosNuevos.get(i).getPermiso());
                    flag = true;
                    break;
                }
            }
            if(!flag){
                listaAccesos.add(listaAccesosNuevos.get(i));
            }
        }
        return listaAccesos;
    }
    
    public String recorrerToString(){
        String string = "";
        for(int i = 0; i < listaAccesos.size(); i++){
            string = string + listaAccesos.get(i).toString();
        }
        return string;
    }
    
    public char getPermisoByName(String username){
        for(int i = 0; i < listaAccesos.size(); i++){
            if(listaAccesos.get(i).getNombre().equals(username)){
                return listaAccesos.get(i).getPermiso();
            }
        }
        return ' ';
    }

    public String getContenidoLastVer(){
        return listaVersiones.get(listaVersiones.size() - 1).getContenido();
    }

    public int getIndexOfVersionById(int id){
        for (int i = 0; i < listaVersiones.size(); i++) {
            if(listaVersiones.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void restaurarVersion(int id){
        int indexVersion = getIndexOfVersionById(id);
        if(indexVersion == -1){
            System.out.println("La version con el ID ingresado no existe.");
        }else{
            Collections.swap(listaVersiones, id, listaVersiones.size() - 1);
            System.out.println("Se ha restaurado la version con ID: " + listaVersiones.get(indexVersion).getId());
        }
    }

    public void revokeAccess(){
        listaAccesos.clear();
        System.out.println("Todos los permisos otorgados para el documento de ID: " + getId() + " han sido revocados.");
    }
}
