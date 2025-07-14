package Logica;

import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.Insumo;

import java.util.ArrayList;

/**
 * Jugador a cargo de la tienda, basicamente somos la tienda de mascotas
 */
public final class Jugador {
    private ArrayList<Mascota> mascotas;
    private ArrayList<Habitat> habitats;
    private int dinero;
    private ArrayList<Insumo> insumos;

    private static Jugador jugador = null;

    public void resetJugador(){jugador=null;}  //para facilitar test unitarios

    /**
     * @return instancia del jugador porque es singleton
     */
    public static Jugador getJugador(){
        if (jugador==null){
            jugador=new Jugador(0);
        }
        return jugador;
    }

    /**
     * @param presupuesto cantidad de dinero inicial para hacer compras
     */
    private Jugador(int presupuesto){
        dinero=presupuesto;
        mascotas=new ArrayList<>();
        habitats=new ArrayList<>();
        insumos=new ArrayList<>();
    }

    /**
     * @param mascota que se le da de forma gratuita
     */
    public void darMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    /**
     * @param mascota a comprar
     * @throws DineroInsuficienteException si nuestro dinero no alcanza para comprar la mascota deseada
     */
    public void comprarMascota(Mascota mascota) throws DineroInsuficienteException{
        if(dinero>=mascota.getPrecio()) {
            darMascota(mascota);
            dinero = dinero - mascota.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }

    /**
     * @param habitat que se le da de forma gratuita
     */
    public void darHabitat(Habitat habitat){
        if (!habitats.contains(habitat)) {
            habitats.add(habitat);
        }
    }

    /**
     * @param habitat a comprar
     * @throws DineroInsuficienteException si la cantidad de dinero que tenemos no alcanza para comprar el habitat
     */
    public void comprarHabitat(Habitat habitat) throws DineroInsuficienteException{
        if(dinero>=habitat.getPrecio()) {
            darHabitat(habitat);
            dinero = dinero - habitat.getPrecio();
        }
        else{
            throw new DineroInsuficienteException();
        }
    }

    /**
     * @param insumo a dar de forma gratuita
     */
    public void darInsumo(Insumo insumo){
        insumos.add(insumo);
    }

    /**
     * @param insumo a comprar
     * @throws DineroInsuficienteException si nuestro dinero no alcanza para comprar el habitat
     */
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
        insumos.removeIf(in -> in.getContenido() <= 0);
        return insumos;
    }

    /**
     * @param mascota que venderemos
     */
    public void Vender(Mascota mascota){
        boolean vendido = mascotas.remove(mascota);
        if (vendido){
            dinero += mascota.getPrecio();
        }
    }

    /**
     * @param dinero se da dinero que se suma a nuestro presupuesto
     */
    public void darDinero(int dinero){
        this.dinero+=dinero;
    }
    public int getPresupuesto() {
        return dinero;
    }

    /**
     * mostramos el inventario a través de la consola
     */
    public void showInventario(){
        for (Mascota mascota: mascotas){
            //System.out.println(mascota.getClass().getSimpleName()+" - "+mascota);
            System.out.println(mascota);
        }
        for (Insumo insumo: insumos){
            System.out.println(insumo);
        }
        for (Habitat habitat: habitats){
            System.out.println(habitat.getClass().getSimpleName()+" - "+habitat);
        }
    }

}
