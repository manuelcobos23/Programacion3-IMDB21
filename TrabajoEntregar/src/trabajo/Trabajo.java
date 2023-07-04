/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajo;
import static com.coti.tools.DiaUtil.showFinalTime;
import static java.lang.System.out;
import vista.Vista;
import java.util.ArrayList;
/**
 *
 * @author manuel
 */
public class Trabajo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Vista v = new Vista();
        
        if (v.arrancar()){
            
        v.mostrarMenu("%n 1. Archivos"
                    + "%n 2. Peliculas"
                    + "%n 3. Directores"
                    + "%n 4. Actores"
                    + "%n 5. Listados"
                    + "%n q. Salir %n");            
            
        }
        
        showFinalTime();
        out.printf("Saliendo del programa...");
    }
    
}
