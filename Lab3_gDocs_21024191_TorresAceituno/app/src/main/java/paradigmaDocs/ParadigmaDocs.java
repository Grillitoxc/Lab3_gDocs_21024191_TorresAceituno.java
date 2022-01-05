package paradigmaDocs;
// IMPORTS
import java.util.ArrayList;
import java.time.*;
import documentoInfo.*;
import usuario.*;

/**
 *
 * @author Grillitoxc
 */
public class ParadigmaDocs {
    String nombre;
    LocalDate fecha = LocalDate.now();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    String usuarioActivo = "";
    ArrayList<Documento> listaDocumentos = new ArrayList<>();
    
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

    public String getUsuarioActivo() {
        return usuarioActivo;
    }

    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
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

    public void setUsuarioActivo(String usuarioActivo) {
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
    
    // METHODS
    public void register(Usuario user){
        if (listaUsuarios.isEmpty()){
            listaUsuarios.add(user);
        }else{
            for (int i = 0; i < listaUsuarios.size(); i++){
                //
            }
        }
    }   
}
