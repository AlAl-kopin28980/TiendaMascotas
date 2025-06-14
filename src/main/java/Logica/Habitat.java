package Logica;
public abstract class Habitat {
    protected Mascota mascota;
    protected int limpieza;
    public Habitat(){
        limpieza=100;
    }
    public void limpiarHabitat(){
        limpieza=100;
    }
    public int getLimpieza(){
        return limpieza;
    }
    public Mascota getMascota(){return mascota;}
}
