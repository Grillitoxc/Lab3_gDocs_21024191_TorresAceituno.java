package paradigmaDocs;
// IMPORTS
import documento.Documento;
import java.util.ArrayList;
import java.time.*;
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
    public void register(String nombre, String contrasena){
        if (listaUsuarios.isEmpty()){
            Usuario user = new Usuario(nombre, contrasena);
            System.out.println("Usuario registrado");
            listaUsuarios.add(user);
        }else{
            boolean existe = false;
            for (int i = 0; i < listaUsuarios.size(); i++){
                if(listaUsuarios.get(i).getNombre().equals(nombre)){
                    existe = true;
                    System.out.println("Usuario ya existe");
                    break;
                }
            }
            if(!existe){
                Usuario userTemp = new Usuario(nombre, contrasena);
                listaUsuarios.add(userTemp);
                System.out.println("Usuario registrado");
            }
        }
    }   
    public void login(String nombre, String contrasena){
        if(!usuarioActivo.isBlank()){
            System.out.println("Ya hay un usuario logeado");
        }else if(listaUsuarios.isEmpty()){
            System.out.println("No existen usuarios");
        }else{
            boolean existe = false;
            for(int i = 0; i < listaUsuarios.size(); i++){
                if(listaUsuarios.get(i).getNombre().equals(nombre) && listaUsuarios.get(i).getContrasena().equals(contrasena)){
                    existe = true;
                    usuarioActivo = nombre;
                    System.out.println("Usuario logeado");
                    break;
                }
            }
            if(!existe){
                System.out.println("Usuario no encontrado");
            }
        }
    }
}
