package core;

import clases.Personaje;
import static core.Interfaz.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.Utilidades;

public class Metodos {
    static  Personaje   player  ;
    static  Scanner     sc      ;
    static  File        f       ;
    static  ImageIcon   icon    ;                                        
    
    public static Personaje playerBuilder() throws IOException{
        String[] razas = {"Humano", "Elfo", "Orco"};
        String nick;
        String raza = menuHandler((String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon("img/icons/Raza.jpg"), razas, null));
        player = new Personaje(raza.toString());
        icon = new ImageIcon(player.getAvatar());
        do{
            nick = menuHandler((String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icon, null, null));
        }while(!Utilidades.validar(nick));
        player.setNick(nick.toString());
        FileWriter fw = new FileWriter(new File("save/index"), true);
        fw.write(player.getNick() + ":");
        fw.close(); // CERRAR!!!
        fw = new FileWriter(new File("save/player/" + player.getNick() + ".sav"));
        fw.write(player.getNick() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + player.getHp() + ":" + player.getSave());
        fw.close(); // CERRAR!!!
        JOptionPane.showMessageDialog(null, "Te damos la bienvenida " + player.getNick() + ".\n\nHaz click para comenzar.","RPGame", 0, icon);
        return player;
    }
    
    public static Personaje playerChooser() throws IOException{
        f = new File("save/index");
        if(!f.exists()){
            JOptionPane.showMessageDialog(null, "No existen datos guardados, crea una nueva partida.", "RPGame", 2);
            menuInicio();
        }
        String[] personaje, personajes = null;
        sc = new Scanner(f);
        while(sc.hasNext()){
            personajes = sc.nextLine().split(":");
        }
        String nick = menuHandler((String) JOptionPane.showInputDialog(null, "Selecciona un personaje", "RPGame", 0, new ImageIcon("img/icons/Load.jpg"), personajes, null));
        sc = new Scanner(new File("save/player/" + nick + ".sav"));
        while(sc.hasNext()){
            personaje = sc.nextLine().split(":");
            player = new Personaje(personaje[0], personaje[1], personaje[2], Integer.parseInt(personaje[3]), Integer.parseInt(personaje[4]));
        }
        sc.close();
        return player;
    }
    
    public static void cargarPartida(Personaje pj) throws IOException{
        switch(pj.getSave()){ // Redirige a un escenario concreto en base al ultimo guardado efectuado
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
        FileWriter fw = new FileWriter(new File("save/player/" + pj.getNick() + ".sav"));
        fw.write(pj.getNick() + ":" + pj.getRaza() + ":" + pj.getAvatar() + ":" + pj.getHp() + ":" + pj.getSave());
        fw.close(); // CERRAR!!!
    }
}