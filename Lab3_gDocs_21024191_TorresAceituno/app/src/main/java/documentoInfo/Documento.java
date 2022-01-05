package documentoInfo;
// IMPORTS
import java.util.ArrayList;
import java.time.*;


/**
 *
 * @author Grillitoxc
 */
public class Documento {
    int id;
    String nombre;
    String autor;
    LocalDate fechaCreacion;
    LocalDate fechaActualizacion;
    ArrayList<Version> listaVersiones = new ArrayList<>();
    ArrayList<Acceso> listaAccesos = new ArrayList<>();
    
    
}
