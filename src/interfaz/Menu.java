/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package interfaz;

import javax.swing.JOptionPane;
import personajes.Personaje;
import utilidades.PedirDatos;

public class Menu {
    
    public static void crearPJ(){
        Personaje player = new Personaje();
        player.setNick(JOptionPane.showInputDialog(null,"¿Cómo te llamarás?","Juego",3));

        String[] options = {"Humano", "Elfo", "Orco"};
        JOptionPane.showOptionDialog(null, "Bienvenido al mundo, " + player.getNick() + ".\n\nSelecciona tu raza:", "Juego", 0, JOptionPane.QUESTION_MESSAGE, null, options, "Humano");
    }
}