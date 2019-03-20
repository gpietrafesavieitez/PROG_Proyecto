package app;

import java.io.IOException;
import java.io.FileNotFoundException;
import core.Interfaz;

public class Juego{
    
    /* Todas las posibles excepciones se tratan aquí */
    public static void iniciar(){
        System.out.println("Debug console:");
        try{
            Interfaz.menuInicio(); // Llama al menú principal
        }catch(FileNotFoundException e2){ // Cuando no se encuentra un archivo
            System.out.println(e2.getMessage());
        }catch(IOException e1){ // Cuando se produce un error de entrada/salida
            System.out.println(e1.getMessage());
        }catch(Exception e){ // Cuando ocurre un error generico
            System.out.println(e.getMessage());
        }
    }
}