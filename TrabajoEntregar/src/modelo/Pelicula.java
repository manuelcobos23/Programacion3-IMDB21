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
public class Pelicula implements Serializable {
    
    private String titulo;
    private String ano;
    private String duracion;
    private String pais;
    private ArrayList<String> direccion;
    private String guionista;
    private String musica;
    private ArrayList<String> reparto;
    private String productora;
    private String genero;
    private String sinopsis;
    
    
    public Pelicula (String titulo, String ano, String duracion, String pais, ArrayList<String> direccion,
            String guionista, String musica, ArrayList<String> reparto, String productora,
            String genero, String sinopsis) {
        
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.guionista = guionista;
        this.musica = musica;
        this.reparto = reparto;
        this.productora = productora;
        this.genero = genero;
        this.sinopsis = sinopsis;
                
        
    }
    
    public String getTitulo(){
        
        return this.titulo;
    } 
    
    public String getAno(){
        
        return this.ano;
    }     
    public String getDuracion(){
        
        return this.duracion;
    } 
    
    public String getPais(){
        
        return this.pais;
    }

    public ArrayList<String> getDireccion(){
        
        return this.direccion;
    } 
    public String getGuionista(){
        
        return this.guionista;
    } 
    public String getMusica(){
        
        return this.musica;
    } 
    public ArrayList<String> getReparto(){
        
        return this.reparto;
    } 
    public String getProductora(){
        
        return this.productora;
    } 
            
    public String getGenero(){
        
        return this.genero;
    } 
    
    public String getSinopsis(){
        
        return this.sinopsis;
    }
            
    public void modAno (String ano){
      
      this.ano = ano;
     }
  
  
    public void modDuracion (String duracion){
      
      this.duracion = duracion;
     }
    
    public void modPais (String pais){
        
       this.pais = pais; 
    }
    
    public void modGuionista (String guionista){
        
        this.guionista = guionista;
    }
  
    
    public void modMusica (String musica){
        
        this.musica = musica;
    }
    
    public void modProductora (String productora){
        
        this.productora = productora;
    }
    
    public void modGenero (String genero){
        
        this.genero = genero;
    }
    
    
    public void modSinopsis (String sinopsis){
        
        this.sinopsis = sinopsis;
    }

    public void mayusculaTitulo(String toMayusculas) {
        
        this.titulo = toMayusculas;
    }
}
