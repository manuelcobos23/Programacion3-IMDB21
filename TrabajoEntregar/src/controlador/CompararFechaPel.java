/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import modelo.Actor;
import modelo.DevolverPelicula;
import modelo.Filmoteca;
import modelo.Pelicula;

/**
 *
 * @author manuel
 */
public class CompararFechaPel implements Comparator<DevolverPelicula> {
    
    
    @Override
    public int compare(DevolverPelicula e1, DevolverPelicula e2){
        
        return Integer.compare(e1.getAno(), e2.getAno());
        
        
    }
    
    
    
}
