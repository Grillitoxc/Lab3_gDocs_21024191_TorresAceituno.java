package documento;
// IMPORTS
import java.util.ArrayList;
import java.time.*;
import java.util.Collections;

/**
 * Clase que representa un documento creado en la plataforma
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
    /**
     * @param nombre -> Nombree del documento
     * @param autor -> Nombre del autor
     */
    public Documento(String nombre, String autor) {
        documentosCreados++;
        id = Documento.documentosCreados; 
        this.nombre = nombre;
        this.autor = autor;
    }
    
    /** 
     * @return int -> Id del documento
     */
    // GETTERS
    public int getId() {
        return id;
    }
    
    /** 
     * @return String -> Nombre del documento
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @return String -> Autor del documento
     */
    public String getAutor() {
        return autor;
    }
    
    /** 
     * @return LocalDate -> Fecha de creación del documento
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    
    /** 
     * @return LocalDate -> Fecha de la última vez que se actualizó el documento
     */
    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    /** 
     * @return ArrayList<Version> -> Lista de versiones de un documento donde la
     * última posición equivale a la versión activa
     */
    public ArrayList<Version> getListaVersiones() {
        return listaVersiones;
    }
    
    /** 
     * @return ArrayList<Acceso> -> Lista de accesos donde diversos usuarios
     * pueden obtener permisos y realizar ciertas acciones
     */
    public ArrayList<Acceso> getListaAccesos() {
        return listaAccesos;
    }
    
    // SETTERS
    /** 
     * @param id -> Id del documento
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * @param nombre -> Nombre del documento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @param autor -> Autor del documento
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /** 
     * @param fechaCreacion -> Fecha de creación del documento
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    /** 
     * @param fechaActualizacion -> Fecha de la última vez que se actualizó el
     * documento
     */
    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    
    /** 
     * @param listaVersiones -> Lista de versiones de un documento donde la
     * última posición equivale a la versión activa
     */
    public void setListaVersiones(ArrayList<Version> listaVersiones) {
        this.listaVersiones = listaVersiones;
    }
    
    /** 
     * @param listaAccesos -> Lista de accesos donde diversos usuarios
     * pueden obtener permisos y realizar ciertas acciones
     */
    public void setListaAccesos(ArrayList<Acceso> listaAccesos) {
        this.listaAccesos = listaAccesos;
    }

    /** 
     * @return String -> String de documento
     */
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
    /** 
     * Método que revide una lista de accesos y actualiza los permisos nuevos
     * @param listaAccesosNuevos
     * @return ArrayList<Acceso>
     */
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
    
    /** 
     * Método que recorre la lista de accesos y las muestra en string
     * @return String
     */
    public String recorrerToString(){
        String string = "";
        for(int i = 0; i < listaAccesos.size(); i++){
            string = string + listaAccesos.get(i).toString();
        }
        return string;
    }
    
    /** 
     * Método que retorna el permiso que posee un usuario
     * @param username
     * @return char
     */
    public char getPermisoByName(String username){
        for(int i = 0; i < listaAccesos.size(); i++){
            if(listaAccesos.get(i).getNombre().equals(username)){
                return listaAccesos.get(i).getPermiso();
            }
        }
        return ' ';
    }
    
    /** 
     * Método que retorna la versión activa de un documento
     * @return String
     */
    public String getContenidoLastVer(){
        return listaVersiones.get(listaVersiones.size() - 1).getContenido();
    }
    
    /** 
     * Método que retorna el índice de una versión para saber si existe o no
     * @param id
     * @return int
     */
    public int getIndexOfVersionById(int id){
        for (int i = 0; i < listaVersiones.size(); i++) {
            if(listaVersiones.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    
    /** 
     * Método que restaura una versión haciendo que la versión indicada sea la
     * activa
     * @param id
     */
    public void restaurarVersion(int id){
        int indexVersion = getIndexOfVersionById(id);
        if(indexVersion == -1){
            System.out.println("La version con el ID ingresado no existe.");
        }else{
            Collections.swap(listaVersiones, id, listaVersiones.size() - 1);
            System.out.println("Se ha restaurado la version con ID: " + listaVersiones.get(indexVersion).getId());
        }
    }
    
    /**
     * Método que elimina los accesos de un documento
     */
    public void revokeAccess(){
        listaAccesos.clear();
        System.out.println("Todos los permisos otorgados para el documento de ID: " + getId() + " han sido revocados.");
    }
}
