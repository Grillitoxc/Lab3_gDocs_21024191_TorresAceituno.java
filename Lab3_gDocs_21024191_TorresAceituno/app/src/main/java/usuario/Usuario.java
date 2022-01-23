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
    private ArrayList<Integer> docsAccesibles = new ArrayList<>();
    
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

    public ArrayList<Integer> getDocsAccesibles() {
        return docsAccesibles;
    }
    
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
    
    @Override
    public String toString() {
        return "\nUsuario logeado: " + nombre
                + "\nId: "+ id
                + "\nFecha de creacion de la cuenta: " + fechaCreacionUser
                + "\nDocumentos donde es autor: " + recorrerDocs(autorDeDocumentos)
                + "\nDocumentos donde tiene accesos: " + recorrerDocs(docsAccesibles);
    }

    // METHODS
    public void agregarDocAutor(Usuario user, Documento doc){
        user.getAutorDeDocumentos().add(doc);
    }
}
