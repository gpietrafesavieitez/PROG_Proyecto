package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import data.*;
import static core.Metodos.*;

public class Interfaz {
    
    public static void menuInicio() throws FileNotFoundException, IOException{
        int op = JOptionPane.showOptionDialog(null, null, "RPGame", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/Inicio.jpg"), new String[]{"NUEVO JUEGO", "CONTINUAR", "CRÉDITOS", "SALIR"}, null);
        switch(op){
            case 0:
                cargarPartida(playerBuilder());
                break;
            case 1:
                cargarPartida(playerChooser());
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "- Sergio Lorenzo Rodríguez.\n- Gabriel Pietrafesa Viéitez.\n\nVersión: Pre-alfa (en desarrollo)", "RPGame", 3);
                menuInicio();
                break;
            default:
                System.exit(0);
        }
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
        int op = crearEscena("img/Forest.gif", new String[]{"IR A LA IZQUIERDA", "IR A LA DERECHA"}, "Te despiertas en medio de un bosque.\nLlueve y está oscuro pero no estás seguro que sea de noche.\nTu hija pequeña, Luna, ha desaparecido.\nDecides ir a buscarla pero hay dos caminos que se separan.\nHace bastante frío y no sabes si tu hija estará bien.\n¿Qué quieres hacer?");
        if(op == 0){
            op = crearEscena("img/Fight1.gif", new String[]{"ENFRENTAR", "DIALOGAR"}, "Te adentras por el camino de la izquierda y\nte encuentras con un grupo de elfos que se dan cuenta\nde tu presencia. No sabes si son hostiles\npero es posible que sepan algo de tu hija\n¿Qué haces?");
            if(op == 1 && pj.getRaza().equalsIgnoreCase("Elfo")){
                op = crearEscena("img/Fight1.gif", new String[]{"CONTINUAR"}, "El grupo de elfos parece amigable\ny hablando con ellos te cuentan que\nhace unas pocas horas vieron a\nuna niña escapando de algo en\ndirección al centro del bosque.\nLes pides que concreten qué era lo\nque le perseguía pero te dicen\nque no tienen ni idea.");
            }else{ // Sistema muy arcaico de pelea
                Random rand = new Random();
                int randnum;
                Enemigo enemy = new Enemigo("Elfos", 100);
                do{
                    if(player.getHp() <= 0){
                        System.out.println("muerto lol");
                        break;
                    }
                    randnum = rand.nextInt((50 - 0) + 1) + 0;
                    player.setHp(player.getHp() - randnum);
                    op = crearEscena("img/Fight1.gif", new String[]{"ATACAR", "HUIR"}, "El grupo de elfos te ataca y te hace " + randnum + " puntos de daño. Tienes " + player.getHp() + " puntos de vida\n¿Qué haces?");
                    if(op == 0){
                        randnum = rand.nextInt((100 - 0) + 1) + 0;
                        enemy.setHp(enemy.getHp() - randnum);
                        op = crearEscena("img/Fight1.gif", new String[]{"CONTINUAR"}, "Atacas al grupo de elfos y les haces " + randnum + " puntos de daño.");
                    }else if(op == 1){
                        randnum = rand.nextInt((100 - 0) + 1) + 0;
                        if(randnum > 50){
                            op = crearEscena("img/Fight1.gif", new String[]{"CONTINUAR"}, "Intentas escapar de tu enemigo y lo consigues.");
                            break;
                        }else{
                            op = crearEscena("img/Fight1.gif", new String[]{"CONTINUAR"}, "Intentas escapar de tu enemigo sin éxito.");
                        }
                    }
                }while(enemy.getHp() > 0);
            }
            System.out.println("Sales del bucle");
        }else if(op == 1){  
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