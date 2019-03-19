package core;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import data.Jugador;
import utilidades.Utilidades;
import static core.Interfaz.*;

public class Metodos{
    
    static  Jugador     player  ;
    static  Scanner     sc      ;
    static  File        f       ;
    static  ImageIcon   icon    ;                                        
    
    public static Jugador playerBuilder() throws IOException{
        String[] razas = {"Humano", "Elfo", "Orco"};
        String nick;
        String raza = menuExitHandler((String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon("img/icons/Raza.jpg"), razas, null));
        player = new Jugador(raza.toString());
        icon = new ImageIcon(player.getAvatar());
        do{
            nick = menuExitHandler((String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icon, null, null));
        }while(!Utilidades.validar(nick));
        player.setNombre(nick.toString());
        FileWriter fw = new FileWriter(new File("save/index"), true);
        fw.write(player.getNombre() + ":");
        fw.close(); // CERRAR!!!
        fw = new FileWriter(new File("save/player/" + player.getNombre() + ".sav"));
        fw.write(player.getNombre() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + player.getHp() + ":" + player.getSave());
        fw.close(); // CERRAR!!!
        JOptionPane.showMessageDialog(null, "Te damos la bienvenida " + player.getNombre() + ".\n\nHaz click para comenzar.","RPGame", 0, icon);
        return player;
    }
    
    public static Jugador playerChooser() throws IOException{
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
        String nick = menuExitHandler((String) JOptionPane.showInputDialog(null, "Selecciona tu personaje", "RPGame", 0, new ImageIcon("img/icons/Load.jpg"), personajes, null));
        sc = new Scanner(new File("save/player/" + nick + ".sav"));
        while(sc.hasNext()){
            personaje = sc.nextLine().split(":");
            player = new Jugador(personaje[0], personaje[1], personaje[2], Integer.parseInt(personaje[3]), Integer.parseInt(personaje[4]));
        }
        sc.close();
        return player;
    }
    
    public static void cargarPartida(Jugador pj) throws IOException{
        switch(pj.getSave()){ // Redirige a un escenario concreto en base al ultimo guardado efectuado
            case 0:
                pj.setHp(100);
                escenario0(pj);
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
                System.out.println("default");
        }
    }

    public static void guardarPartida(Jugador pj, int n) throws IOException{
        pj.setSave(n);
        FileWriter fw = new FileWriter(new File("save/player/" + pj.getNombre() + ".sav"));
        fw.write(pj.getNombre() + ":" + pj.getRaza() + ":" + pj.getAvatar() + ":" + pj.getHp() + ":" + pj.getSave());
        fw.close(); // CERRAR!!!
    }
}