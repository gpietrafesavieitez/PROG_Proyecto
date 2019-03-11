/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package personajes;

public class Personaje {
    private String nick;
    private String[] inventario;
    private String raza;
    private double statVida = 100, statAtaque, statDefensa, statMagia;
    
    public Personaje(){ 
    }

    public Personaje(String nick, String[] inventario, String raza, double statAtaque, double statDefensa, double statMagia) {
        this.nick = nick;
        this.inventario = inventario;
        this.raza = raza;
        this.statAtaque = statAtaque;
        this.statDefensa = statDefensa;
        this.statMagia = statMagia;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String[] getInventario() {
        return inventario;
    }

    public void setInventario(String[] inventario) {
        this.inventario = inventario;
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

    public double getStatDefensa() {
        return statDefensa;
    }

    public void setStatDefensa(double statDefensa) {
        this.statDefensa = statDefensa;
    }

    public double getStatMagia() {
        return statMagia;
    }

    public void setStatMagia(double statMagia) {
        this.statMagia = statMagia;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nick=" + nick + ", inventario=" + inventario + ", raza=" + raza + ", statVida=" + statVida + ", statAtaque=" + statAtaque + ", statDefensa=" + statDefensa + ", statMagia=" + statMagia + '}';
    }
}