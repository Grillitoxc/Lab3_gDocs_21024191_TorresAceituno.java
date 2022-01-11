package documento;

/**
 *
 * @author Grillitoxc
 */
public class Version {
    private int id;
    public static int versionesCreadas = -1;
    private String contenido;
    
    // CONSTRUCTOR
    public Version(String contenido) {
        versionesCreadas++;
        id = Version.versionesCreadas; 
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public static int getVersionesCreadas() {
        return versionesCreadas;
    }

    public String getContenido() {
        return contenido;
    }
    
}
