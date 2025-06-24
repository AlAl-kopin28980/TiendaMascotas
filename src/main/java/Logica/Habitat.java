package Logica;
public abstract class Habitat {
    protected Mascota mascota;
    protected int limpieza;
    protected int precio;
    protected int tamaño;
    public Habitat(int precio){
        limpieza=100;
        this.precio=precio;
    }
    public void limpiarHabitat(){
        limpieza=100;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public int getLimpieza(){
        return limpieza;
    }
    public Mascota getMascota(){return mascota;}

    public int getPrecio() {
        return precio;
    }
}
