package Logica;

import Logica.Insumos.ConsumoAlimento;
import Logica.Insumos.ConsumoMedicina;
import Logica.Insumos.Insumo;

public class Main {
    public static void main(String[] args){
        Mascota perrito=new Perro(TipoColor.NEGRO);
        Insumo med=new Insumo("medicina",1);
        med.addDecorator(new ConsumoMedicina(70));
        Insumo food=new Insumo("comida",2);
        food.addDecorator(new ConsumoAlimento(33));

        perrito.consumir(med);
        System.out.println("medicina contenido: "+med.getContenido());
        System.out.println("perro salud: "+perrito.getSalud());
        System.out.println("perro felicidad: "+perrito.getFelicidad());
        perrito.jugar();
        System.out.println("perro felicidad: "+perrito.getFelicidad());
        System.out.println("perro color: "+perrito.getColor());
        perrito.consumir(food);
        System.out.println("perro hambre: "+perrito.getHambre());
        perrito.consumir(food);
        System.out.println("perro hambre: "+perrito.getHambre());
        System.out.println("comida restante: "+food.getContenido());
        perrito.consumir(food);
        System.out.println("perro hambre: "+perrito.getHambre());
    }
}
