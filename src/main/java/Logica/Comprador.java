package Logica;

public class Comprador {
    private int dinero;
    private Mascota mascota=null;
    public Comprador(){

    }
    public void comprarMascota(Mascota mascota){
        this.mascota=mascota;
    }
    public Mascota rechazarMascota(){
        return mascota;
    }
}
