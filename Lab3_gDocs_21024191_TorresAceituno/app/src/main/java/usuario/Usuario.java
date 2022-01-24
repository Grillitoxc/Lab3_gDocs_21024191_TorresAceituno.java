package usuario;
// IMPORTS
import java.time.*;
import documento.*;
import java.util.ArrayList;

/**
 * Clase que representa un usuario dentro de la plataforma paradigmadocs
 * @author Christoher Torres
 */
public class Usuario {
    private int id;
    public static int usuariosCreados = -1;
    private String nombre;
    private String contrasena;
    private LocalDate fechaCreacionUser = LocalDate.now();
    private ArrayList<Documento> autorDeDocumentos = new ArrayList<>();
    private ArrayList<Integer> docsAccesibles = new ArrayList<>();
    
    // CONSTRUCTOR 
    /**
     * @param nombre -> Nombre usuario
     * @param contrasena -> Contraseña usuario
     */
    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        usuariosCreados++;
        id = Usuario.usuariosCreados;
    }
  
    // GETTERS
    /** 
     * @return int -> Id numérico de un usuario
     */
    public int getId() {
        return id;
    }

    /** 
     * @return String -> Nombre usuario
     */
    public String getNombre() {
        return nombre;
    }
  
    /** 
     * @return String -> Contraseña usuario
     */
    public String getContrasena() {
        return contrasena;
    }
    
    /** 
     * @return LocalDate -> Fecha creación del usuario
     */
    public LocalDate getFechaCreacionUser() {
        return fechaCreacionUser;
    }
  
    /** 
     * @return ArrayList<Documento> -> Lista de documentos donde el usuario es
     * autor
     */
    public ArrayList<Documento> getAutorDeDocumentos() {
        return autorDeDocumentos;
    }
  
    /** 
     * @return ArrayList<Integer> -> Lista de documentos donde al usuario le han
     * dado permisos
     */
    public ArrayList<Integer> getDocsAccesibles() {
        return docsAccesibles;
    }
    
    /** 
     * @return String -> String de usuario
     */
    @Override
    public String toString() {
        return "\nUsuario logeado: " + nombre
                + "\nId: "+ id
                + "\nFecha de creacion de la cuenta: " + fechaCreacionUser
                + "\nDocumentos donde es autor: " + recorrerDocs(autorDeDocumentos)
                + "\nDocumentos donde tiene accesos: " + recorrerDocs(docsAccesibles);
    }
    
    // METHODS
    /** 
     * Método que agrega el documento donde el usuario es autor
     * @param user
     * @param doc
     */
    public void agregarDocAutor(Usuario user, Documento doc){
        user.getAutorDeDocumentos().add(doc);
    }
    
    /** 
     * Método para recorrer listas de documentos e imprimirlos por pantalla
     * @param listaDocs
     * @return String
     */
    public String recorrerDocs(ArrayList listaDocs){
        String string = "";
        if(listaDocs.isEmpty()){
            return "\n   No hay documentos aun.";
        }
        for(int i = 0; i < listaDocs.size(); i++){
            string = string + listaDocs.get(i).toString();
        }
        return string;
    }
}
