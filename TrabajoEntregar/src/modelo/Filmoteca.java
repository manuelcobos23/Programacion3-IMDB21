   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import static com.coti.tools.OpMat.exportToDisk;
import static com.coti.tools.OpMat.importFromDisk;
import com.coti.tools.Rutas;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import static java.lang.System.err;
import java.nio.file.Path;
import java.util.ArrayList;
/**
 *
 * @author manuel
 */
public class Filmoteca implements Serializable {
    
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Director> directores;
    private ArrayList<Actor> actores;
    private ArrayList<DevolverPelicula> devolverPeliculas;
    
    
    public Filmoteca()
    {
        this.peliculas = new ArrayList<>();
        this.directores = new ArrayList<>();
        this.actores = new ArrayList<>();
        this.devolverPeliculas = new ArrayList<>();
    }
    
    public void leerDirectoresTxt() throws Exception {

        //this.directores.clear();
        try{
        Path ruta = Rutas.pathToFileInFolderOnDesktop("IMDB21", "directores.txt");

        String[][] help = importFromDisk(ruta.toFile(), "#");

        for (int i = 0; i < help.length; i++) {

            ArrayList<String> ayuda = new ArrayList<String>();
            String aux = help[i][4];
            String[] parts = aux.split("\t");
            for (int j = 0; j < parts.length; j++) {
                ayuda.add(parts[j]);

            }

            Director aux2;
            aux2 = new Director(help[i][0], help[i][1], help[i][2], help[i][3], ayuda);

            directores.add(aux2);

        }
        }
        catch (Exception ex){
            err.printf("Error al leer el fichero directores.txt%n%n");
        }
    }

    public void leerActoresTxt() throws Exception {

        //this.actores.clear();
        try{
        Path ruta = Rutas.pathToFileInFolderOnDesktop("IMDB21", "actores.txt");

        String[][] help = importFromDisk(ruta.toFile(), "#");

        for (int i = 0; i < help.length; i++) {

            ArrayList<String> ayuda = new ArrayList<String>();
            String aux = help[i][4];
            String[] parts = aux.split("\t");
            for (int j = 0; j < parts.length; j++) {
                ayuda.add(parts[j]);

            }

            Actor aux2;
            aux2 = new Actor(help[i][0], help[i][1], help[i][2], help[i][3], ayuda);

            actores.add(aux2);

        }
        }
        catch (Exception er){
            err.print("Error al leer el fichero actores.txt");
        }
    }
    
    public void leerPeliculasTxt() throws Exception{
        
        //this.peliculas.clear();
        try{
        Path ruta = Rutas.pathToFileInFolderOnDesktop("IMDB21", "peliculas.txt");
    
        
        String[][] help = importFromDisk(ruta.toFile(), "#");
        

        for (int i=0; i< help.length; i++){
            
            ArrayList<String> ayuda = new ArrayList<String>();
            String aux = help[i][4];
            String[] parts = aux.split("\t");
            for (int j=0; j<parts.length; j++){
                ayuda.add(parts[j]);
                
            }
            
            ArrayList<String> ayuda1 = new ArrayList<String>();
            String aux1 = help[i][7];
            String[] parts1 = aux1.split("\t");
            for (int j=0; j<parts1.length; j++){
                ayuda1.add(parts1[j]);
                
            }            
            
        Pelicula aux2;
        aux2 = new Pelicula(help[i][0], help[i][1], help[i][2], help[i][3], ayuda, help[i][5], help[i][6], ayuda1, 
                help[i][8], help[i][9], help[i][10]);
        
        peliculas.add(aux2);
            
        }
        }
        catch (Exception er){
            err.print("Error al leer el fichero peliculas.txt");
        }
       
            
    }
    
        
    
 
   public void almacenarPeliculas() throws FileNotFoundException, IOException {
        
        try{
        String archivo = "peliculas";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileOutputStream fos = new FileOutputStream(t);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try(ObjectOutputStream oos = new ObjectOutputStream(bos)){ 
        oos.writeObject(this.peliculas);
         oos.close();
        }
        }catch (FileNotFoundException ex){
            err.print("Error no se ha encontrado el archivo %n");
        }
        catch (IOException ex){
            err.print("Error al guardar peliculas.bin");
        }
    }

    public void almacenarActores() throws FileNotFoundException, IOException {
        try{
        String archivo = "actores";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileOutputStream fos = new FileOutputStream(t);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
            
        
        oos.writeObject(this.actores);
         oos.close();
        }
        }catch (FileNotFoundException ex){
            err.print("Error no se ha encontrado el archivo %n");
        }
        catch (IOException ex){
            err.print("Error al guardar actores.bin");
        }
    }

    public void almacenarDirectores() throws FileNotFoundException, IOException {
        try{
        String archivo = "directores";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileOutputStream fos = new FileOutputStream(t);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
        oos.writeObject(this.directores);
         oos.close();
        }
        }catch (FileNotFoundException ex){
            err.print("Error no se ha encontrado el archivo %n");
        }
        catch (IOException ex){
            err.print("Error al guardar directores.bin");
        }
    }
    
    
    
    public ArrayList<Pelicula> getPeliculas(){
        
        return this.peliculas;
        
    }
    
    public ArrayList<Director> getDirector(){
        
        return this.directores;
        
    }
    
        public ArrayList<Actor> getActor(){
        
        return this.actores;
        
    }

 

    public boolean existePelicula(String titulo) {
        
       
        
        for (int i=0; i<this.peliculas.size(); i++){
            
            if (this.peliculas.get(i).getTitulo().toLowerCase().equals(titulo)){
                
                return true;
            }
            
        }
        
          
        return false;
        
        
    }


    public boolean existeDirector(String nombre) {
        
        for (int i=0; i<this.directores.size(); i++){
            
            if (this.directores.get(i).getNombre().toLowerCase().equals(nombre)){
                
                return true;
            }
            
        }
        
          
        return false;
        
    }


    public boolean existeActor(String nombre) {
        
        for (int i=0; i<this.actores.size(); i++){
            
            if (this.actores.get(i).getNombre().toLowerCase().equals(nombre)){
                
                return true;
            }
            
        }
        
          
        return false;
  
    }

    public void anadirPelicula(String titulo, String ano, String duracion, String pais, ArrayList<String> direccion, 
            String guionista, String musica, ArrayList<String> reparto, 
            String productora, String genero, String sinopsis) {

        Pelicula aux;
        aux = new Pelicula(titulo, ano, duracion,pais, direccion, guionista, musica,
                reparto, productora, genero, sinopsis);
        int bandera = 0;
        
        for (int i=0; i<direccion.size(); i++){
            for (int j=0; j<this.directores.size(); j++){
                if (direccion.get(i).toLowerCase().equals(this.directores.get(j).getNombre().toLowerCase())){
                    this.directores.get(j).getPeliculas().add(titulo);
                    //System.out.println("PASA POR DIRECTORES");
                    bandera = 1;
                }   
            }
            if (bandera == 0){
                ArrayList<String> aan =new ArrayList<>();
                aan.add(titulo);
                Director am = new Director(direccion.get(i),"","","", aan);        
                this.directores.add(am);
            }
            bandera = 0;
        }
        
        int banderin = 0;
        for (int i=0; i<reparto.size(); i++){
            for (int j=0; j<this.actores.size(); j++){
                if (reparto.get(i).toLowerCase().equals(this.actores.get(j).getNombre().toLowerCase())){
                    this.actores.get(j).getPeliculas().add(titulo);
                    //System.out.println("PASA POR Autores");
                    banderin = 1;
                }
            }
            if (banderin == 0){
                ArrayList<String> aan =new ArrayList<>();
                aan.add(titulo);
                Actor am = new Actor(reparto.get(i), "", "", "", aan);        
                this.actores.add(am);
            }
            banderin = 0;
        }
       
        
        this.peliculas.add(aux);

        }

    public void borrarPelicula(String titulo) {
        
        
        
        for (int i=0; i<this.directores.size(); i++){
            for (int j=0; j<this.directores.get(i).getPeliculas().size(); j++){
                
                if (titulo.toLowerCase().equals(this.directores.get(i).getPeliculas().get(j).toLowerCase())){
                    
                    this.directores.get(i).eliminarPelicula(j);
                }
                    
                
            }
        }
            
        for (int i=0; i<this.actores.size(); i++){
            for (int j=0; j<this.actores.get(i).getPeliculas().size(); j++){
                
                if (titulo.toLowerCase().equals(this.actores.get(i).getPeliculas().get(j).toLowerCase())){
                    
                    this.actores.get(i).eliminarPelicula(j);
                }
                    
                
            }
        }
        
       
        
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.toLowerCase().equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.remove(i);
            }
            
        }
        
        
        
    }

    public void modificarAno(String titulo, String ano) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modAno(ano);
            }
            
        }
    }
     
    public void modificarDuracion(String titulo, String duracion) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modDuracion(duracion);
            }
            
        }
    }
    
    public void modificarPais(String titulo, String pais){
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modPais(pais);
            }
            
        }         
        
    }
    
    public void modificarGuionista(String titulo, String guionista) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modGuionista(guionista);
            }
            
        }
    }
    public void modificarMusica(String titulo, String musica) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modMusica(musica);
            }
            
        }
    }
    public void modificarProductora(String titulo, String productora) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modProductora(productora);
            }
            
        }
    }
    public void modificarGenero(String titulo, String genero) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modGenero(genero);
            }
            
        }
    }
    public void modificarSinopsis(String titulo, String sinopsis) {
        
        for (int i=0; i< this.peliculas.size(); i++){
            
            if (titulo.equals(this.peliculas.get(i).getTitulo().toLowerCase())){
                
                this.peliculas.get(i).modSinopsis(sinopsis);
            }
            
        }
    }

    public void anadirDirector(String nombre, String fecha, String nacionalidad, String ocupacion, ArrayList<String> peliculas) {

        Director aux1;
        aux1 = new Director(nombre, fecha, nacionalidad, ocupacion, peliculas);
        
        this.directores.add(aux1);
        
         
        
    }

    public void borrarDirector(String director) {
        
        int posicion = 0;
        boolean bandera = true;
        
        for (int i=0; i<this.directores.size(); i++){
            
            if (director.equals(this.directores.get(i).getNombre().toLowerCase())){
                 posicion= i;
            }
        }
        
        
        
        for (int i=0; i<this.peliculas.size();i++){
            for (int j=0; j<this.directores.get(posicion).getPeliculas().size(); j++){
                if(this.peliculas.get(i).getTitulo().toLowerCase().equals(this.directores.get(posicion).getPeliculas().get(j).toLowerCase())){
                    System.out.println(this.directores.get(posicion).getPeliculas().get(j)+" exite en las peliculas del director, eliminala antes de borrar el director");
                    bandera = false;
                }
                
            }
        }
        
        
        if (bandera == true){
        

            for (int i=0; i< this.directores.size(); i++){

                if (director.equals(this.directores.get(i).getNombre().toLowerCase())){

                    this.directores.remove(i);
                }

            }
        }
    }

    public void modificarFecha(String director, String fecha) {
        
        for (int i=0; i< this.directores.size(); i++){
            
            if (director.equals(this.directores.get(i).getNombre().toLowerCase())){
                
                this.directores.get(i).modFecha(fecha);
            }
            
        }
        
        
    }

    public void modificarNacionalidad(String director, String nacionalidad) {
        
        for (int i=0; i< this.directores.size(); i++){
            
            if (director.equals(this.directores.get(i).getNombre().toLowerCase())){
                
                this.directores.get(i).modNacionalidad(nacionalidad);
            }
            
        }
        
    }

    public void modificarOcupacion(String director, String ocupacion) {
        
        for (int i=0; i< this.directores.size(); i++){
            
            if (director.equals(this.directores.get(i).getNombre().toLowerCase())){
                
                this.directores.get(i).modOcupacion(ocupacion);
            }
            
        }
        
        
        
    }

    public void anadirActor(String nombre, String fecha, String nacionalidad, String ano_debut, ArrayList<String> peliculas) {

        Actor aux2;
        aux2 = new Actor(nombre, fecha, nacionalidad, ano_debut, peliculas);
        
        this.actores.add(aux2);
        
    }

    public void borrarActor(String actor) {
        
        int posicion = 0;
        boolean bandera = true;
        
        for (int i=0; i<this.actores.size(); i++){
            
            if (actor.equals(this.actores.get(i).getNombre().toLowerCase())){
                 posicion= i;
            }
        }
        
        
        
        for (int i=0; i<this.peliculas.size();i++){
            for (int j=0; j<this.actores.get(posicion).getPeliculas().size(); j++){
                if(this.peliculas.get(i).getTitulo().toLowerCase().equals(this.actores.get(posicion).getPeliculas().get(j).toLowerCase())){
                    System.out.println(this.actores.get(posicion).getPeliculas().get(j)+" exite en las peliculas del actor, eliminala antes de borrar el actor");
                    bandera = false;
                }
                
            }
        }
        if (bandera == true){

            for (int i=0; i< this.actores.size(); i++){

                if (actor.equals(this.actores.get(i).getNombre().toLowerCase())){

                    this.actores.remove(i);
                }

            }
        }
    }

    public void modificarFechaActor(String actor, String fecha) {
        
        for (int i=0; i< this.actores.size(); i++){
            
            if (actor.equals(this.actores.get(i).getNombre().toLowerCase())){
                
                this.actores.get(i).modFecha(fecha);
            }
            
        }

    }

    public void modificarNacionalidadActor(String actor, String nacionalidad) {

        for (int i=0; i< this.actores.size(); i++){
            
            if (actor.equals(this.actores.get(i).getNombre().toLowerCase())){
                
                this.actores.get(i).modNacionalidad(nacionalidad);
            }
            
        }
        
        
    }

    public void modificarAnoDebut(String actor, String ano_debut) {

        for (int i=0; i< this.actores.size(); i++){
            
            if (actor.equals(this.actores.get(i).getNombre().toLowerCase())){
                
                this.actores.get(i).modAno_Debut(ano_debut);
            }
            
        }
    }

    public void exportarDirectoresCol() throws FileNotFoundException, Exception {
        
            try{
            PrintWriter pw = null;
            String archivo = "directores";
            File f = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".col")).toFile();
            pw = new PrintWriter(f);
            
                pw.printf("%-45s | %-22s | %-22s | %-70s | %-100s |%n","Nombre", "Fecha de nacimiento", "Nacionalidad", "Ocupacion", "Peliculas");
                //pw.printf("----------------------------------------------||--------------------|------------------------------|---------------------------------------------------------|%n");
                String direc;
            for (int i=0; i< this.directores.size(); i++){
                
                direc = String.format("%-45s | %-22s | %-22s | %-70s | %-100s |%n",this.directores.get(i).getNombre(), this.directores.get(i).getFecha(), 
                        this.directores.get(i).getNacionalidad(), this.directores.get(i).getOcupacion(), getStringPeliculasDirectores(i));
                pw.print(direc);
                
                
            }
            pw.close();}
            catch (FileNotFoundException ex){
                err.print("Error al guardar el fichero.col");
            }
            /*ArrayList<Director> pax = this.directores;
        
            String[][] matriz = new String[pax.size()+1][5];
        
            matriz[0][0] ="NOMBRE";
            matriz[0][1] ="FECHA DE NACIMIENTO";
            matriz[0][2] ="NACIONALIDAD";
            matriz[0][3] ="OCUPACION";
            matriz[0][4] ="PELICULAS";
        
            for (int i=1; i<pax.size()+1; i++){
                matriz[i][0] =pax.get(i-1).getNombre();
                matriz[i][1] =pax.get(i-1).getFecha();
                matriz[i][2] =pax.get(i-1).getNacionalidad();
                matriz[i][3] =pax.get(i-1).getOcupacion();
                matriz[i][4] =getStringPeliculasDirectores(i-1);
            }
        
            exportToDisk(matriz, f, "|");*/
            
    }
            
  
    public String getStringPeliculasDirectores(int i){
        
        ArrayList<String> lista = this.directores.get(i).getPeliculas();
            
        
        
        String[] vector = new String[lista.size()];
        
        for (int j=0; j<lista.size(); j++){
            
            vector[j] = lista.get(j);
            
        }
        
        StringBuffer cadena = new StringBuffer();

        for (int x=0;x<vector.length;x++){
            cadena =cadena.append(vector[x]);
            cadena = cadena.append("  ");
        }
        String cadena1 = cadena.toString();
        
        return cadena1;
        
    }

    public void exportarPeliculasHtml() throws FileNotFoundException {
        
       try{
        PrintWriter pt = null;
        String archivo = "peliculas";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".html")).toFile();
        pt = new PrintWriter(t);
        pt.printf("<!DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTF-8\">%n"
                    + "<H1>PELICULAS</H1>%n"
                    + "</HEAD>%n"
                    + "<BODY>");
        
        pt.printf("<TABLE BORDER=1>%n");
        String cabecera = String.format("<TR>"
                    + "<TD><strong>Titulo</strong></TD>"
                    + "<TD><strong>Ano</strong></TD>"
                    + "<TD><strong>Duracion</strong></TD>"
                    + "<TD><strong>Pais</strong></TD>"
                    + "<TD><strong>Direccion</strong></TD>"
                    + "<TD><strong>Guionista</strong></TD>"
                    + "<TD><strong>Musica</strong></TD>"
                    + "<TD><strong>Reparto</strong></TD>"
                    + "<TD><strong>Productora</strong></TD>"
                    + "<TD><strong>Genero</strong></TD>"
                    + "<TD><strong>Sinopsis</strong></TD>"
                    + "</TR>");
        pt.print(cabecera);
        
        for (int i=0; i<this.peliculas.size(); i++){
            
            String aux = obtenerStringPeliculas(i);
            pt.print(aux);
        }
        pt.printf("</TABLE>%n</BODY>%n</HTML>%n");
        pt.close();
       }
       catch (FileNotFoundException ex){
           err.print("Error al guardar el fichero html");
       }
    }

    public String obtenerStringPeliculas(int i) {
        
      String devolver;
      devolver = String.format("<TR>"
            +"<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "<TD>%s</TD>"
            + "</TR>",
              this.peliculas.get(i).getTitulo(),
              this.peliculas.get(i).getAno(),
              this.peliculas.get(i).getDuracion(),
              this.peliculas.get(i).getPais(),
              obtenerStringDireccionPeliculas(i),
              this.peliculas.get(i).getGuionista(),
              this.peliculas.get(i).getMusica(),
              obtenerStringRepartoPeliculas(i),
              this.peliculas.get(i).getProductora(),
              this.peliculas.get(i).getGenero(),
              this.peliculas.get(i).getSinopsis());
              
        return devolver;
    }
    
    public StringBuffer obtenerStringDireccionPeliculas(int i){
        
        ArrayList<String> lista = this.peliculas.get(i).getDireccion();
            

        String[] vector = new String[lista.size()];
        
        for (int j=0; j<lista.size(); j++){
            
            vector[j] = lista.get(j);
            
        }
        
        StringBuffer cadena = new StringBuffer();

        for (int x=0;x<vector.length;x++){
            cadena =cadena.append(vector[x]);
            cadena = cadena.append("-");
        }
        
        return cadena;
        
        
    }
    
    public StringBuffer obtenerStringRepartoPeliculas(int i){
        
                
        ArrayList<String> lista = this.peliculas.get(i).getReparto();
        String[] vector = new String[lista.size()];
        
        for (int j=0; j<lista.size(); j++){
            
            vector[j] = lista.get(j);
            
        }
        
        StringBuffer cadena = new StringBuffer();

        for (int x=0;x<vector.length;x++){
            cadena =cadena.append(vector[x]);
            cadena = cadena.append("  ");
        }
        
        return cadena;
        
        
    }    

    
    public void setPeliculas(ArrayList<Pelicula> arrayList) {
        
        this.peliculas = arrayList;
    }

    public void setActores(ArrayList<Actor> arrayList) {
        
        this.actores = arrayList;
    }

    public void setDirectores(ArrayList<Director> arrayList) {
        
        this.directores = arrayList;
    }

    public Pelicula obtenerPelicula(String titulo) {
        
        for (int i=0; i<this.peliculas.size(); i++){
            
            if (this.peliculas.get(i).getTitulo().toLowerCase().equals(titulo)){
                
                return this.peliculas.get(i);
            }
            
        }
        return this.peliculas.get(0);
    }

    
    public ArrayList<DevolverPelicula> listaPelis(String act){
        
        int posicion =0;
        
        ArrayList<DevolverPelicula> arrayDevolver = new ArrayList<>();
        
        for (int i=0; i<this.actores.size(); i++){
            
            if (act.equals(this.actores.get(i).getNombre().toLowerCase())){
                
                posicion = i;
                //System.out.println(this.actores.get(i).getNombre());
            }
            
        }
        //System.out.println(this.actores.get(0).getNombre());
        
        for (int i=0; i<this.peliculas.size(); i++){
            for (int j=0; j<this.actores.get(posicion).getPeliculas().size(); j++){
                if (this.peliculas.get(i).getTitulo().toLowerCase().equals(this.actores.get(posicion).getPeliculas().get(j).toLowerCase())){
                        
                    String tit  = this.peliculas.get(i).getTitulo();
                    int ann = Integer.parseInt(this.peliculas.get(i).getAno());
                    String dur = this.peliculas.get(i).getDuracion();
                    String pais = this.peliculas.get(i).getPais();
                    String genero = this.peliculas.get(i).getGenero();
                    
                    DevolverPelicula aux4; 
                    aux4= new DevolverPelicula(tit, ann, dur, pais, genero);
                    
                    arrayDevolver.add(aux4);

                }
            }
            
            
            
        }
        
        return arrayDevolver;
        
    }
    

   





    
    
}
    
    
   
