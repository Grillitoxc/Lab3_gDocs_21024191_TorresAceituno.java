package documento;

/**
 * Clase que sirve para generar versiones de un documento
 * @author Christopher Torres
 */
public class Version {
    private int id;
    public static int versionesCreadas = -1;
    private String contenido;
    
    // CONSTRUCTOR
    /**
     * @param contenido -> Contenido de la versión
     */
    public Version(String contenido) {
        versionesCreadas++;
        id = Version.versionesCreadas; 
        this.contenido = contenido;
    }
    
    // ETTERS
    /** 
     * @return int -> Id de la versión
     */
    public int getId() {
        return id;
    }

    /** 
     * @return int -> Cantidad de versiones creadas
     */
    public static int getVersionesCreadas() {
        return versionesCreadas;
    }
  
    /** 
     * @return String -> Contenido de la versión
     */
    public String getContenido() {
        return contenido;
    }
}
