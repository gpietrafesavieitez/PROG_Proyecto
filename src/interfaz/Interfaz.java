/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package interfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import personajes.Personaje;

public class Interfaz {
    
    public static Personaje pantallaInicio() throws FileNotFoundException{
        Personaje player = null;
        Object op;
        String[] opciones = {"Nueva partida", "Continuar"};
        op = JOptionPane.showInputDialog(null, null, "RPGame", 0, null, opciones, null);
        if(op == "Nueva partida"){
            player = crearPersonaje();
        }else{
            String nick;
            File f;
            Scanner sc;
            do{
                nick = JOptionPane.showInputDialog(null, "Introduce el nick de tu PJ:", "RPGame", 3);
                f = new File("save/" + nick + ".txt");
            }while(!f.exists());
            sc = new Scanner(f);
            while(sc.hasNext()){
                String[] personaje = sc.nextLine().split(":");
                player = new Personaje(personaje[0],personaje[1],personaje[2]);
            }
        }
        return player;
    }
    
    public static Personaje crearPersonaje(){ // se podia guardar el personaje q creas 
        Personaje player;
        Object raza, nick;
        ImageIcon icono;
        String[] arrayRazas = {"Humano", "Elfo", "Orco"};
        try{
            icono = new ImageIcon("img/icons/Raza.jpg");
            raza = JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, icono, arrayRazas, null);
            player = new Personaje(raza.toString());
            icono = new ImageIcon(player.getAvatar());
            do{
                nick = JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icono, null, null);
            }while(nick.toString().isEmpty());
            player.setNick(nick.toString());
            
            File f = new File("save/" + player.getNick() + ".txt");
            FileWriter fw = new FileWriter(f);
            fw.write(player.getNick() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + Arrays.toString(player.getStats()));
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Bienvenido/a al mundo '" + player.getNick() + "'.\n\nHaz click para comenzar.","RPGame", 0, icono);
            return player;
        }catch(NullPointerException e1){
            System.exit(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String crearEscenario(String img, String[] opciones, String texto){
        ImageIcon imagen;
        Object decision;
        try{
             imagen = new ImageIcon(img);
             decision = JOptionPane.showOptionDialog(null, texto, "RPGame", 0, 0, imagen, opciones, null);
             return decision.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}