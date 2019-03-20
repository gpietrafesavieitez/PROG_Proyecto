package core;

import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import data.*;
import static core.Metodos.*;

public class Interfaz{
    
    static  Random  rand        ;
    static  int     randPlayer  ;
    static  int     randEnemy   ;
    
    /* Pantalla de bienvenida */
    public static void menuInicio() throws IOException{
        int op = JOptionPane.showOptionDialog(null, null, "RPGame", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("img/menu.gif"), new String[]{"Nueva partida", "Continuar", "Créditos", "Salir"}, null);
        switch(op){
            case 0: // Primero crea el personaje y después lo lleva al escenario 0
                cargarPartida(playerBuilder());
                break;
            case 1: // Primero hace seleccionar un pj y después lo lleva al escenario correspondiente
                cargarPartida(playerChooser());
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "- Gabriel Pietrafesa Viéitez.\n- Sergio Lorenzo Rodríguez.\n\nVersión: 1.2.2", "RPGame", 3);
                menuInicio();
                break;
            default: 
                System.exit(0);
        }
    }
    
    /* Método especial para tratar la excepción que se produce cuando queremos salir/cancelar en un JOP que devuelve un String */
    public static String menuExitHandler(String op) throws IOException{
        if(op == null){
            menuInicio();
        }
        return op;
    }
    
    /* Herramienta para crear JOPs personalizados que se adaptan a la estructura de la interfaz que se usa en el juego */
    public static int crearEscena(String img, String[] opciones, String texto) throws IOException{
        int op = JOptionPane.showOptionDialog(null, texto, "RPGame", 0, 0, new ImageIcon(img), opciones, null);
        if(op == -1){
            menuInicio();
        }
        return op;
    }
    
    /* Escenario principal */
    public static void escenario0(Jugador pj) throws IOException{
        int op = crearEscena("img/bosque.gif", new String[]{"Continuar"}, "Te despiertas en medio de un oscuro bosque.\nLlueve bastante y apenas hay luz pero no\nestás muy seguro que sea de noche.\nNo sabes que haces ahí pero recuerdas que hace\npoco estabas con tu hija pequeña Megumin dando\nun paseo y ahora ha desaparecido. Decides ir\na buscarla pero frente tuya hay dos caminos\nque se separan. Hace frío y no sabes si tu\nhija estará bien.");
    }
    
    /* Primer escenario */
    public static void escenario1(Jugador pj) throws IOException{
        guardarPartida(pj, 1); // Se guarda siempre al entrar a un escenario nuevo
        int op = crearEscena("img/bosque.gif", new String[]{"Izquierda", "Derecha"}, "Estás en el bosque.\n\nDos caminos se separan ante ti,\n\n¿Cuál tomarás?");
        if(op == 0){
            escenario2(pj);
        }else if(op == 1){
            op = crearEscena("img/ciudad.gif", new String[]{"Volver", "Entrar", "Infiltrarte"}, "Llegas a las puertas de una pequeña\nciudadela. A ambos lados hay unos\nenormes guardias que las custodian.\nEs posible que dentro haya alguien\nque sepa algo sobre tu hija pero no\nsabes si serás bien recibido en esa\nciudad. ¿Qué opcion eliges?");
            switch(op){
                case 0: 
                    escenario1(pj);
                    break;
                case 1:
                    crearEscena("img/ciudad.gif", new String[]{"Continuar"}, "Nada más dar un paso los\nguardias te apuntan con sus\narmas y te gritan que te marches\nasí que no te queda más remedio\nque dar media vuelta.");
                    escenario1(pj);
                    break;
                case 2:
                    rand = new Random();
                    // Se simula una tirada al dado
                    randPlayer = rand.nextInt((100 - 0) + 1) + 0; // Numero aleatorio entre 0 y 100
                    if(randPlayer < 50){ // Si es menor que 50 fallas y no te cuelas
                        crearEscena("img/ciudad.gif", new String[]{"Continuar"}, "Intentas escabullirte y fallas.\n\nLos guardias te han visto tratando de saltar la muralla.\n\nTe cogen y te echan de la ciudad.");
                        escenario1(pj);
                    }else{ // Si es mayor que 50 consigues colarte
                        op = crearEscena("img/alcantarillas.gif", new String[]{"''DONDE ESTA MI HIJA''", "''Estoy buscando a mi hija''"}, "Consigues adentrarte satisfactoriamente\nen la ciudad a través del sistema de\nalcantarillado sin que los guardias se\nden cuenta. Llegas a una especie de zona\nsecreta de la ciudad donde te encuentras\ncon un hombre barbudo que te pregunta\nqué ***** haces ahí.");
                        if(op == 0){
                            crearEscena("img/alcantarillas.gif", new String[]{"Continuar"}, "''¡Hey, no hace falta que me grites!\n¿Una chiquilla de rojo? si, vi a\nalguien así hace unas horas corriendo\nhacia el bosque. Si ha ido hacia allí\nserá mejor que te des prisa en encontrarla\nporque dentro vive una criatura siniestra.''");
                        }else{
                            crearEscena("img/alcantarillas.gif", new String[]{"Continuar"}, "''¿Una chiquilla de rojo? si, vi a\nalguien así hace unas horas corriendo\nhacia el bosque. Si ha ido hacia allí\nserá mejor que te des prisa en encontrarla\nporque dentro vive una criatura siniestra.''");
                        }
                        escenario3(pj);
                    }
                    break;
            }
        }
    }
    
    /* Segundo escenario */
    public static void escenario2(Jugador pj) throws IOException{
        guardarPartida(pj, 2); // Se guarda siempre al entrar a un escenario nuevo
        int op = crearEscena("img/elfos.gif", new String[]{"Atacar", "Dialogar"}, "Te adentras por el camino de la izquierda y\nte encuentras con un pequeño grupo de elfos\nque se dan cuenta de tu presencia. No sabes\nsi son hostiles pero es posible que sepan\nalgo acerca de tu hija. ¿Qué haces?");
        if(op == 1 && pj.getRaza().equalsIgnoreCase("Elfo")){
            crearEscena("img/elfos.gif", new String[]{"Continuar"}, "El grupo de elfos parece amigable\ny hablando con ellos te cuentan que\nhace unas pocas horas vieron a\nuna niña escapando de algo en\ndirección al centro del bosque.\nLes pides que concreten qué era lo\nque le perseguía pero te dicen\nque no tienen ni idea.");
        }else{
            crearEscena("img/elfos.gif", new String[]{"¡Luchar!"}, "De repente, uno de los elfos\ncarga contra ti tan rápido que\nno te da tiempo ni a reaccionar\ny te asesta un golpe en la cara.\nTe apartas rápidamente pero no\npuedes ignorar el sabor de la\nsangre. Desenfundas tu arma y\nte preparas para la batalla...");
            pj.setHp(100);
            Enemigo enemy = new Enemigo(100);
            while(enemy.getHp() > 0){ // Mientras el enemigo no muera se sigue luchando
                if(player.getHp() <= 0){ // Si en algun momento la vida del Jugador llega a 0 rompe el bucle y muere
                    player.morir();
                    break;
                }
                rand = new Random();
                randEnemy = rand.nextInt((25 - 0) + 1) + 0; // Daño producido por el enemigo
                player.setHp(player.getHp() - randEnemy);
                randPlayer = rand.nextInt((100 - 0) + 1) + 0; // Daño producido por el jugador
                enemy.setHp(enemy.getHp() - randPlayer);
                crearEscena("img/elfos2.gif", new String[]{"¡Atacar!"}, "El elfo arremete contra ti y te hace " + randEnemy + " punto(s) de daño.\n\nTienes " + player.getHp() + " punto(s) de vida.\n\nAhora tu atacas al elfo y le causas " + randPlayer + " punto(s) de daño.");
            }
            crearEscena("img/elfos.gif", new String[]{"Leer"}, "Finalmente, consigues encajar un golpe\nmortal al elfo y éste cae redondo al\nsuelo. Ante tal situación, los elfos\nque quedan huyen despavoridos. Decides\nregistrar al elfo por si lleva alguna\npista y encuentras una extraña nota...");
            crearEscena("img/icons/pista.jpg", new String[]{"Continuar"}, "La nota reza:\n''Sigue por el sendero sombrío y hallarás tu destino.''");
        }
        escenario3(pj);
    }
    
    /* Tercer escenario */
    public static void escenario3(Jugador pj) throws IOException{
        guardarPartida(pj, 3); // Se guarda siempre al entrar a un escenario nuevo
        crearEscena("img/sendero.gif", new String[]{"Continuar"}, "La pista te conduce hacia un oscuro\nsendero que lleva a un lugar recóndito\ndel bosque. Mientras sigues el camino\npuedes observar manchas de sangre,\ntodavía frescas. Te temes lo peor así\nque apuras el paso...");
        crearEscena("img/boss.gif", new String[]{"¡Luchar!"}, "Tus pasos te acaban llevando\nhasta un pequeño claro. Justo\nen el medio se encuentra una\ncriatura la cual no sabrías\nidentificar pero claramente\nhumanoide. La criatura parece\nestar afilando su arma hasta\nque se entera de tu presencia\ny carga contra ti, pero tu ya\nestás preparado para lo que se\navecina a continuación... ");
        pj.setHp(100);
        Enemigo enemy = new Enemigo(200);
        while(enemy.getHp() > 0){ // Mientras el enemigo no muera se sigue luchando
            if(player.getHp() <= 0){ // Si en algun momento la vida del Jugador llega a 0 rompe el bucle y muere
                player.morir();
                break;
            }
            rand = new Random();
            randEnemy = rand.nextInt((50 - 0) + 1) + 0; 
            player.setHp(player.getHp() - randEnemy);
            randPlayer = rand.nextInt((100 - 0) + 1) + 0;
            enemy.setHp(enemy.getHp() - randPlayer);
            crearEscena("img/boss2.gif", new String[]{"Atacar"}, "La criatura arremete contra ti y te hace " + randEnemy + " punto(s) de daño.\n\nTienes " + player.getHp() + " punto(s) de vida.\n\nAhora tu atacas a la criatura y le causas " + randPlayer + " punto(s) de daño.");
        }
        escenario4(pj);
    }
    
    /* Cuarto y último escenario */
    public static void escenario4(Jugador pj) throws IOException{
        guardarPartida(pj, 0); // // Se guarda para escenario 0 ya volvemos a empezar
        crearEscena("img/hija.gif", new String[]{"Continuar"}, "¡Felicidades, lo has conseguido!\n\nHas rescatado a tu hija, ahora está sana y salva.\n\nHaz click para empezar una nueva partida.");
        menuInicio();
    }
}