/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package juego;

import javax.swing.JOptionPane;
import interfaz.Interfaz;
import java.io.FileNotFoundException;
import personajes.Personaje;

public class Juego {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("*** DEBUG ***");
        Personaje player = Interfaz.pantallaInicio();
        String e1 = Interfaz.crearEscenario("img/Bosque.jpg",new String[]{"Ir al Norte","Ir al Sur"}, "Despiertas en un bosque, no hay\nnadie a tu alrededor y no\nsabes qué hora es pero sabes\nque es de noche porque lo\npoco que puedes ver es gracias\na la luz de la luna.\n\nPuedes ver dos caminos...\n\n¿Qué quieres hacer?");
        if(e1.equals("0")){
            System.out.println("Vas al norte");
        }else if(e1.equals("1")){
            System.out.println("Vas al sur");
        }else{
            System.out.println("else");
        }
        System.out.println(player.toString() + e1);
    }
}
