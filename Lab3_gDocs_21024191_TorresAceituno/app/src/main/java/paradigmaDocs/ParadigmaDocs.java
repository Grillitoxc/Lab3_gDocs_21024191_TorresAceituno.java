package paradigmaDocs;
// IMPORTS
import java.util.ArrayList;
import java.time.*;
import usuario.*;
import documento.*;

/**
 * Clase que emula una plataforma de documentos que puede almacenar tanto
 * usuarios como documentos y sus interacciones.
 * Funciona como un editor colaborativo de documentos, por lo cual más de un
 * usuario a través de permisos puede ejercer cambios.
 * @author Christopher Torres
 */
public class ParadigmaDocs {
    private String nombre;
    private LocalDate fecha = LocalDate.now();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private boolean usuarioActivo = false;
    private ArrayList<Documento> listaDocumentos = new ArrayList<>();
    
    // CONSTRUCTOR
    /**
     * @param nombre -> Nombre de la plataforma
     */
    public ParadigmaDocs(String nombre) {
        this.nombre = nombre;
    }
    
    // GETTERS
    /** 
     * @return String -> Nombre de la plataforma
     */
    public String getNombre() {
        return nombre;
    }
    
    /** 
     * @return LocalDate -> Fecha de creación de la plataforma
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /** 
     * @return ArrayList<Usuario> -> Lista de usuarios registrados dentro
     * de la plataforma
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    /** 
     * @return boolean -> Estado del usuario activo
     */
    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }
    
    /** 
     * @return ArrayList<Documento> -> Lista de documentos de la plataforma
     */
    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }
    
    /** 
     * @param user -> Nombre de un usuario
     * @return Usuario -> Usuario
     */
    public Usuario getUserByName(String user){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(user)){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }
    
    /** 
     * @param id -> Id de un documento
     * @return Documento -> Documento
     */
    public Documento getDocById(int id){
        for(int i = 0; i < listaDocumentos.size(); i++){
            if(listaDocumentos.get(i).getId() == id){
                return listaDocumentos.get(i);
            }
        }
        return null;
    }   
    
    // SETTERS
    /** 
     * @param nombre -> Nombre de la plataforma
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @param fecha -> Fecha de creación de la plataforma
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /** 
     * @param listaUsuarios -> Lista de usuarios registrados en la plataforma
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    /** 
     * @param usuarioActivo -> Estado del usuario activo
     */
    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
    
    /** 
     * @param listaDocumentos -> Liata de documentos de la plataforma
     */
    public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
    
    /** 
     * @return String -> String de la plataforma
     */
    // TO STRING
    @Override
    public String toString() {
        return "ParadigmaDocs{" + "nombre=" + nombre + ", fecha=" + fecha + ", listaUsuarios=" + listaUsuarios + ", usuarioActivo=" + usuarioActivo + ", listaDocumentos=" + listaDocumentos + '}';
    }

    // METHODS
    /** 
     * Método que registra a un usuario dentro de la plataforma con su nombre y 
     * contraseña
     * @param nombre
     * @param contrasena
     */
    public void register(String nombre, String contrasena){
        if (listaUsuarios.isEmpty()){
            Usuario user = new Usuario(nombre, contrasena);
            System.out.println("Usuario ingresado exitosamente.");
            listaUsuarios.add(user);
        }else{
            boolean existe = false;
            for(int i = 0; i < listaUsuarios.size(); i++){
                if(listaUsuarios.get(i).getNombre().equals(nombre)){
                    existe = true;
                    System.out.println("El nombre de usuario ingresado ya existe, vuelva a intentarlo.");
                    break;
                }
            }
            if(!existe){
                Usuario userTemp = new Usuario(nombre, contrasena);
                listaUsuarios.add(userTemp);
                System.out.println("Usuario ingresado exitosamente.");
            }
        }
    }      
    
    /** 
     * Método que inicia sesión siempre y cuando los datos sean de un usuario
     * previamente ingresado a la plataforma
     * @param nombre
     * @param contrasena
     */
    public void login(String nombre, String contrasena){
        if(listaUsuarios.isEmpty()){
            System.out.println("No existen usuarios registrados, por favor, primero registra un usuario.");
        }else{
            boolean existe = false;
            for(int i = 0; i < listaUsuarios.size(); i++){
                if(listaUsuarios.get(i).getNombre().equals(nombre) && listaUsuarios.get(i).getContrasena().equals(contrasena)){
                    existe = true;
                    usuarioActivo = true;
                    System.out.println("Sesion iniciada exitosamente.");
                    break;
                }
            }
            if(!existe){
                System.out.println("Usuario no encontrado.");
            }
        }
    }
    
    public void logout(){
        if(usuarioActivo){
            setUsuarioActivo(false);
            System.out.println("Has salido de la sesion actual.");
        }
    } 
    
    /** 
     * Método que verifica si un usuario está registrado por nombre
     * @param name
     * @return boolean
     */
    public boolean isRegistered(String name){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(name)){
                    return true;
            }
        }
        return false;
    }
    
    /** 
     * Método que verifica que un usuario sea autor de un documento específico
     * @param name
     * @param id
     * @return boolean
     */
    public boolean isAuthor(String name, int id){
        Usuario userAuthor;
        userAuthor = getUserByName(name);
        for(int i = 0; i < userAuthor.getAutorDeDocumentos().size(); i++){
            if(userAuthor.getAutorDeDocumentos().get(i).getId() == id){
                return true;
            }
        }
        return false;
    }   
    
    /** 
     * Método que agrega documentos donde se le haya compartido permisos a un
     * usuario
     * @param listaTempUsers
     * @param docTemp
     */
    public void agregarDocsAccesoUser(ArrayList<String> listaTempUsers, Documento docTemp){
        for(int i = 0; i < listaTempUsers.size(); i++){
            Usuario userTempAcceso;
            userTempAcceso = getUserByName(listaTempUsers.get(i));
            if(!userTempAcceso.getDocsAccesibles().contains(docTemp.getId())){
                userTempAcceso.getDocsAccesibles().add(docTemp.getId());
            }
        }
    }
       
    /** 
     * Método que hace búsquedas de texto en los documentos donde un usuario
     * es autor y en los documentos donde se le haya sedido permisos
     * @param text
     * @param username
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> search(String text, String username){
        ArrayList<Integer> results = new ArrayList<>();
        Usuario user = getUserByName(username);
        Documento doc;
        char perm;
        for (int i = 0; i < user.getAutorDeDocumentos().size(); i++) {
            doc = user.getAutorDeDocumentos().get(i);
            for (int j = 0; j < doc.getListaVersiones().size(); j++) {
                if(doc.getListaVersiones().get(j).getContenido().contains(text)){
                    results.add(doc.getId());
                    break;
                }
            }
        }
        for (int i = 0; i < user.getDocsAccesibles().size(); i++) {
            doc = getDocById(user.getDocsAccesibles().get(i));
            perm = doc.getPermisoByName(username);
            if(!(perm == ' ')) {
                for (int j = 0; j < doc.getListaVersiones().size(); j++) {
                    if (doc.getListaVersiones().get(j).getContenido().contains(text)) {
                        results.add(doc.getId());
                        break;
                    }
                }
            } else {
                user.getDocsAccesibles().remove(i);
            }
        }
        return results;
    }
    
    /** 
     * Método auxiliar que aporta con la impresión de docuentos en search
     * @param listaIds
     */
    public void printSearch(ArrayList<Integer> listaIds){
        if(listaIds.isEmpty()){
            System.out.println("No se ha encontrado el texto.");
        }
        String message = "Se ha encontrado el texto en los documentos: ";
        for (int i = 0; i < listaIds.size(); i++) {
            message = message + "\nNombre: " + getDocById(listaIds.get(i)).getNombre() + " ID: " + getDocById(listaIds.get(i)).getId();
        }
        System.out.println(message);
    }
        
    /** 
     * Método que recorre los documentos para escribirlos por pantalla
     * @return String
     */
    public String recorrerDocs(){
        String string = "";
        if(listaDocumentos.isEmpty()){
            return "\n   No hay documentos dentro de la plataforma.";
        }else{
            string = "Los documentos de la plataforma " + nombre + " son:";
        }
        for(int i = 0; i < listaDocumentos.size(); i++){
            string = string + listaDocumentos.get(i).toString();
        }
        return string;
    }
}
