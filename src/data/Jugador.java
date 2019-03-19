package data;

import java.io.IOException;
import static core.Metodos.*;
import static core.Interfaz.*;

public class Jugador extends Personaje{

    private int save;
    
    public Jugador(String raza){
        this.raza = raza;
        this.avatar = "img/icons/" + this.raza + ".jpg";
    }
    
    public Jugador(String nombre, String raza, String avatar, int hp, int save){
        super(nombre, raza, avatar, hp);
        this.save = save;
    }

    public int getSave(){
        return save;
    }

    public void setSave(int save){
        this.save = save;
    }

    public void morir() throws IOException{
        guardarPartida(this, 0);
        crearEscena("img/icons/Morir.jpg", new String[]{"Game Over"}, "¡Has muerto! :(");
        menuInicio();
    }
}