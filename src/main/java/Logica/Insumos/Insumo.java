package Logica.Insumos;

import Logica.Mascota;

import java.util.ArrayList;

public class Insumo {
    private String nombre;
    private int porciones;

    ArrayList<ConsumoDecorator> decorators;
    public Insumo(String nombre, int porciones){
        this.nombre=nombre;
        this.porciones=porciones;

        decorators = new ArrayList<>();
    }

    public void addDecorator(ConsumoDecorator d){
        decorators.add(d);
    }

    public String getNombre() {
        return nombre;
    }

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
}
