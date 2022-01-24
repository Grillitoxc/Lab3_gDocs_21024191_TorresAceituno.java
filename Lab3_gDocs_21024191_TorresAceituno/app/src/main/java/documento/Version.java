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
     * @param contenido -> Contenido de la versi�n
     */
    public Version(String contenido) {
        versionesCreadas++;
        id = Version.versionesCreadas; 
        this.contenido = contenido;
    }
    
    // ETTERS
    /** 
     * @return int -> Id de la versi�n
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
     * @return String -> Contenido de la versi�n
     */
    public String getContenido() {
        return contenido;
    }
}
