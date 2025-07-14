package Logica;

import java.util.ArrayList;
import java.util.Random;

/**
 * cliente que comprará alguna mascota
 */
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

    /**
     * escoge una mascota dentro de las que el jugador tiene "visibles" (en un habitat)
     * @return la mascota elegida
     */
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

    /**
     * compra la mascota elegida
     */
    public void Comprar(){
        tienda.Vender(mascotaelegida);
        Salir();
    }

    /**
     * sale de nuestra tienda de mascotas
     */
    public void Salir(){
        dentro=false;
    }

    /**
     * @return si está dentro o fuera de la tienda
     */
    public boolean isDentro() {
        return dentro;
    }
}
