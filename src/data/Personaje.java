package data;

import static core.Interfaz.*;
import static core.Metodos.*;
import java.io.IOException;

public class Personaje {
    private String nick, raza, avatar;
    private int hp, save;
    
    public Personaje(){
    }

    public Personaje(String raza) {
        this.raza = raza;
        this.avatar = "img/icons/" + this.raza + ".jpg";
    }

    public Personaje(String nick, String raza, String avatar, int hp, int save) {
        this.nick = nick;
        this.raza = raza;
        this.avatar = avatar;
        this.hp = hp;
        this.save = save;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }
    
    @Override
    public String toString() {
        return "Personaje{" + "nick=" + nick + ", raza=" + raza + ", avatar=" + avatar + ", hp=" + hp + ", save=" + save + '}';
    }
    
    public void morir() throws IOException {
        guardarPartida(this, 0);
        crearEscena("img/icons/Morir.jpg", new String[]{"Game Over"}, "¡Has muerto! :(");
        menuInicio();
    }
}