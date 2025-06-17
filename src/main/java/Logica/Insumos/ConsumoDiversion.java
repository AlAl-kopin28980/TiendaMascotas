package Logica.Insumos;

import Logica.Mascota;

public class ConsumoDiversion extends ConsumoDecorator{
    int subeFelicidad;
    public ConsumoDiversion(int contenido){
        subeFelicidad=contenido;
    }

    @Override
    public void consumir(Mascota mascota) {
        mascota.setFelicidad(Math.min(mascota.getFelicidad() + subeFelicidad, 100));
    }
}
