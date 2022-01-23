package test;
import paradigmaDocs.*;
import usuario.*;
import documento.*;

/**
 *
 * @author Grillitoxc
 */
public class test {
    public static void main(String[] args) {
        ParadigmaDocs p2 = new ParadigmaDocs("Paradigma pruebas");
        Usuario user1 = new Usuario("Sol", "123");
        Usuario user2 = new Usuario("Sol", "123");
        Usuario user3 = new Usuario("Sol", "123");
        p2.register("sol","123");
        p2.register("damina", "12324");
        Documento doc1 = new Documento("Doc", "autor");
        p2.getListaDocumentos().add(doc1);
        //Documento a = p2.getDocById(1);
        
        
        //Version ver1 = new Version( "123");
        //Version ver2 = new Version("123");
        //Version ver3 = new Version("123");
        //System.out.println(a);
    }
}
