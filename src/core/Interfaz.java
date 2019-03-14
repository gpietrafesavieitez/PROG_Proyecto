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
        String[] opciones = {"NUEVO JUEGO", "CONTINUAR", "CRÉDITOS", "SALIR"};
        File f;
        Scanner sc;
        int op = JOptionPane.showOptionDialog(null, null, "RPGame", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Inicio.jpg"), opciones, null);
        if(op == 0){
            cargarPartida(playerBuilder());
        }else if(op == 1){
            cargarPartida(playerChooser());
        }else if(op == 2){
            JOptionPane.showMessageDialog(null, "- Sergio Lorenzo Rodríguez.\n- Gabriel Pietrafesa Viéitez.\n\nVersión 1.0.0", "RPGame", 3);
            pantallaInicio();
        }
        System.exit(0);
    }

    public static void escenario1(Personaje pj) throws IOException{
        guardarPartida(pj, 1);
        System.out.println(pj.toString());
        String[] opciones = {"IR AL NORTE", "IR AL SUR"};
        int op = sceneBuilder("img/Test2.jpg", opciones, null);
        if(op == 0){ // igual es mejor usar switch case en el futuro cuando haya muchas ramas para + organizacion
            System.out.println("Vas al norte");
            escenario2(pj);
        }else if(op == 1){
            System.out.println("Vas al sur");
            escenario3(pj);
        }else{ // cuando sales (?)
            System.out.println("else");
        }
    }
    
    public static void escenario2(Personaje pj) throws IOException{
        guardarPartida(pj, 2);
        System.out.println("Este es el escenario 2");
        System.out.println(pj.toString());
    }
    
    public static void escenario3(Personaje pj) throws IOException{
        guardarPartida(pj, 3);
        System.out.println("Este es el escenario 3");
        System.out.println(pj.toString());
    }
}