/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.coti.tools.Rutas;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Filmoteca;
import modelo.Actor;
import modelo.DevolverPelicula;
import modelo.Director;
import modelo.Pelicula;
/**
 *
 * @author manuel
 */
public class Controlador {

    Filmoteca m = new Filmoteca(); 
    
    public void leerTxtPeliculas() throws Exception  {
       
            m.leerPeliculasTxt();
        
    }
    

    public void leerTxtActores() throws Exception {
        
            m.leerActoresTxt();
        
    }

    public void leerTxtDirectores()  throws Exception  {

            m.leerDirectoresTxt();
        
    }
    
    public void leerBinarioPeliculas() throws IOException, FileNotFoundException, ClassNotFoundException {
        try{
        String archivo = "peliculas";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileInputStream fis = new FileInputStream(t);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        setPeliculas((ArrayList<Pelicula>) ois.readObject());
         ois.close();
        }
        catch (FileNotFoundException ex) {
            err.printf("Error no se ha encontrado peliculas.bin en la lectura%%n");
            
        } catch (IOException ex) {
            err.printf("Error leerBinario(): En el fichero I/O%n");
        } catch (ClassNotFoundException ex) {
            err.printf("Error: No se ha encontrado la clase%n");
    }
    }

    public void leerBinarioActores() throws IOException, FileNotFoundException, ClassNotFoundException {
        try{
        String archivo = "actores";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileInputStream fis = new FileInputStream(t);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        setActores((ArrayList<Actor>) ois.readObject());
                ois.close();
        }
        catch (FileNotFoundException ex) {
            err.printf("Error no se ha encontrado actores.bin en la lectura%%n");
            
        } catch (IOException ex) {
            err.printf("Error leerBinario(): En el fichero I/O%n");
        } catch (ClassNotFoundException ex) {
            err.printf("Error: No se ha encontrado la clase%n");
    }
    }
    public void leerBinarioDirectores() throws IOException, FileNotFoundException, ClassNotFoundException {
        try{
        String archivo = "directores";
        File t = Rutas.pathToFileInFolderOnDesktop("IMDB21", archivo.concat(".bin")).toFile();
        FileInputStream fis = new FileInputStream(t);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        setDirectores((ArrayList<Director>) ois.readObject());                
        ois.close();
        }
        catch (FileNotFoundException ex) {
            err.printf("Error no se ha encontrado directores.bin en la lectura%%n");
            
        } catch (IOException ex) {
            err.printf("Error leerBinario(): En el fichero I/O%n");
        } catch (ClassNotFoundException ex) {
            err.printf("Error: No se ha encontrado la clase%n");
    }
    }
    

    public boolean existePelicula(String titulo) {
        
       return m.existePelicula(titulo);
        
    }
    
    public boolean existeDirector(String nombre) {
        
       return m.existeDirector(nombre);
        
    }
        
    public boolean existeActor(String nombre) {
        
       return m.existeActor(nombre);
        
    }    

    public void anadirPelicula(String titulo, String ano, String duracion, String pais, 
            ArrayList<String> direccion, String guionista, 
            String musica, ArrayList<String> reparto, 
            String productora, String genero, String sinopsis) {
        
        m.anadirPelicula(titulo, ano, duracion,pais, direccion, guionista, musica,
                reparto, productora, genero, sinopsis);
        
        
    }

    public void borrarPelicula(String titulo) {
        
        m.borrarPelicula(titulo);
        
    }

    public void modificarAno(String titulo, String ano) {
        
        m.modificarAno(titulo, ano);
    }

    public void modificarDuracion(String titulo, String duracion) {
        m.modificarDuracion(titulo, duracion);
    }
    
    public void modificarPais(String titulo, String pais){
        
        m.modificarPais(titulo, pais);
    }

    public void modificarGuionista(String titulo, String guionista) {
        m.modificarGuionista(titulo, guionista);
    }

    public void modificarMusica(String titulo, String musica) {
        m.modificarMusica(titulo, musica);
    }

    public void modificarProductora(String titulo, String productora) {
        m.modificarProductora(titulo, productora);
    }

    public void modificarGenero(String titulo, String genero) {
        m.modificarGenero(titulo, genero);
    }

    public void modificarSinopsis(String titulo, String sinopsis) {
        m.modificarSinopsis(titulo, sinopsis);
    }

    public void anadirDirector(String nombre, String fecha, String nacionalidad, String ocupacion, ArrayList<String> peliculas) {

        m.anadirDirector(nombre, fecha, nacionalidad, ocupacion, peliculas);
    }

    public void borrarDirector(String director) {
        
        m.borrarDirector(director);
    }

    public void modificarFecha(String director, String fecha) {
        
        m.modificarFecha(director, fecha);
        
    }

    public void modificarNacionalidad(String director, String nacionalidad) {
        
        m.modificarNacionalidad(director, nacionalidad);
    }

    public void modificarOcupacion(String director, String ocupacion) {

        m.modificarOcupacion(director, ocupacion);
    }

    public void anadirActor(String nombre, String fecha, String nacionalidad, String ano_debut, ArrayList<String> peliculas) {

        m.anadirActor(nombre, fecha, nacionalidad, ano_debut, peliculas);

    }

    public void borrarActor(String actor) {
        
        m.borrarActor(actor);
    }

    public void modificarFechaActor(String actor, String fecha) {
        
        m.modificarFechaActor(actor, fecha);
    }

    public void modificarNacionalidadActor(String actor, String nacionalidad) {
        
        m.modificarNacionalidadActor(actor, nacionalidad);
    }

    public void modificarAnoDebut(String actor, String ano_debut) {
        
        m.modificarAnoDebut(actor, ano_debut);
    }

    public void exportarDirectoresCol() throws FileNotFoundException, Exception {
        
        m.exportarDirectoresCol();
    }

    public void exportarPeliculasHtml() throws FileNotFoundException {
        
        m.exportarPeliculasHtml();
    }

    public void almacenarPeliculas() throws IOException {

        m.almacenarPeliculas();
    }

    public void almacernarActores() throws IOException {

        m.almacenarActores();
    }

    public void almacenarDirectores() throws IOException {

        m.almacenarDirectores();
    }

    private void setPeliculas(ArrayList<Pelicula> arrayList) {
        
        m.setPeliculas(arrayList);
        
    }

    private void setDirectores(ArrayList<Director> arrayList) {
        
        m.setDirectores(arrayList);
    }

    private void setActores(ArrayList<Actor> arrayList) {
        
        m.setActores(arrayList);
    }

    public Pelicula obtenerPelicula(String titulo) {
        
        return m.obtenerPelicula(titulo);

    }

    public ArrayList<DevolverPelicula> devolverPeliculas(String actor) {
        
        ArrayList<DevolverPelicula> aux =  m.listaPelis(actor);
        
        Collections.sort(aux, new CompararFechaPel());
        
        return aux;
    }
    
    public ArrayList<Pelicula> devolverPeliculasOrdenadas(){
        
        ArrayList<Pelicula> ax = m.getPeliculas();
        
        for (int i=0; i<ax.size(); i++){
            
            ax.get(i).mayusculaTitulo(toMayusculas(ax.get(i).getTitulo()));
        }
        
        Collections.sort(ax, new CompararNombres());
        
        return ax;
    }

    public ArrayList<Director> devolverDirectoresOrdenadas(){
        
        ArrayList<Director> asd = m.getDirector();
        
        for (int i=0; i<asd.size(); i++){
            
            asd.get(i).mayusculaNacionalidad(toMayusculas(asd.get(i).getNacionalidad()));
        }
        
        asd.sort(Comparator.comparing(Director:: getNacionalidad).thenComparing(Director::getFecha));
        
        return asd;
    }

    public ArrayList<Actor> devolverActoresOrdenadas(){
        
        ArrayList<Actor> asm = m.getActor();
        
        for (int i=0; i<asm.size(); i++){
            
            asm.get(i).mayusculaNonmbre(toMayusculas(asm.get(i).getNombre()));
        }
        
        asm.sort(Comparator.comparing(Actor:: getAnoDebut).thenComparing(Actor::getNombre));
        
        return asm;
    }
    
    
    public static String toMayusculas(String valor) {
    if (valor == null || valor.isEmpty()) {
        return valor;
    } else {       
        return  valor.toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase();
    }
    }

    
}
