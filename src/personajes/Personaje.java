/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package personajes;

public class Personaje {
    private String nick;
    private String raza;
    private double statVida = 100, statAtaque;
    private final String avatar;
    
    public Personaje(String raza){
        this.raza = raza;
        if(raza.equalsIgnoreCase("humano")){
            this.statVida = 100;
            this.statAtaque = 120;
            this.avatar = "img/icons/humano.jpg";
        }else if(raza.equalsIgnoreCase("elfo")){
            this.statVida = 300;
            this.statAtaque = 90;
            this.avatar = "img/icons/elfo.jpg";
        }else{
            this.statVida = 150;
            this.statAtaque = 100;
            this.avatar = "img/icons/orco.jpg";
        }
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

    public double getStatVida() {
        return statVida;
    }

    public void setStatVida(double statVida) {
        this.statVida = statVida;
    }

    public double getStatAtaque() {
        return statAtaque;
    }

    public void setStatAtaque(double statAtaque) {
        this.statAtaque = statAtaque;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nick=" + nick + ", raza=" + raza + ", statVida=" + statVida + ", statAtaque=" + statAtaque + '}';
    }
}