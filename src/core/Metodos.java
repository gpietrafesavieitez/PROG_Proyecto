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
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Metodos {
    
    public static String testSalir(String op) throws IOException{
        if(op == null){
            pantallaInicio();
        }
        return op;
    }
    
    public static Personaje playerBuilder(){
        Personaje player = null;
        String raza, nick;
        String[] razas = {"Humano", "Elfo", "Orco"};
        Scanner sc;
        File f;
        ImageIcon icon;
        try{
            raza = testSalir((String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon("img/icons/Raza.jpg"), razas, null));
            player = new Personaje(raza.toString());
            icon = new ImageIcon(player.getAvatar());
            boolean flagExiste;
            do{
                flagExiste = false;
                nick = testSalir((String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icon, null, null));
                f = new File("save/index");
                if(f.exists()){
                    sc = new Scanner(f);
                    String[] personaje;
                    while(sc.hasNextLine()){
                        personaje = sc.nextLine().split(":");
                        for(int i = 0; i < personaje.length; i ++){
                            if(nick.equalsIgnoreCase(personaje[i])){
                                flagExiste = true;
                                JOptionPane.showMessageDialog(null, "Ya existe ese nombre, elige otro.", "RPGame", 2);
                                break;
                            }
                        }
                    }
                }
            }while(flagExiste || nick.toString().isEmpty()); // igual molaba una libreria para sanear el nombre => sin caracteres raros num espacios etc
            player.setNick(nick.toString());
            FileWriter fw = new FileWriter(new File("save/index"), true);
            fw.write(player.getNick() + ":");
            fw.close(); // CERRAR!!!
            fw = new FileWriter(new File("save/player/" + player.getNick() + ".sav"));
            fw.write(player.getNick() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + player.getHp() + ":" + player.getSave());
            fw.close(); // CERRAR!!!
            JOptionPane.showMessageDialog(null, "Te damos la bienvenida " + player.getNick() + ".\n\nHaz click para comenzar.","RPGame", 0, icon);
        }catch(Exception e){
            System.out.println("ESTO HAY QUE TRATARLO CON EXCEPCIONES PROPIAS");
        }
        return player;
    }
    
    public static Personaje playerChooser() throws IOException{
        Personaje player = null;
        File f = new File("save/index");
        if(!f.exists()){
            JOptionPane.showMessageDialog(null, "No existen datos guardados, crea una nueva partida.", "RPGame", 2);
            pantallaInicio();
        }
        String[] personaje, personajes = null;
        String nick;
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            personajes = sc.nextLine().split(":");
        }
        nick = testSalir((String) JOptionPane.showInputDialog(null, "Selecciona un personaje", "RPGame", 0, new ImageIcon("img/icons/Load.jpg"), personajes, null));
        sc = new Scanner(new File("save/player/" + nick + ".sav"));
        while(sc.hasNext()){
            personaje = sc.nextLine().split(":");
            player = new Personaje(personaje[0], personaje[1], personaje[2], Integer.parseInt(personaje[3]), Integer.parseInt(personaje[4]));
        }
        sc.close();
        return player;
    }
    
    public static int sceneBuilder(String img, String[] opciones, String texto){
        return JOptionPane.showOptionDialog(null, texto, "RPGame", 0, 0, new ImageIcon(img), opciones, null);
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
    // SOLO SE GUARDA AL PRINCIPIO DE CADA NUEVO ESCENARIO
    public static void guardarPartida(Personaje pj, int n) throws IOException{
        pj.setSave(n);
        FileWriter fw = new FileWriter(new File("save/player/" + pj.getNick() + ".sav"));
        fw.write(pj.getNick() + ":" + pj.getRaza() + ":" + pj.getAvatar() + ":" + pj.getHp() + ":" + pj.getSave());
        fw.close(); // CERRAR!!!
    }
}