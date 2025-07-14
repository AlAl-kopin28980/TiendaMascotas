package Logica.Insumos;

import Logica.Mascota;
/**
 * Decorator que al aplicarlo a un insumo hace que la salud de una mascota aumente una cantidad entregada en el constructor
 */
public class ConsumoMedicina extends ConsumoDecorator{
    int subeSalud;
    public ConsumoMedicina(int contenido){
        subeSalud=contenido;
    }
    /**
     * la salud de la mascota aumenta de acuerdo a subeSalud
     * @param mascota que consume el insumo
     */
    @Override
    public void consumir(Mascota mascota) {
        mascota.setSalud(Math.min(mascota.getSalud() + subeSalud, 100));
    }
}
