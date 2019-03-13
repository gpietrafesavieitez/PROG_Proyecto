/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package core;

import java.io.IOException;

public class Juego {
    
    public static void ejecutar(){
        try{
            Interfaz.pantallaInicio();
        }catch(IOException ex){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
        }
    }
}