/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import personajes.Personaje;

public class Menu {
    
    public static Personaje crearPJ(){
        Personaje player;
        String[] arrayRazas = {"Humano", "Elfo", "Orco"};
        try{
            ImageIcon icono = new ImageIcon("img/icons/raza.jpg");
            Object razaElegida = JOptionPane.showInputDialog(null, "Selecciona tu raza", "RPG", 0, icono, arrayRazas, "Humano");
            player = new Personaje(razaElegida.toString());
            icono = new ImageIcon(player.getAvatar());
            Object nickElegido = JOptionPane.showInputDialog(null, "¿Cómo se llamará tu personaje?", "RPG", 0, icono, null, null);
            player.setNick(nickElegido.toString());
            return player;
        }catch(NullPointerException e1){
            System.exit(0);
        }catch(Exception e){
            System.out.println("DEBUG: " + e.getMessage());
        }
        return null;
    }
    
}