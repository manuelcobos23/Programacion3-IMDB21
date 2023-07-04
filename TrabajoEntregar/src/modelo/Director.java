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
public class Director implements Serializable  {
    
    private String nombre;
    private String fecha;
    private String nacionalidad;
    private String ocupacion;
    private ArrayList<String> peliculas;

    public Director (String nombre, String fecha, String nacionalidad, String ocupacion, ArrayList<String> peliculas) {
        
        this.nombre = nombre;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
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
    
    public String getOcupacion(){
        
        return this.ocupacion;
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

    void modOcupacion(String ocupacion) {
        
        this.ocupacion = ocupacion;
    }
    
    
            
    String getTituloPelicula (int j){
        
        return this.peliculas.get(j);
    }        

    void eliminarPelicula(int j) {
        
        this.peliculas.remove(j);

    }

    public void mayusculaNacionalidad(String toMayusculas) {
        
        this.nacionalidad = toMayusculas;
    }
            
    
}
