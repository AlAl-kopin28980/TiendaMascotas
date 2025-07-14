package Logica.Insumos;

import Logica.Mascota;

import java.util.ArrayList;

/**
 * Insumo a ser consumido por una mascota
 */
public class Insumo {

    private String nombre;
    private int porciones;
    private int precio;
    ArrayList<ConsumoDecorator> decorators;

    /**
     *
     * @param nombre del insumo
     * @param porciones del insumo (veces que una mascota lo puede consumir)
     * @param precio por el cual se compra
     * decorators: lista de decorators aplicados
     */
    public Insumo(String nombre, int porciones, int precio){
        this.nombre=nombre;
        this.porciones=porciones;
        this.precio=precio;
        decorators = new ArrayList<>();
    }

    /**
     * @param d decorator a aplicar
     */
    public void addDecorator(ConsumoDecorator d){
        decorators.add(d);
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * @param mascota que consumirá el insumo
     */
    public void consumir(Mascota mascota){
        if (porciones>0) {
            porciones--;
            for (ConsumoDecorator decorator : decorators) {
                decorator.consumir(mascota);
            }
        }
    }
    public int getContenido(){
        return porciones;
    }

    public int getPrecio() {
        return precio;
    }

    public String toString(){
        String string=nombre+" - Porciones: "+porciones+" - $"+precio;
        return string;
    }
}
