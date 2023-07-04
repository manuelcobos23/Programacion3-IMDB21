/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.Controlador;

import com.coti.tools.Esdia;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.printToScreen;
import static com.coti.tools.OpMat.printToScreen3;
import com.coti.tools.Rutas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Actor;
import modelo.DevolverPelicula;
import modelo.Pelicula;
import modelo.DevolverPelicula;
import modelo.Director;
/**
 *
 * @author manuel
 */
public class Vista {

    Controlador c = new Controlador();
    
    public boolean arrancar() throws Exception{
        String carpeta = "IMDB21";
        String [] nomArchivos = {"peliculas.bin", "actores.bin", "directores.bin"};
        String [] nomArchivosTxt ={"peliculas.txt", "actores.txt", "directores.txt"};
        File[] binarios = new File[3];
        File[] txt = new File[3];
        boolean salida =true;
        for (int i=0; i<nomArchivos.length; i++){
            
            binarios[i] = Rutas.fileToFileInFolderOnDesktop(carpeta, nomArchivos[i]);
            txt[i] = Rutas.fileToFileInFolderOnDesktop(carpeta, nomArchivosTxt[i]);
            if(binarios[i].exists()){
                
                leerBinarios(i);
                System.out.println("El registro "+binarios[i]+" ya existe,"
                                +" se cargaran los datos en el programa");
                
            }
            else if (txt[i].exists()) {
                leerTxt(i);
                System.out.println("El registro "+binarios[i]+" no existen,"
                                +" se importaran los datos de "+nomArchivosTxt[i]);
                
            }
            else {
                
                System.out.println("Los ficheros " +nomArchivos[i]+ " y " +nomArchivosTxt[i]+ " no existen,"
                                +" se procecede a cerrar el programa");
                salida = false;
                return salida;
            }
        }       
        
        return salida;
        
    }
    
    
    
    
    
    
    
    public void mostrarMenu(String menu) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        
        boolean bandera = false;
        String [] opciones = {"1","2","3","4","5","q"};
        System.out.println("Datos cargados correctamente");
        
        
        
        do{
            
            String opcion = readString(menu, opciones).toLowerCase();
            switch(opcion){
                
                case "1":
                    gestionArchivos();                    
                    break;
                case "2":
                    gestionPeliculas();
                    break;
                case "3":
                    gestionDirectores();
                    break;
                case "4":
                    gestionActores();
                    break;
                case "5":
                    gestionListados();
                    break;
                case "q":
                    bandera = yesOrNo("Estas seguro de salir");
                    almacenarDatos();
                    System.out.println("Datos almacenados en los fiheros .bin");
                    break;
                
            }
            
            
        }
        while(!bandera);
    }

    private void leerBinarios(int i) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        switch (i) {
            case 0:
                c.leerBinarioPeliculas();
                break;
            case 1:
                c.leerBinarioActores();
                break;
            case 2:
                c.leerBinarioDirectores();
                break;
            default:
                break;
        }
        
    }

    private void leerTxt(int i) throws Exception {
        
        switch (i) {
            case 0:
                c.leerTxtPeliculas();
                break;
            case 1:
                c.leerTxtActores();
                break;
            case 2:
                c.leerTxtDirectores();
                break;
            default:
                break;
        }
    
    }
    
    private void almacenarDatos() throws IOException {

        c.almacenarPeliculas();
        c.almacernarActores();
        c.almacenarDirectores();
    }

    private void gestionArchivos() throws FileNotFoundException, Exception {
        
       boolean salir = false;
       String[] opcionesArchivos ={"1", "2", "q"};
       String menuArchivos = ("%n 1.Exportar directores a directores.col"
                    +"%n 2.Exportar peliculas a peliculas.html"
                    +"%n q.Volver al menu principal");
       do{
           
           String opcionArchivo = readString(menuArchivos, opcionesArchivos).toLowerCase();
           
           switch(opcionArchivo){
             
                case "1":
                    exportarDirectoresCol();                    
                    break;
                case "2":
                    exportarPeliculasHtml();
                    break;
                case "q":
                    salir = Esdia.yesOrNo("Quieres salir al menu principal");
                    break;   
           }
           
       }
       while(!salir);
    }

    private void exportarDirectoresCol() throws FileNotFoundException, Exception {
        
        c.exportarDirectoresCol();
    }

    private void exportarPeliculasHtml() throws FileNotFoundException {

        c.exportarPeliculasHtml();
    }

    private void gestionPeliculas() {
        
       boolean salir = false;
       String[] opcionesPelicula ={"1", "2", "3", "4", "q"};
       String menuPelicula= ("%n 1.Añadir una pelicula"
                    +"%n 2.Borrar una pelicula"
                    +"%n 3.Hacer una modificacion de una pelicula"
                    +"%n 4.Consulta sobre una pelicula"
                    +"%n q.Volver al menu principal");
       do{
           
           String opcionPelicula = readString(menuPelicula, opcionesPelicula).toLowerCase();
           
           switch(opcionPelicula){
             
                case "1":
                    anadirPelicula();                    
                    break;
                case "2":
                    borrarPelicula();
                    break;
                case "3":
                    modificarPelicula();                    
                    break;
                case "4":
                    consultaPelicula();
                    break;
                case "q":
                    salir = Esdia.yesOrNo("Quieres salir al menu principal");
                    break;   
           }
           
       }
       while(!salir);
        
        
    }

    private void anadirPelicula() {
        
        
        boolean salir = true;
        System.out.println("AÑADIR PELICULA");
         
        do{
           
            
            String titulo = readString("Introduce el titulo de la pelicula: ").toLowerCase();
            
            if (c.existePelicula(titulo)){
                
                System.out.println("Esa pelicula ya existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }
            else{
                
                String ano = readString("Introduce el año: ");
                String duracion = readString("Introduce la duracion en minutos: ");
                String pais = readString("Introduce el pais: ");
                int numeroDireccion = readInt("Introduce el numero de personas que partican el la direccion: ");
                ArrayList<String> direccion;
                direccion = new ArrayList<>();
                String[] direccion1 = new String[numeroDireccion];
                for (int i=0; i< numeroDireccion; i++){
                    
                    direccion1[i] = readString("Introduce un director: ").toLowerCase();
                    direccion.add(direccion1[i]);
                }
                  
                String guionista = readString("Introduce el guionista: ");
                String musica = readString("Introduce el responsable de la musica: ");
                int numeroReparto = readInt("Introduce el numero de personas del reparto: ");
                ArrayList<String> reparto;
                reparto = new ArrayList<>();
                String[] reparto1 = new String[numeroReparto];
                for (int i=0; i< numeroReparto; i++){
                    
                    reparto1[i] = readString("Introduce un actor: ").toLowerCase();
                    reparto.add(reparto1[i]);
                }
                String productora = readString("Introduce a la productora: ");
                String genero = readString ("Introduce el genero: ");
                String sinopsis = readString ("Introduce sinopsis: ");
                
                c.anadirPelicula(titulo, ano, duracion, pais, direccion, guionista, musica, reparto, productora,
                        genero, sinopsis);
                salir = yesOrNo("Quieres introducir otra pelicula ");
            }   
        
        }while(salir);
    }

    private void borrarPelicula() {
        
        System.out.println("BORRAR PELICULA%n");
        boolean salir = true;
        do{
           
            
            String titulo = readString("Introduce el titulo de la pelicula: ").toLowerCase();
            
            if (c.existePelicula(titulo)){
                
                c.borrarPelicula(titulo);
                salir = yesOrNo("Quieres eliminar otra pelicula ");
            }
            else{
                               
                System.out.println("Esa pelicula no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
        
    }

    private void modificarPelicula() {

        System.out.println("Modificar pelicula ");
        boolean salir = true;
        do{
           
            
            String titulo = readString("Introduce el titulo de la pelicula: ").toLowerCase();
            
            if (c.existePelicula(titulo)){
                boolean exit = false;
                String menu = ("%n MODIFICACIONES"
                            + "%n 1.Ano"
                            + "%n 2.Duracion"
                            + "%n 3.Pais"
                            + "%n 4.Guionista"
                            + "%n 5.Musica"
                            + "%n 6.Productora"
                            + "%n 7.Genero"
                            + "%n 8.Sinopsis"
                            + "%n q.Dejar de modificar");
                String[] opciones = {"1", "2", "3", "4", "5", "6", "7", "8","q"};
                do{
                    
                    String opcion = readString(menu, opciones);
                    
                    switch (opcion){
                        
                        case "1":
                            String ano = readString("Introduce el ano: ");
                            c.modificarAno(titulo, ano);                    
                            break;
                        case "2":
                            String duracion = readString("Introduce la duracion: ");
                            c.modificarDuracion(titulo, duracion); 
                            break;
                        case "3":
                            String pais = readString("Introduce el pais: ");
                            c.modificarPais(titulo, pais);
                        case "4":
                            String guionista = readString("Introduce el guionista: ");
                            c.modificarGuionista(titulo, guionista);
                            break;
                        case "5":
                            String musica = readString("Introduce el responsable de musica: ");
                            c.modificarMusica(titulo, musica);
                            break;
                        case "6":
                            String productora = readString("Introduce la productora: ");
                            c.modificarProductora(titulo, productora);                   
                            break;
                        case "7":
                            String genero = readString("Introduce el genero: ");
                            c.modificarGenero(titulo, genero);
                            break;
                        case "8":
                            String sinopsis = readString("Introduce la sinopsis: ");
                            c.modificarSinopsis(titulo, sinopsis);                    
                            break;                           
                        case "q":
                            exit = Esdia.yesOrNo("Dejar de modificar");
                            break;      
                    }
                    
                    
                }while(!exit);
                
                salir = yesOrNo("Quieres modificar otra pelicula ");
            }
            else{
                               
                System.out.println("Esa pelicula no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
          
    }

    private void consultaPelicula() {

        System.out.println("CONSULTA PELICULA");
        boolean salir = true;
        do{
           
            
            String titulo = readString("Introduce el titulo de la pelicula: ").toLowerCase();
            
            if (c.existePelicula(titulo)){
                
                Pelicula auxiliar = c.obtenerPelicula(titulo);
                System.out.println("    Titulo: "+auxiliar.getTitulo());
                System.out.println("    Ano: "+auxiliar.getAno());
                System.out.println("    Duracion: "+auxiliar.getDuracion());
                System.out.println("    Pais: "+auxiliar.getPais());
                System.out.print("    Direccion: ");
                for (int i=0; i<auxiliar.getDireccion().size(); i++){
                    System.out.print(auxiliar.getDireccion().get(i)+ " ");
                }
                System.out.println("");
                System.out.println("    Guionista: "+auxiliar.getGuionista());
                System.out.println("    Musica: "+auxiliar.getMusica());
                System.out.print("    Reparto: ");
                for (int i=0; i<auxiliar.getReparto().size(); i++){
                    System.out.print(auxiliar.getReparto().get(i)+" ");
                }
                System.out.println("");
                System.out.println("    Productora: "+auxiliar.getProductora());
                System.out.println("    Genero: "+auxiliar.getGenero());
                System.out.println("    Sinopsis: "+auxiliar.getSinopsis());
                salir = yesOrNo("Quieres buscar otra pelicula");

            }
            else{
                               
                System.out.println("Esa pelicula no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }

    private void gestionDirectores() {
        
       boolean salir = false;
       String[] opcionesDirector ={"1", "2", "3","q"};
       String menuDirector= ("%n 1.Añadir un director"
                    +"%n 2.Borrar un director"
                    +"%n 3.Hacer una modificacion de un director "
                    +"%n q.Volver al menu principal");
       do{
           
           String opcionDirector = readString(menuDirector, opcionesDirector).toLowerCase();
           
           switch(opcionDirector){
             
                case "1":
                    anadirDirector();                    
                    break;
                case "2":
                    borrarDirector();
                    break;
                case "3":
                    modificarDirector();                    
                    break;
                case "q":
                    salir = Esdia.yesOrNo("Quieres salir al menu principal");
                    break;   
           }
           
       }
       while(!salir);       
        
        
        
    }
    
    private void anadirDirector() {

        
        boolean salir = true;
        System.out.println("ANADIR DIRECTOR%n");
         
        do{
           
            
            String nombre = readString("Introduce el nombre del director: ").toLowerCase();
            
            if (c.existeDirector(nombre)){
                
                System.out.println("Ese director ya existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }
            else{
                
                
                String fecha = readString("Introduce la fecha de nacimiento(formato yyyy-mm-dd): ");
                String nacionalidad = readString("Introduce la nacionalidad: ");
                String ocupacion = readString ("Introduce el ocupacion: ");
                int numeroPeliculas = readInt("Introduce el numero de peliculas: ");
                ArrayList<String> peliculas;
                peliculas = new ArrayList<>();
                String[] peliculas1 = new String[numeroPeliculas];
                for (int i=0; i< numeroPeliculas; i++){
                    
                    peliculas1[i] = readString("Introduce una pelicula: ");
                    peliculas.add(peliculas1[i]);
                }
                c.anadirDirector(nombre, fecha, nacionalidad, ocupacion, peliculas);
                salir = yesOrNo("Quieres introducir otro director ");
            }   
        
        }while(salir);
    }

    private void borrarDirector() {

        System.out.println("BORRAR DIRECTOR");
        boolean salir = true;
        do{
           
            
            String director = readString("Introduce el nombre del director: ").toLowerCase();
            
            if (c.existeDirector(director)){
                
                c.borrarDirector(director);
                salir = yesOrNo("Quieres eliminar otro director ");
            }
            else{
                               
                System.out.println("Ese director no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }

    private void modificarDirector() {

        System.out.println("Modificar director ");
        boolean salir = true;
        do{
           
            
            String director = readString("Introduce el nombre del director: ").toLowerCase();
            
            if (c.existeDirector(director)){
                boolean exit = false;
                String menu = ("%n MODIFICACIONES"
                            + "%n 1.Fecha"
                            + "%n 2.Nacionalidad"
                            + "%n 3.Ocupacion"
                            + "%n q.Dejar de modificar");
                String[] opciones = {"1", "2", "3","q"};
                do{
                    
                    String opcion = readString(menu, opciones);
                    
                    switch (opcion){
                        

                        case "1":
                            String fecha = readString("Introduce la fecha(formato yyyy-mm-dd): ");
                            c.modificarFecha(director, fecha);
                            break;
                        case "2":
                            String nacionalidad = readString("Introduce la nacionalidad: ");
                            c.modificarNacionalidad(director, nacionalidad);
                            break;    
                        case "3":
                            String ocupacion = readString("Introduce su ocupacion: ");
                            c.modificarOcupacion(director, ocupacion);                   
                            break;                       
                        case "q":
                            exit = Esdia.yesOrNo("Dejar de modificar");
                            break;      
                    }
                    
                    
                }while(!exit);
                
                salir = yesOrNo("Quieres modificar otro director ");
            }
            else{
                               
                System.out.println("Ese director no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }
    
        
    
    
    
    private void gestionActores() throws Exception {
        
       boolean salir = false;
       String[] opcionesActor ={"1", "2", "3", "4", "q"};
       String menuActor= ("%n 1.Añadir un actor"
                    +"%n 2.Borrar un actor"
                    +"%n 3.Hacer una modificacion de un actor "
                    +"%n 4.Listado por actor"
                    +"%n q.Volver al menu principal");
       do{
           
           String opcionActor = readString(menuActor, opcionesActor).toLowerCase();
           
           switch(opcionActor){
             
                case "1":
                    anadirActor();                    
                    break;
                case "2":
                    borrarActor();
                    break;
                case "3":
                    modificarActor();                    
                    break;
                case "4":
                    consultaActor();                    
                    break;
                case "q":
                    salir = Esdia.yesOrNo("Quieres salir al menu principal");
                    break;   
           }
           
       }
       while(!salir);       
        
        
        
    } 

    private void anadirActor() {

        boolean salir = true;
        System.out.println("AÑADIR ACTOR");
         
        do{
           
            
            String nombre = readString("Introduce el nombre del actor: ").toLowerCase();
            
            if (c.existeActor(nombre)){
                
                System.out.println("Ese actor ya existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }
            else{
                
                
                String fecha = readString("Introduce la fecha de nacimiento(formato yyyy-mm-dd): ");
                String nacionalidad = readString("Introduce la nacionalidad: ");
                String ano_debut = readString("Introduce el año de debut: ");
                int numeroPeliculas = readInt("Introduce el numero de peliculas: ");
                ArrayList<String> peliculas;
                peliculas = new ArrayList<>();
                String[] peliculas1 = new String[numeroPeliculas];
                for (int i=0; i< numeroPeliculas; i++){
                    
                    peliculas1[i] = readString("Introduce una pelicula: ");
                    peliculas.add(peliculas1[i]);
                }                
                c.anadirActor(nombre, fecha, nacionalidad, ano_debut, peliculas);
                salir = yesOrNo("Quieres introducir otro actor ");
            }   
        
        }while(salir);
    }

    private void borrarActor() {

        System.out.println("BORRAR ACTOR%n");
        boolean salir = true;
        do{
           
            
            String actor = readString("Introduce el nombre del actor: ").toLowerCase();
            
            if (c.existeActor(actor)){
                
                c.borrarActor(actor);
                salir = yesOrNo("Quieres eliminar otro actor ");
            }
            else{
                               
                System.out.println("Ese actor no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }

    private void modificarActor() {

        System.out.println("Modificar actor %n");
        boolean salir = true;
        do{
           
            
            String actor = readString("Introduce el nombre del actor: ").toLowerCase();
            
            if (c.existeActor(actor)){
                boolean exit = false;
                String menu = ("%n MODIFICACIONES"
                            + "%n 1.Fecha"
                            + "%n 2.Nacionalidad"
                            + "%n 3.Ano de debut"
                            + "%n q.Dejar de modificar");
                String[] opciones = {"1", "2", "3","q"};
                do{
                    
                    String opcion = readString(menu, opciones);
                    
                    switch (opcion){
                        
                        case "1":
                            String fecha = readString("Introduce la fecha: ");
                            c.modificarFechaActor(actor, fecha);
                            break;
                        case "2":
                            String nacionalidad = readString("Introduce la nacionalidad: ");
                            c.modificarNacionalidadActor(actor, nacionalidad);
                            break;
                        case "3":
                            String ano_debut = readString("Introduce su año de debut: ");
                            c.modificarAnoDebut(actor, ano_debut);                   
                            break;                       
                        case "q":
                            exit = Esdia.yesOrNo("Dejar de modificar?");
                            break;      
                    }
                    
                    
                }while(!exit);
                
                salir = yesOrNo("Quieres modificar otro actor ");
            }
            else{
                               
                System.out.println("Ese director no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }

    private void consultaActor() throws Exception {

        System.out.println("CONSULTA ACTOR%n");
        boolean salir = true;
        do{
           
            
            String actor = readString("Introduce el nombre del actor: ").toLowerCase();
            
            if (c.existeActor(actor)){
                
                ArrayList<DevolverPelicula> listaPeliculas = c.devolverPeliculas(actor);
                
                if (listaPeliculas.size() != 0){
                
                    String[][] mat = new String[listaPeliculas.size()+1][5];

                    mat[0][0] ="TITULO";
                    mat[0][1] ="AÑO";
                    mat[0][2] ="DURACION";
                    mat[0][3] ="PAIS";
                    mat[0][4] ="GENERO";

                    for(int i=1; i<listaPeliculas.size()+1; i++){

                        mat[i][0] =listaPeliculas.get(i-1).getTitulo();
                        mat[i][1] =String.valueOf(listaPeliculas.get(i-1).getAno());
                        mat[i][2] =listaPeliculas.get(i-1).getDuracion();
                        mat[i][3] =listaPeliculas.get(i-1).getPais();
                        mat[i][4] =listaPeliculas.get(i-1).getGenero();

                    }
                    printToScreen3(mat);
                    salir = yesOrNo("Quieres consultar otro actor");
                }
                else{
                    System.out.println("Ese actor no tiene peliculas");
                    salir = yesOrNo("Quieres consultar otro actor");
                    
                }
            }
          
            else{
                               
                System.out.println("Ese actor no existe");
                salir = yesOrNo("Quieres volver a intentarlo");
            }   
        
        }while(salir);
    }

    private void gestionListados() throws Exception {
       
        
        boolean salir = false;
        String[] opcionesListado ={"1", "2", "3","q"};
        String menuListado= ("%n 1.Imprime peliculas ordenadas alfabeticamente"
                    +"%n 2.Imprime directores ordenados por nacionalidad "
                    +"y año de nacimiento"
                    +"%n 3.Imprime actores ordenados por año de debut"
                    +" y nombre"
                    +"%n q.Volver al menu principal");
        do{
           
           String opcionListado = readString(menuListado, opcionesListado).toLowerCase();
           
           switch(opcionListado){
             
                case "1":
                    listadoPeliculas();                    
                    break;
                case "2":
                    listadoDirectores();
                    break;
                case "3":
                    listadoActores();                    
                    break;
                case "q":
                    salir = Esdia.yesOrNo("Quiere salir al menu principal");
                    break;   
           }
           
       }
       while(!salir);       
        
      

    }

    private void listadoPeliculas() throws Exception {
        
        ArrayList<Pelicula> pax = c.devolverPeliculasOrdenadas();
        System.out.println(pax.size()+1);
        String[][] matriz = new String[pax.size()+1][5];
        //System.out.printf("%-20s  %-20s  %-20s  %-20s  %-20s %n","TITULO", "AÑO", "DURACION", "PAIS", "GENERO");
            matriz[0][0] ="TITULO";
            matriz[0][1] ="AÑO";
            matriz[0][2] ="DURACION";
            matriz[0][3] ="PAIS";
            matriz[0][4] ="GENERO";
        
        for (int i=1; i<pax.size()+1; i++){
            matriz[i][0] =pax.get(i-1).getTitulo();
            matriz[i][1] =pax.get(i-1).getAno();
            matriz[i][2] =pax.get(i-1).getDuracion();
            matriz[i][3] =pax.get(i-1).getPais();
            matriz[i][4] =pax.get(i-1).getGenero();
        }
        
        printToScreen3(matriz);
        
    }

    private void listadoDirectores() throws Exception {

        ArrayList<Director> pax1 = c.devolverDirectoresOrdenadas();
        
       
       
        
        System.out.println(pax1.size()+1);
        String[][] matriz1 = new String[pax1.size()+1][4];
        //System.out.printf("%-20s  %-20s  %-20s  %-20s  %-20s %n","TITULO", "AÑO", "DURACION", "PAIS", "GENERO");
            matriz1[0][0] ="NOMBRE";
            matriz1[0][1] ="FECHA";
            matriz1[0][2] ="NACIONALIDAD";
            matriz1[0][3] ="OCUPACION";
            
        
        for (int i=1; i<pax1.size()+1; i++){
            matriz1[i][0] =pax1.get(i-1).getNombre();
            matriz1[i][1] =pax1.get(i-1).getFecha();
            matriz1[i][2] =pax1.get(i-1).getNacionalidad();
            matriz1[i][3] =pax1.get(i-1).getOcupacion();
            
        }
        
        printToScreen3(matriz1);
        
        
        
    }

    private void listadoActores() throws Exception {

        ArrayList<Actor> pax1 = c.devolverActoresOrdenadas();
        
       
       
        
        System.out.println(pax1.size()+1);
        String[][] matriz1 = new String[pax1.size()+1][4];
        //System.out.printf("%-20s  %-20s  %-20s  %-20s  %-20s %n","TITULO", "AÑO", "DURACION", "PAIS", "GENERO");
            matriz1[0][0] ="NOMBRE";
            matriz1[0][1] ="FECHA";
            matriz1[0][2] ="NACIONALIDAD";
            matriz1[0][3] ="AÑO DE DEBUT";
            
        
        for (int i=1; i<pax1.size()+1; i++){
            matriz1[i][0] =pax1.get(i-1).getNombre();
            matriz1[i][1] =pax1.get(i-1).getFecha();
            matriz1[i][2] =pax1.get(i-1).getNacionalidad();
            matriz1[i][3] =pax1.get(i-1).getAnoDebut();
            
        }
        
        printToScreen3(matriz1);
    }



}

