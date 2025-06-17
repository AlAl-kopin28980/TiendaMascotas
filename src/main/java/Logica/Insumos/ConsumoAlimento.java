package Logica.Insumos;

import Logica.Mascota;

public class ConsumoAlimento extends ConsumoDecorator{
    int quitaHambre;
    public ConsumoAlimento(int contenido){
        quitaHambre=contenido;
    }

    @Override
    public void consumir(Mascota mascota) {
        mascota.setHambre(Math.min(mascota.getHambre() + quitaHambre, 100));
    }
}
