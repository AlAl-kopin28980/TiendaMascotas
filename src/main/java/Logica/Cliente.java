package Logica;

import java.util.ArrayList;
import java.util.Random;

public class Cliente {
    private Jugador tienda;
    private Mascota mascotaelegida;
    private Random rng;
    private boolean dentro;
    public Cliente(){
        this.tienda=Jugador.getJugador();
        rng = new Random();
        dentro = true;
    }

    public Mascota elegirMascota(){
        int contador=0;
        ArrayList<Mascota> mascotas = tienda.getMascotas();
        for (Mascota mascota: mascotas){
            if (mascota.getHabitat()!=null){contador++;}
        }
        if (mascotas.size()>0 && contador!=0){
            mascotaelegida=mascotas.get(rng.nextInt(mascotas.size()));
            if(mascotaelegida.getHabitat()==null){this.elegirMascota();}}

        else{return null;}

        return mascotaelegida;
    }

    public void Comprar(){
        tienda.Vender(mascotaelegida);
        Salir();
    }
    public void Salir(){
        dentro=false;
    }

    public boolean isDentro() {
        return dentro;
    }
}
