package Logica.Insumos;

import Logica.Mascota;

/**
 * Decorator que se aplica a insumo para un efecto que se aplica a la mascota que lo consume
 */
public abstract class ConsumoDecorator {
    public abstract void consumir(Mascota mascota);
}
