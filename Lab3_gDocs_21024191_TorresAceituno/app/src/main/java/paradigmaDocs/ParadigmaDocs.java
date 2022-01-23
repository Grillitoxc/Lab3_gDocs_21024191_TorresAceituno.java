package paradigmaDocs;
// IMPORTS
import java.util.ArrayList;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import usuario.*;
import documento.*;

/**
 *
 * @author Grillitoxc
 */
public class ParadigmaDocs {
    private String nombre;
    private LocalDate fecha = LocalDate.now();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private boolean usuarioActivo = false;
    private ArrayList<Documento> listaDocumentos = new ArrayList<>();
    
    // CONSTRUCTOR
    public ParadigmaDocs(String nombre) {
        this.nombre = nombre;
    }
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }
    
    public Usuario getUserByName(String user){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(user)){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }
    
    public Documento getDocById(int id){
        for(int i = 0; i < listaDocumentos.size(); i++){
            if(listaDocumentos.get(i).getId() == id){
                return listaDocumentos.get(i);
            }
        }
        return null;
    }
    
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
    
    // TO STRING
    @Override
    public String toString() {
        return "ParadigmaDocs{" + "nombre=" + nombre + ", fecha=" + fecha + ", listaUsuarios=" + listaUsuarios + ", usuarioActivo=" + usuarioActivo + ", listaDocumentos=" + listaDocumentos + '}';
    }
    
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
    
    // METHODS
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
    
    public boolean isRegistered(String name){
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(name)){
                    return true;
            }
        }
        return false;
    }
    
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
    
    public void agregarDocsAccesoUser(ArrayList<String> listaTempUsers, Documento docTemp){
        for(int i = 0; i < listaTempUsers.size(); i++){
            Usuario userTempAcceso;
            userTempAcceso = getUserByName(listaTempUsers.get(i));
            if(!userTempAcceso.getDocsAccesibles().contains(docTemp.getId())){
                userTempAcceso.getDocsAccesibles().add(docTemp.getId());
            }
        }
    }
    
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
    
}
