 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author manuel
 */
public class DevolverPelicula {
    
    private String titulo;
    private int ano;
    private String duracion;
    private String pais;
    private String genero;
    
    
    public DevolverPelicula (String titulo, int ano, String duracion, String pais, String genero ){
        
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.pais = pais;
        this.genero = genero;
        
        
        
    }
    
    public String getTitulo(){
        
        return this.titulo;
    } 
    
    public int getAno(){
        
        return this.ano;
    }     
    public String getDuracion(){
        
        return this.duracion;
    } 
    
    public String getPais(){
        
        return this.pais;
    }
    
    public String getGenero(){
        
        return this.genero;
    } 
    
    public void setTitulo(String titulo){
        
        this.titulo = titulo;
    } 
    
    public void setAno(int ano){
        
        this.ano = ano;
    }     
    public void setDuracion(String duracion){
        
        this.duracion = duracion;
    } 
    
    public void setPais(String pais){
        
        this.pais = pais;
    }
    
    public void setGenero(String genero){
        
        this.genero = genero;
    }
}
