package Logica.Insumos;

import Logica.Mascota;

public class ConsumoMedicina extends ConsumoDecorator{
    int subeSalud;
    public ConsumoMedicina(int contenido){
        subeSalud=contenido;
    }

    @Override
    public void consumir(Mascota mascota) {
        mascota.setSalud(Math.min(mascota.getSalud() + subeSalud, 100));
    }
}
