/**
 * Gabriel P.
 * CPR Daniel Castelao
 * @author <gpietrafesavieitez@danielcastelao.org>
 */

package personajes;

public class Personaje {
    private String nick, raza, avatar;
    private int[] stats;
    
    public Personaje(){
    }

    public Personaje(String raza) {
        this.raza = raza;
        this.avatar = "img/icons/" + this.raza + ".jpg";
        if(raza.equalsIgnoreCase("humano")){
            stats = new int[] {100,120,80};
        }else if(raza.equalsIgnoreCase("elfo")){
            stats = new int[] {200,80,50};
        }else{
            stats = new int[] {75,150,95};
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

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Personaje{" + "nick=" + nick + ", raza=" + raza + ", stats=" + stats + ", avatar=" + avatar + '}';
    }
    
    //metodo atacar()?
}