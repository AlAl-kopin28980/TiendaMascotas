package Logica.Insumos;

import Logica.Mascota;
/**
 * Decorator que al aplicarlo a un insumo hace que la felicidad de una mascota aumente una cantidad entregada en el constructor
 */
public class ConsumoDiversion extends ConsumoDecorator{
    int subeFelicidad;
    public ConsumoDiversion(int contenido){
        subeFelicidad=contenido;
    }

    /**
     * la felicidad de la mascota aumenta de acuerdo a subeFelicidad
     * @param mascota que consume el insumo
     */
    @Override
    public void consumir(Mascota mascota) {
        mascota.setFelicidad(Math.min(mascota.getFelicidad() + subeFelicidad, 100));
    }
}
