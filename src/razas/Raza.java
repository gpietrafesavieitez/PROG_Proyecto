/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package razas;

public class Raza {
private int statVida, statAtaque, statDefensa, statMagia;
    private String idioma;

    public Raza() {
    }

    public Raza(int statVida, int statAtaque, int statDefensa, int statMagia, String idioma) {
        this.statVida = statVida;
        this.statAtaque = statAtaque;
        this.statDefensa = statDefensa;
        this.statMagia = statMagia;
        this.idioma = idioma;
    }

    public int getStatVida() {
        return statVida;
    }

    public void setStatVida(int statVida) {
        this.statVida = statVida;
    }

    public int getStatAtaque() {
        return statAtaque;
    }

    public void setStatAtaque(int statAtaque) {
        this.statAtaque = statAtaque;
    }

    public int getStatDefensa() {
        return statDefensa;
    }

    public void setStatDefensa(int statDefensa) {
        this.statDefensa = statDefensa;
    }

    public int getStatMagia() {
        return statMagia;
    }

    public void setStatMagia(int statMagia) {
        this.statMagia = statMagia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Raza{" + "statVida=" + statVida + ", statAtaque=" + statAtaque + ", statDefensa=" + statDefensa + ", statMagia=" + statMagia + ", idioma=" + idioma + '}';
    }
}