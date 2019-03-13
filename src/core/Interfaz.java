/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import clases.Personaje;
import static core.Metodos.*;

public class Interfaz {
    
    public static void pantallaInicio() throws FileNotFoundException, IOException{
        Personaje player = null;
        String[] opciones = {"Nueva partida", "Continuar"};
        String[] personajes = null;
        String[] personaje;
        String nick;
        File f;
        Scanner sc;
        int op = JOptionPane.showOptionDialog(null, null, "RPGame", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Inicio.jpg"), opciones, null);
        if(op == 0){
            cargarPartida(playerBuilder());
        }else if(op == 1){
            f = new File("save/index.sav");
            if(!f.exists()){
                f.createNewFile();
            }
            sc = new Scanner(f);
            while(sc.hasNext()){
                personajes = sc.nextLine().split(":");
            }
            if(personajes != null){
                nick = (String) JOptionPane.showInputDialog(null, "Selecciona tu personaje:", "RPGame", 0, new ImageIcon("img/icons/Load.jpg"), personajes, null);
                sc = new Scanner(new File("save/player/" + nick + ".sav"));
                while(sc.hasNext()){
                    personaje = sc.nextLine().split(":");
                    //--------------------(String nick ,String raza ,Str avatar  , int hp , int save     )
                    player = new Personaje(personaje[0], personaje[1], personaje[2], Integer.parseInt(personaje[3]), Integer.parseInt(personaje[4]));
                }
                sc.close();
                cargarPartida(player);
            }else{
                System.out.println("No hay datos guardados."); // ACABAR GUI
            }
        }else{
            System.exit(0);
        }
    }

    public static void escenario1(Personaje pj) throws IOException{
        guardarPartida(pj, 1);
        System.out.println("Este es el escenario 1");
        System.out.println(pj.toString());
        String[] opciones = {"Ir al Norte", "Ir al Sur"};
        String op = sceneBuilder("img/Bosque.jpg", opciones, "Despiertas en un bosque, no hay\nnadie a tu alrededor y no\nsabes qué hora es pero sabes\nque es de noche porque lo\npoco que puedes ver es gracias\na la luz de la luna.\n\nPuedes ver dos caminos...\n\n¿Qué quieres hacer?");
        if(op.equals("0")){ // igual es mejor usar switch case en el futuro cuando haya muchas ramas para + organizacion
            System.out.println("Vas al norte");
            escenario2(pj);
        }else if(op.equals("1")){
            System.out.println("Vas al sur");
            escenario3(pj);
        }else{
            System.out.println("else");
        }
    }
    
    public static void escenario2(Personaje pj) throws IOException{
        guardarPartida(pj, 2);
        System.out.println("Este es el escenario 2 => NORTE");
        System.out.println(pj.toString());
    }
    
    public static void escenario3(Personaje pj) throws IOException{
        guardarPartida(pj, 3);
        System.out.println("Este es el escenario 3 => SUR");
        System.out.println(pj.toString());
    }
}