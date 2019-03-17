package core;

import java.io.IOException;

public class Juego {
    
    public static void ejecutar(){
        System.out.println("*** DEBUG ***");
        try{
            Interfaz.menuInicio();
        }catch(Exception e){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
        }
    }
}