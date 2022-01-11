package Lab3_gDocs_21024191_TorresAceituno;
// IMPORTS
import java.util.InputMismatchException;
import java.util.Scanner;
import paradigmaDocs.*;
import documento.*;
import usuario.*;

public class App {
    public static void main(String[] args) {
        ParadigmaDocs p1 = new ParadigmaDocs("PARADIGMADOCS");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String username = "";
        String password = "";
        String nameDoc = "";
        String contentDoc = "";
        Usuario user;
        while(!salir){
            if(!p1.isUsuarioActivo()){
                System.out.println("### EDITOR COLABORATIVO ###");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesion");
                System.out.println("3. Visualizar plataforma");
                System.out.println("4. Salir del programa");
                try{
                    System.out.println("Introduzca la operacion que desee: ");
                    opcion = sn.nextInt(); 
                    switch (opcion) {
                        case 1:
                            System.out.println("***REGISTER***");
                            System.out.println("Ingrese el nombre de usuario:");
                            sn.nextLine();
                            username = sn.nextLine();
                            System.out.println("Ingrese una contrasena:");
                            password = sn.nextLine();
                            p1.register(username, password);
                            break;
                        case 2:
                            System.out.println("***LOGIN***");
                            System.out.println("Ingrese el nombre de usuario:");
                            sn.nextLine();
                            username = sn.nextLine();
                            System.out.println("Ingrese una contrasena:");
                            password = sn.nextLine();
                            p1.login(username, password);
                            break;
                        case 3:
                            System.out.println("Has seleccionado la opcion 3");
                            break;
                        case 4:
                            salir = true;
                            System.out.println("Gracias por usar nuestra plataforma.");
                            break; 
                        default:
                            System.out.println("Las opciones son entre 1 a 4, por favor vuelva a intentarlo.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("El menu solo admite como entrada numeros.");
                    sn.next();
                }
            }else{
                System.out.println("***SESION ACTIVA***");
                System.out.println("Sesion actual: " + username);
                System.out.println("1. Crear nuevo documento");
                System.out.println("2. Compartir documento");
                System.out.println("3. Agregar contenido a un documento");
                System.out.println("12. Cerrar sesion");
                System.out.println("13. Salir del programa");
                System.out.println("Introduzca la operacion que desee: ");
                try{
                    opcion = sn.nextInt(); 
                    switch (opcion) {
                        case 1:
                            System.out.println("***CREAR***");
                            System.out.println("Ingrese el nombre del documento:");
                            sn.nextLine();
                            nameDoc = sn.nextLine();
                            System.out.println("Ingrese el contenido del documento:");
                            sn.nextLine();
                            contentDoc = sn.nextLine();
                            Documento doc = new Documento(nameDoc, username);
                            Version ver = new Version(contentDoc);
                            doc.getListaVersiones().add(ver);
                            p1.getListaDocumentos().add(doc);
                            user = p1.getUserByName(username);
                            user.getAutorDeDocumentos().add(doc);
                            System.out.println("Se ha creado el documento");
                            break;
                        case 2:
                            System.out.println("***COMPARTIR***");
                            break;
                        case 11:
                            System.out.println("***VISUALIZAR PLATAFORMA***");
                            System.out.println(p1.toString());
                            break;
                        case 12:
                            p1.logout();
                            break;
                        case 13:
                            salir = true;
                            System.out.println("Gracias por usar nuestra plataforma.");
                            break; 
                        default:
                            System.out.println("Las opciones son entre 1 a 4, por favor vuelva a intentarlo.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("El menu solo admite como entrada numeros.");
                    sn.next();
                }
            }
        }
    }
}
