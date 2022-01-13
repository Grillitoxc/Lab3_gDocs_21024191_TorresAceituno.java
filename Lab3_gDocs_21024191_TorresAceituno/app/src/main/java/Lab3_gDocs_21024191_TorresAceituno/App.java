package Lab3_gDocs_21024191_TorresAceituno;
// IMPORTS
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import paradigmaDocs.*;
import documento.*;
import usuario.*;

public class App {
    public static void main(String[] args) {
        ParadigmaDocs p1 = new ParadigmaDocs("PARADIGMADOCS");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        boolean salir2 = false;
        boolean salir3 = false;
        int opcion;
        int opcionTemp;
        int id;
        Documento docTemp;
        char permiso;
        ArrayList<String> listaTempUsers = new ArrayList<>();
        String username = "";
        String usernameTemp = "";
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
                            contentDoc = sn.nextLine();
                            Documento doc = new Documento(nameDoc, username);
                            Version ver = new Version(contentDoc);
                            doc.getListaVersiones().add(ver);
                            p1.getListaDocumentos().add(doc);
                            user = p1.getUserByName(username);
                            user.getAutorDeDocumentos().add(doc);
                            System.out.println("Se ha creado el documento con ID: " + doc.getId());
                            break;
                        case 2:
                            System.out.println("***COMPARTIR***");
                            if(p1.getListaDocumentos().isEmpty()){
                                System.out.println("No existen documentos creados en la plataforma a�n.");
                                break;
                            }else{
                                System.out.println("Introduzca el id del documento deseado: ");
                                id = sn.nextInt();
                                docTemp = p1.getDocById(id);
                                if(docTemp == null){
                                    System.out.println("No existe el id ingresado, por favor vuelva a intentarlo.");
                                    break;
                                }else{
                                    System.out.println("Permiso de lectura   =  r");
                                    System.out.println("Permiso de escritura =  w");
                                    System.out.println("Permiso de compartir =  s");
                                    System.out.println("Introduzca el permiso a compartir: ");
                                    permiso = sn.next().charAt(0);
                                    if((permiso == 'w')||(permiso == 'r')||(permiso == 's')){
                                        System.out.println("Permiso ingresado correctamente.");
                                        System.out.println("Ingrese el primer usuario: ");
                                        sn.nextLine();
                                        usernameTemp = sn.nextLine();
                                        while(!salir2){
                                            if(p1.isRegistered(usernameTemp)){
                                                listaTempUsers.add(usernameTemp);
                                                System.out.println("Usuario ingresado.");
                                                salir2 = true;
                                            }else{
                                            System.out.println("Usuario no registrado en la plataforma, vuelva a intentarlo.");
                                            break;
                                            }   
                                        }
                                        while(!salir3){    
                                            try{
                                                System.out.println("1. Ingresar otro usuario");
                                                System.out.println("2. Finalizar Compartir");
                                                System.out.println("Ingrese la opci�n deseada: ");
                                                opcionTemp = sn.nextInt();
                                                switch(opcionTemp){
                                                    case 1:
                                                        if(p1.isRegistered(usernameTemp)){
                                                            System.out.println("Ingrese otro usuario: ");
                                                            usernameTemp = sn.nextLine();
                                                            listaTempUsers.add(usernameTemp);
                                                            System.out.println("Usuario ingresado.");
                                                        }else{
                                                            System.out.println("Usuario no registrado en la plataforma, vuelva a intentarlo.");
                                                        }
                                                        break;
                                                    case 2:
                                                        salir3 = true;
                                                        if(listaTempUsers.isEmpty()){
                                                            System.out.println("No se han ingresado permisos.");
                                                        }else{
                                                            System.out.println("Se han ingresado el permiso a los usuarios.");
                                                            break;
                                                        }
                                                    default:
                                                        System.out.println("Las opciones son 1 o 2, por favor vuelva a intentarlo.");
                                                }
                                            }catch(InputMismatchException e){
                                                System.out.println("El menu solo admite como entrada numeros.");
                                                sn.next();
                                            }
                                        }
                                    }else{
                                        System.out.println("El permiso ingresado es incorrecto, por favor vuelva a intentarlo.");
                                        break;
                                    }
                                }
                            break;
                            }
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
