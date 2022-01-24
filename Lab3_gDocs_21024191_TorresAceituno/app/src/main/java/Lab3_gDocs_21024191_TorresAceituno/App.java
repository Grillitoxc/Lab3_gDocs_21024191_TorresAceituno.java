package Lab3_gDocs_21024191_TorresAceituno;
// IMPORTS
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import paradigmaDocs.*;
import documento.*;
import java.time.LocalDate;
import usuario.*;

/**
 * Clasee main donde se incluye todo lo relacionado al menú interactivo por
 * consola.
 * @author Christopher Torres
 */
public class App { 
    /** 
     * @param args
     */
    public static void main(String[] args) {
        ///////////////////////// -> Inicialización de la plataforma.
        // SECCIÓN DE EJEMPLOS // -> Creación de usuarios base.
        ///////////////////////// -> Creación de documentos base.
        System.out.println("### SECCION EJEMPLOS USUARIOS Y DOCS PREVIOS ###");
        ParadigmaDocs p1 = new ParadigmaDocs("PARADIGMADOCS");
        p1.register("User1", "Contrasena1");
        p1.register("User2", "Contrasena2");
        p1.register("User3", "Contrasena3");
        p1.register("User4", "Contrasena4");
        p1.register("User5", "Contrasena5");
        // DOC 1
        Documento documento1 = new Documento("Titulo1", "User1");
        Version version1 = new Version("Contenido1");
        documento1.getListaVersiones().add(version1);
        p1.getUserByName("User1").getAutorDeDocumentos().add(documento1);
        p1.getListaDocumentos().add(documento1);
        // DOC 2
        Documento documento2 = new Documento("Titulo2", "User2");
        Version version2 = new Version("Contenido2");
        documento2.getListaVersiones().add(version2);
        p1.getUserByName("User2").getAutorDeDocumentos().add(documento2);
        p1.getListaDocumentos().add(documento2);
        // DOC 3
        Documento documento3 = new Documento("Titulo3", "User3");
        Version version3 = new Version("Contenido3");
        documento3.getListaVersiones().add(version3);
        p1.getUserByName("User3").getAutorDeDocumentos().add(documento3);
        p1.getListaDocumentos().add(documento3);
        // DOC 4
        Documento documento4 = new Documento("Titulo4", "User4");
        Version version4 = new Version("Contenido4");
        documento4.getListaVersiones().add(version4);
        p1.getUserByName("User4").getAutorDeDocumentos().add(documento4);
        p1.getListaDocumentos().add(documento4);
        // DOC 5
        Documento documento5 = new Documento("Titulo5", "User5");
        Version version5 = new Version("Contenido5");
        documento5.getListaVersiones().add(version5);
        p1.getUserByName("User5").getAutorDeDocumentos().add(documento5);
        p1.getListaDocumentos().add(documento5);
        // DOC 6
        Documento documento6 = new Documento("Titulo6", "User1");
        Version version6 = new Version("Contenido6");
        documento6.getListaVersiones().add(version6);
        p1.getUserByName("User1").getAutorDeDocumentos().add(documento6);
        p1.getListaDocumentos().add(documento6);
        // DOC 7
        Documento documento7 = new Documento("Titulo7", "User2");
        Version version7 = new Version("Contenido7");
        documento7.getListaVersiones().add(version7);
        p1.getUserByName("User2").getAutorDeDocumentos().add(documento7);
        p1.getListaDocumentos().add(documento7);
        // DOC 8
        Documento documento8 = new Documento("Titulo8", "User3");
        Version version8 = new Version("Contenido8");
        documento8.getListaVersiones().add(version8);
        p1.getUserByName("User3").getAutorDeDocumentos().add(documento8);
        p1.getListaDocumentos().add(documento8);
        // DOC 9
        Documento documento9 = new Documento("Titulo9", "User4");
        Version version9 = new Version("Contenido9");
        documento9.getListaVersiones().add(version9);
        p1.getUserByName("User4").getAutorDeDocumentos().add(documento9);
        p1.getListaDocumentos().add(documento9);
        // DOC 10
        Documento documento10 = new Documento("Titulo10", "User5");
        Version version10 = new Version("Contenido10");
        documento10.getListaVersiones().add(version10);
        p1.getUserByName("User5").getAutorDeDocumentos().add(documento10);
        p1.getListaDocumentos().add(documento10);
        
        //////////////////
        // SECCIÓN MENÚ //
        //////////////////
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        boolean salir2;
        boolean salir3;
        int opcion;
        int opcionTemp;
        int id;
        char permiso;
        Documento docTemp;
        ArrayList<String> listaTempUsers = new ArrayList<>();
        ArrayList<Acceso> listaTempAccesos = new ArrayList<>();
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
                System.out.println("3. Visualizar documentos de la plataforma");
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
                            System.out.println(p1.recorrerDocs());
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
                System.out.println("1.  Crear nuevo documento");
                System.out.println("2.  Compartir documento");
                System.out.println("3.  Agregar contenido a un documento");
                System.out.println("4.  Restaurar version anterior de un documento");
                System.out.println("5.  Revocar accesos otorgados a un documento");
                System.out.println("6.  Buscar texto en documentos accesibles");
                System.out.println("7.  Visualizar datos del usuario actual");
                System.out.println("8.  Cerrar sesion");
                System.out.println("9.  Salir del programa");
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
                            doc.setFechaActualizacion(LocalDate.now());
                            p1.getListaDocumentos().add(doc);
                            user = p1.getUserByName(username);
                            user.getAutorDeDocumentos().add(doc);
                            System.out.println("Se ha creado el documento con ID: " + doc.getId());
                            break;
                        case 2:
                            System.out.println("***COMPARTIR***");
                            if(p1.getListaDocumentos().isEmpty()){
                                System.out.println("No existen documentos creados en la plataforma aï¿½n.");
                                break;
                            }else{
                                System.out.println("Introduzca el id del documento deseado: ");
                                id = sn.nextInt();
                                docTemp = p1.getDocById(id);
                                if(docTemp == null){
                                    System.out.println("No existe el id ingresado, por favor vuelva a intentarlo.");
                                    break;
                                }else{
                                    if((p1.isAuthor(username, id)) || (docTemp.getPermisoByName(username) == 'w')){
                                        System.out.println("Permiso de lectura   =  r");
                                        System.out.println("Permiso de escritura =  w");
                                        System.out.println("Permiso de comentario =  c");
                                        System.out.println("Introduzca el permiso a compartir: ");
                                        permiso = sn.next().charAt(0);
                                        if((permiso == 'w')||(permiso == 'r')||(permiso == 'c')){
                                            System.out.println("Permiso ingresado correctamente.");
                                            System.out.println("Ingrese el primer usuario: ");
                                            sn.nextLine();
                                            usernameTemp = sn.nextLine();
                                            salir2 = false;
                                            listaTempUsers.clear();
                                            while(!salir2){
                                                if((p1.isRegistered(usernameTemp))&&(!p1.isAuthor(usernameTemp, id))){
                                                    if(!listaTempUsers.contains(usernameTemp)){
                                                        listaTempUsers.add(usernameTemp);
                                                        System.out.println("Usuario ingresado.");
                                                    }else{
                                                        System.out.println("Usuario ya ingresado, ingrese un usuario distinto.");
                                                    }
                                                    salir2 = true;
                                                    usernameTemp = "";
                                                }else{
                                                    System.out.println("El usuario es autor del documento o el usuario ingresado no esta registrado en la plataforma, vuelva a intentarlo.");
                                                break;
                                                }   
                                            }
                                            salir3 = false;
                                            while(!salir3){    
                                                try{
                                                    System.out.println("1. Ingresar otro usuario");
                                                    System.out.println("2. Finalizar Compartir");
                                                    System.out.println("Ingrese la opcion deseada: ");
                                                    opcionTemp = sn.nextInt();
                                                    switch(opcionTemp){
                                                        case 1:
                                                            System.out.println("Ingrese otro usuario: ");
                                                            sn.nextLine();
                                                            usernameTemp = sn.nextLine();
                                                            if((p1.isRegistered(usernameTemp))&&(!p1.isAuthor(usernameTemp, id))){    
                                                                if(!listaTempUsers.contains(usernameTemp)){
                                                                    listaTempUsers.add(usernameTemp);
                                                                    System.out.println("Usuario ingresado.");
                                                                }else{
                                                                    System.out.println("Usuario ya ingresado, ingrese un usuario distinto.");
                                                                }
                                                                usernameTemp = "";
                                                            }else{
                                                                System.out.println("El usuario es autor del documento o el usuario ingresado no esta registrado en la plataforma, vuelva a intentarlo.");
                                                            }
                                                            break;
                                                        case 2:
                                                            salir3 = true;
                                                            if(listaTempUsers.isEmpty()){
                                                                System.out.println("No se han ingresado permisos.");
                                                            }else{
                                                                listaTempAccesos = Acceso.crearPermisos(listaTempUsers, permiso);
                                                                docTemp.actualizarPermisos(listaTempAccesos);
                                                                p1.agregarDocsAccesoUser(listaTempUsers, docTemp);
                                                                System.out.println("Se ha ingresado el permiso a los usuarios ingresados.");
                                                            }
                                                            break;
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
                                    }else{
                                        System.out.println("El usuario activo no es dueï¿½o del documento, por lo que no puede compartir.");
                                        break;
                                    }
                                }
                            break;
                            }
                        case 3:
                            System.out.println("***AGREGAR CONTENIDO***");
                            if(p1.getListaDocumentos().isEmpty()){
                                System.out.println("No existen documentos creados en la plataforma aï¿½n.");
                                break;
                            } else {
                                System.out.println("Introduzca el id del documento deseado: ");
                                id = sn.nextInt();
                                docTemp = p1.getDocById(id);
                                if (docTemp == null) {
                                    System.out.println("No existe el id ingresado, por favor vuelva a intentarlo.");
                                    break;
                                } else {
                                    if (p1.isAuthor(username, id) || (docTemp.getPermisoByName(username) == 'w' || docTemp.getPermisoByName(username) == 'c')) {
                                        System.out.println("Ingrese el contenido que desea agregar del documento:");
                                        sn.nextLine();
                                        String newContentDoc = docTemp.getContenidoLastVer() + sn.nextLine();
                                        Version newVer = new Version(newContentDoc);
                                        docTemp.getListaVersiones().add(newVer);
                                        docTemp.setFechaActualizacion(LocalDate.now());
                                        System.out.println("Se ha agregado contenido al documento de ID: " + docTemp.getId() + " Version: " + newVer.getId());
                                    } else {
                                        System.out.println("El usuario activo no tiene los permisos suficientes para agregar contenido.");
                                    }
                                }
                            }
                            break;
                        case 4:
                            System.out.println("***RESTAURAR VERSION ANTERIOR***");
                            if(p1.getListaDocumentos().isEmpty()){
                                System.out.println("No existen documentos creados en la plataforma aun.");
                                break;
                            } else {
                                System.out.println("Introduzca el id del documento deseado: ");
                                id = sn.nextInt();
                                docTemp = p1.getDocById(id);
                                if (docTemp == null) {
                                    System.out.println("No existe el id ingresado, por favor vuelva a intentarlo.");
                                    break;
                                } else {
                                    if (p1.isAuthor(username, id)) {
                                        System.out.println("Ingrese el ID de la version que desea restaurar:");
                                        int idVer = sn.nextInt();
                                        docTemp.restaurarVersion(idVer);
                                        docTemp.setFechaActualizacion(LocalDate.now());
                                    } else {
                                        System.out.println("El usuario activo no es autor del documento.");
                                    }
                                }
                            }
                            break;
                        case 5:
                            System.out.println("***REVOCAR ACCESOS***");
                            if(p1.getListaDocumentos().isEmpty()){
                                System.out.println("No existen documentos creados en la plataforma aun.");
                                break;
                            } else {
                                System.out.println("Introduzca el id del documento deseado: ");
                                id = sn.nextInt();
                                docTemp = p1.getDocById(id);
                                if(docTemp == null){
                                    System.out.println("No existe el id ingresado, por favor vuelva a intentarlo.");
                                    break;
                                } else {
                                    if(p1.isAuthor(username, id)){
                                        docTemp.revokeAccess();
                                    } else {
                                        System.out.println("El usuario activo no es autor del documento.");
                                    }
                                }
                            }
                            break;
                        case 6:
                            System.out.println("***BUSCAR TEXTO***");
                            if(p1.getListaDocumentos().isEmpty()) {
                                System.out.println("No existen documentos creados en la plataforma aun.");
                            } else {
                                System.out.println("Introduzca el texto a buscar: ");
                                sn.nextLine();
                                String texto = sn.nextLine();
                                if(texto != null){
                                    ArrayList<Integer> results = p1.search(texto, username);
                                    p1.printSearch(results);
                                } else {
                                    System.out.println("Por favor ingrese texto valido.");
                                }
                            }
                            break;
                        case 7:
                            System.out.println("***VISUALIZAR USUARIOs***");
                            System.out.println(p1.getUserByName(username).toString());
                            break;
                        case 8:
                            p1.logout();
                            break;
                        case 9:
                            salir = true;
                            System.out.println("Gracias por usar nuestra plataforma.");
                            break; 
                        default:
                            System.out.println("Las opciones son entre 1 a 13, por favor vuelva a intentarlo.");
                    }
                }catch (InputMismatchException e){
                    System.out.println("El menu solo admite como entrada numeros.");
                    sn.next();
                }
            }
        }
    }
}
