package data;

public class Personaje{
    
    protected String nombre, raza, avatar;
    protected int hp;

    public Personaje(){
    }

    public Personaje(String nombre, String raza, String avatar, int hp){
        this.nombre = nombre;
        this.raza = raza;
        this.avatar = avatar;
        this.hp = hp;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRaza(){
        return raza;
    }

    public void setRaza(String raza){
        this.raza = raza;
    }

    public String getAvatar(){
        return avatar;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    @Override
    public String toString(){
        return "Personaje{" + "nombre=" + nombre + ", raza=" + raza + ", avatar=" + avatar + ", hp=" + hp + '}';
    }
}