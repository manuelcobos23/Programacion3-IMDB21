/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Actor implements Serializable  {
    
    private String nombre;
    private String fecha;
    private String nacionalidad;
    private String ano_debut;
    private ArrayList<String> peliculas;
   
    public Actor (String nombre, String fecha, String nacionalidad, String ano_debut, ArrayList<String> peliculas) {
        
        this.nombre = nombre;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.ano_debut = ano_debut;
        this.peliculas = peliculas;
        
    }
    
    
    public String getNombre(){
        
        return this.nombre;
    } 
    
    public String getFecha(){
        
        return this.fecha;
    }
    
    public String getNacionalidad(){
        
        return this.nacionalidad;
    }
    
    public String getAnoDebut(){
        
        return this.ano_debut;
    }
    
    
    public ArrayList<String> getPeliculas(){
    
        return this.peliculas;
    }

    void modFecha(String fecha) {
        
        this.fecha = fecha;
    }

    void modNacionalidad(String nacionalidad) {

        this.nacionalidad = nacionalidad;
    }

    void modAno_Debut(String ano_debut) {

        this.ano_debut = ano_debut;
    }


    String getTituloPelicula(int j) {
        
        return this.peliculas.get(j);
        
        
    }

    void eliminarPelicula(int j) {
        
        this.peliculas.remove(j);
    }

    public void mayusculaNonmbre(String toMayusculas) {
        
        this.nombre = toMayusculas;
    }
    
    
    
    
    
}



