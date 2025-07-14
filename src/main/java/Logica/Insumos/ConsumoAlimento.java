package Logica.Insumos;

import Logica.Mascota;

/**
 * Decorator que al aplicarlo a un insumo hace que el hambre de una mascota disminuya una canitdad entregada en el constructor
 */
public class ConsumoAlimento extends ConsumoDecorator{
    int quitaHambre;
    public ConsumoAlimento(int contenido){
        quitaHambre=contenido;
    }

    /**
     * el hambre de la mascota disminuye de acuerdo a quitahambre
     * @param mascota que consume el insumo
     */
    @Override
    public void consumir(Mascota mascota) {
        mascota.setHambre(Math.max(mascota.getHambre() - quitaHambre, 0));
    }
}
