package app;

import core.Interfaz;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Juego {
    
    public static void iniciar(){
        System.out.println("Debug console:");
        try{
            Interfaz.menuInicio();
        }catch(FileNotFoundException e2){
            System.out.println(e2.getMessage());
        }catch(IOException e1){
            System.out.println(e1.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}