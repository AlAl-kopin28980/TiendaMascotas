package Logica;

import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.Insumo;

import java.util.ArrayList;

public final class Jugador {
    private ArrayList<Mascota> mascotas;
    private ArrayList<Habitat> habitats;
    private int dinero;
    private ArrayList<Insumo> insumos;

    private static Jugador jugador = null;

    public static Jugador getJugador(){
        if (jugador==null){
            jugador=new Jugador(0);
        }
        return jugador;
    }

    private Jugador(int presupuesto){
        dinero=presupuesto;
        mascotas=new ArrayList<>();
        habitats=new ArrayList<>();
        insumos=new ArrayList<>();
    }

    public void darMascota(Mascota mascota){
        mascotas.add(mascota);
    }
    public void comprarMascota(Mascota mascota) throws DineroInsuficienteException{
        if(dinero>=mascota.getPrecio()) {
            darMascota(mascota);
            dinero = dinero - mascota.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }

    public void darHabitat(Habitat habitat){
        habitats.add(habitat);
    }
    public void comprarHabitat(Habitat habitat) throws DineroInsuficienteException{
        if(dinero>=habitat.getPrecio()) {
            darHabitat(habitat);
            dinero = dinero - habitat.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }

    public void darInsumo(Insumo insumo){
        insumos.add(insumo);
    }
    public void comprarInsumo(Insumo insumo) throws DineroInsuficienteException{
        if(dinero>=insumo.getPrecio()) {
            darInsumo(insumo);
            dinero = dinero - insumo.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }
    public ArrayList<Insumo> getInsumos() {
        return insumos;
    }

    public void Vender(Mascota mascota){
        boolean vendido = mascotas.remove(mascota);
        if (vendido){
            dinero += mascota.getPrecio();
        }
    }

    public void darDinero(int dinero){
        this.dinero+=dinero;
    }
    public int getPresupuesto() {
        return dinero;
    }

    public void showInventario(){
        for (Mascota mascota: mascotas){
            System.out.println(mascota.getClass().getSimpleName()+" - "+mascota);
        }
        for (Insumo insumo: insumos){
            System.out.println(insumo);
        }
        for (Habitat habitat: habitats){
            System.out.println(habitat.getClass().getSimpleName()+" - "+habitat);
        }
    }

}
