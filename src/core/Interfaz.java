package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static core.Metodos.*;
import data.Personaje;

public class Interfaz {
    
    public static void menuInicio() throws FileNotFoundException, IOException{
        String[] opciones = {"NUEVO JUEGO", "CONTINUAR", "CRÉDITOS", "SALIR"};
        File f;
        Scanner sc;
        int op = JOptionPane.showOptionDialog(null, null, "RPGame", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Inicio.jpg"), opciones, null);
        if(op == 0){
            cargarPartida(playerBuilder());
        }else if(op == 1){
            cargarPartida(playerChooser());
        }else if(op == 2){
            JOptionPane.showMessageDialog(null, "- Sergio Lorenzo Rodríguez.\n- Gabriel Pietrafesa Viéitez.\n\nVersión: Pre-alfa (en desarrollo)", "RPGame", 3);
            menuInicio();
        }
        System.exit(0);
    }
    
    public static String menuExitHandler(String op) throws IOException{
        if(op == null){
            menuInicio();
        }
        return op;
    }
    
    public static int crearEscena(String img, String[] opciones, String texto){
        return JOptionPane.showOptionDialog(null, texto, "RPGame", 0, 0, new ImageIcon(img), opciones, null);
    }
    
    public static void escenario1(Personaje pj) throws IOException{
        guardarPartida(pj, 1);
        System.out.println(pj.toString());
        String[] opciones = {"IR AL NORTE", "IR AL SUR"};
        int op = crearEscena("img/forest.gif", opciones, "Te despiertas en medio de un bosque.\nLlueve y está oscuro pero no estás seguro que sea de noche.\nTu hija pequeña, Luna, ha desaparecido.\nDecides ir a buscarla pero hay dos caminos que se separan.\nHace bastante frío y no sabes si tu hija estará bien.\n¿Qué quieres hacer?");
        if(op == 0){ // igual es mejor usar switch case en el futuro cuando haya muchas ramas para + organizacion
            System.out.println("Vas al norte");
        }else if(op == 1){
            System.out.println("Vas al sur");
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