package Logica;

import java.util.ArrayList;
import java.util.Random;

public class Cliente {
    private Jugador tienda;
    private Mascota mascotaelegida;
    private Random rng;
    private boolean dentro;

    private ArrayList<Mascota> opciones;
    public Cliente(){
        this.tienda=Jugador.getJugador();
        rng = new Random();
        dentro = true;
    }

    public Mascota elegirMascota(){
        opciones = new ArrayList<>();
        for (Habitat habitat: tienda.getHabitats()){
            for (Object mascota: habitat.getMacotaList()){
                opciones.add((Mascota) mascota);
            }
        }

        if (opciones.size()>0) {
            mascotaelegida = opciones.get(rng.nextInt(opciones.size()));
        } else {
            mascotaelegida = null;
        }

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
