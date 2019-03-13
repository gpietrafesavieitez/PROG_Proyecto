/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package core;

import clases.Personaje;
import static core.Interfaz.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Metodos {
    
    public static Personaje playerBuilder(){
        Personaje player = null;
        Object raza, nick;
        ImageIcon icon;
        String[] arrayRazas = {"Humano", "Elfo", "Orco"};
        File f;
        FileWriter fw;
        try{
            raza = JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon("img/icons/Raza.jpg"), arrayRazas, null);
            player = new Personaje(raza.toString());
            icon = new ImageIcon(player.getAvatar());
            do{
                nick = JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icon, null, null);
            }while(nick.toString().isEmpty());
            player.setNick(nick.toString());
            fw = new FileWriter(new File("save/index.sav"), true);
            fw.write(player.getNick() + ":");
            fw.close();
            fw = new FileWriter(new File("save/player/" + player.getNick() + ".sav"));
            fw.write(player.getNick() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + player.getHp() + ":" + player.getSave());
            fw.close();
            JOptionPane.showMessageDialog(null, "Bienvenido/a al mundo '" + player.getNick() + "'.\n\nHaz click para comenzar.","RPGame", 0, icon);
            player.setSave(0);
        }catch(NullPointerException e1){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
            System.exit(0);
        }catch(Exception e){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
        }
        return player;
    }
    
    public static String sceneBuilder(String img, String[] opciones, String texto){
        try{
             Object decision = JOptionPane.showOptionDialog(null, texto, "RPGame", 0, 0, new ImageIcon(img), opciones, null);
             return decision.toString();
        }catch(Exception e){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
        }
        return null;
    }
    
    public static void cargarPartida(Personaje pj) throws IOException{
        switch(pj.getSave()){
            case 0:
                System.out.println("Pasas x el escenario 0 primero xd");
            case 1:
                escenario1(pj);
                break;
            case 2:
                escenario2(pj);
                break;
            case 3:
                escenario3(pj);
                break;
            default:
                System.out.println("nosexd");
        }
    }
    
    public static void guardarPartida(Personaje pj, int n) throws IOException{
        pj.setSave(n);
        File f = new File("save/player/" + pj.getNick() + ".sav");
        FileWriter fw = new FileWriter(f);
        fw.write(pj.getNick() + ":" + pj.getRaza() + ":" + pj.getAvatar() + ":" + pj.getHp() + ":" + pj.getSave());
        fw.close();
    }
}