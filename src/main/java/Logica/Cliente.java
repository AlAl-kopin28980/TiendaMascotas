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
        ArrayList<Mascota> mascotas = tienda.getMascotas();
        mascotaelegida=mascotas.get(rng.nextInt(mascotas.size()));

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
