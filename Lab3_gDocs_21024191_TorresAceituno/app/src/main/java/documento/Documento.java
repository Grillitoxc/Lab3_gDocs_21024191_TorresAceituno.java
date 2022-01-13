package documento;
// IMPORTS
import java.util.ArrayList;
import java.time.*;


/**
 *
 * @author Grillitoxc
 */
public class Documento {
    private int id;
    public static int documentosCreados = -1;
    private String nombre;
    private String autor;
    private LocalDate fechaCreacion;
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
    
    
    
    
}
