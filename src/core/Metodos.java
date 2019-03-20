package core;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import data.Jugador;
import utilidades.Utilidades;
// import lib.Utilidades;
import static core.Interfaz.*;

public class Metodos{
    
    static  Jugador     player  ;
    static  Scanner     sc      ;
    static  File        f       ;
    static  ImageIcon   icon    ;                                        
    
    /* Construye un Jugador con las elecciones del usuario y lo guarda en su propio archivo de datos */
    public static Jugador playerBuilder() throws IOException{
        String raza = menuExitHandler((String) JOptionPane.showInputDialog(null, "Escoge tu raza:", "RPGame", 0, new ImageIcon("img/icons/raza.jpg"), new String[]{"Humano", "Elfo", "Orco"}, null));
        player = new Jugador(raza); // Creo un objeto Jugador con la raza elegida
        icon = new ImageIcon(player.getAvatar());  // Recojo el path del avatar que se ha generado al instanciar
        String nick;
        do{ // Bucle para pedir un nick válido
            nick = menuExitHandler((String) JOptionPane.showInputDialog(null, "Has seleccionado: '" + raza + "'.\n\nDale un nombre a tu personaje:", "RPGame", 0, icon, null, null));
        }while(!Utilidades.validar(nick)); // Uso la librería propia para filtrar carácteres no deseados como espacios, números, etc
        player.setNombre(nick.toString()); // Finalmente seteo el nombre
        FileWriter fw = new FileWriter(new File("save/index"), true); // Creo un objeto FileWriter para escribir en index y en modo añadir (por si ya existen pjs)
        fw.write(player.getNombre() + ":"); // Añado el nombre del nuevo pj junto con el separador ':'
        fw.close(); // CIERRO ARCHIVO
        fw = new FileWriter(new File("save/player/" + player.getNombre() + ".sav")); // Ahora hago lo mismo pero con todos los datos del jugador y lo guardo en su archivo personal
        fw.write(player.getNombre() + ":" + player.getRaza() + ":" + player.getAvatar() + ":" + player.getHp() + ":" + player.getSave());
        fw.close(); // CIERRO ARCHIVO
        JOptionPane.showMessageDialog(null, "Te damos la bienvenida " + player.getNombre() + ".\n\nHaz click para comenzar.","RPGame", 0, icon);
        return player; // Devuelvo el jugador que se ha creado
    } 
    
    /* Permite seleccionar un Jugador existente de los nombres que aparezcan en el index */
    public static Jugador playerChooser() throws IOException{
        f = new File("save/index");
        if(!f.exists()){ // Si el index no existe 
            JOptionPane.showMessageDialog(null, "No existen datos guardados, crea una nueva partida.", "RPGame", 2);
            menuInicio();
        }
        String[] personaje, personajes = null;
        sc = new Scanner(f);
        while(sc.hasNext()){ // Recorro el index en busca de nombress
            personajes = sc.nextLine().split(":"); // Recojo cada nombre usando el separador ':' y los guardo en un array
        }
        // Muestro todos los nombres de pjs que se han encontrado y espero a que se elija uno
        String nick = menuExitHandler((String) JOptionPane.showInputDialog(null, "Selecciona tu personaje", "RPGame", 0, new ImageIcon("img/icons/cargar.jpg"), personajes, null));
        // Una vez elegido busco y recorro su correspondiente archivo de guardado
        sc = new Scanner(new File("save/player/" + nick + ".sav"));
        while(sc.hasNext()){ // Recorro el archivo de guardado de ese personaje en concreto
            personaje = sc.nextLine().split(":");
            // Recojo los datos del archivo y los paso a un objeto Jugador
            player = new Jugador(personaje[0], personaje[1], personaje[2], Integer.parseInt(personaje[3]), Integer.parseInt(personaje[4]));
        }
        sc.close(); // CIERRO ARCHIVO
        return player; // Devuelvo el jugador
    }
    
    /* Redirige a un escenario concreto en base al ultimo guardado efectuado */
    public static void cargarPartida(Jugador pj) throws IOException{
        switch(pj.getSave()){
            case 0:
                pj.setHp(100); // Cuando empiece un juego nuevo (o se venga de una muerte)
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
    
    /*  Actualiza los datos del Jugador en su archivo de datos */
    public static void guardarPartida(Jugador pj, int n) throws IOException{
        pj.setSave(n);
        FileWriter fw = new FileWriter(new File("save/player/" + pj.getNombre() + ".sav"));
        fw.write(pj.getNombre() + ":" + pj.getRaza() + ":" + pj.getAvatar() + ":" + pj.getHp() + ":" + pj.getSave());
        fw.close(); // CIERRO ARCHIVO
    }
}