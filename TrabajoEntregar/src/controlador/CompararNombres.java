/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Comparator;
import modelo.Pelicula;

/**
 *
 * @author manuel
 */
public class CompararNombres implements Comparator<Pelicula> {
    
    
    @Override
    public int compare (Pelicula e1, Pelicula e2){
        
        return e1.getTitulo().compareTo(e2.getTitulo());
    }
    
}
