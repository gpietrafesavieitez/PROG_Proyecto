package data;

public class Enemigo {
    private int hp;

    public Enemigo() {
    }

    public Enemigo(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Enemigo{" + "hp=" + hp + '}';
    }
}