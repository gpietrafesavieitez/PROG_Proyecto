/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package menus;

import javax.swing.JOptionPane;
import personajes.Personaje;
import utilidades.PedirDatos;

public class menu {
    
    public static void crearPJ(){
        Personaje player = new Personaje();
        player.setNick(PedirDatos.tipoString(true, "¿Cómo te llamarás?"));
        player.setRaza(PedirDatos.tipoString(true, "Bienvenido al mundo, " + player.getNick() + "Ahora dime tu raza:"));
        player.createStats();
    }
}