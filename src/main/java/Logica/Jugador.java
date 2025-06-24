package Logica;

import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.Insumo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Mascota> mascotas;
    private ArrayList<Habitat> habitats;
    private int dinero;
    private ArrayList<Insumo> insumos;
    public Jugador(int presupuesto){
        dinero=presupuesto;
        mascotas=new ArrayList<>();
        habitats=new ArrayList<>();
    }
    public void comprarMascota(Mascota mascota) throws DineroInsuficienteException{
        if(dinero>=mascota.getPrecio()) {
            mascotas.add(mascota);
            dinero = dinero - mascota.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }
    public void comprarHabitat(Habitat habitat) throws DineroInsuficienteException{
        if(dinero>=habitat.getPrecio()) {
            habitats.add(habitat);
            dinero = dinero - habitat.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }
    public void comprarInsumo(Insumo insumo) throws DineroInsuficienteException{
        if(dinero>=insumo.getPrecio()) {
            insumos.add(insumo);
            dinero = dinero - insumo.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }
}
