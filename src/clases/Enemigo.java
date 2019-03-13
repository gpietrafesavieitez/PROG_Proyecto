/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package clases;

public class Enemigo {
    private String nombre, avatar;
    private int[] stats;
    
    public Enemigo() {
    }
    
    public Enemigo(String nombre, String avatar, int[] stats) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.stats = stats;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Enemigo{" + "nombre=" + nombre + ", avatar=" + avatar + ", stats=" + stats + '}';
    }

    //metodo atacar()?
}