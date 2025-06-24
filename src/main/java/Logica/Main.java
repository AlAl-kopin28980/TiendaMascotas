package Logica;

import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.ConsumoAlimento;
import Logica.Insumos.ConsumoMedicina;
import Logica.Insumos.Insumo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        MascotaFactory fabrica=new MascotaFactory();
        Mascota perrito=null;
        try{
            perrito=fabrica.createMascota("perro");}
        catch (Exception w){
            System.out.println(w.getMessage());
        }
        System.out.println(String.format("hambre: %d felicidad: %d salud: %d precio: %d",perrito.getHambre(),perrito.getFelicidad(),perrito.getSalud(),perrito.getPrecio()));

        Insumo med=new Insumo("medicina",1,500);
        med.addDecorator(new ConsumoMedicina(70));
        Insumo food=new Insumo("comida",2,450);
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
        System.out.println(String.format("hambre: %d felicidad: %d salud: %d precio: %d",perrito.getHambre(),perrito.getFelicidad(),perrito.getSalud(),perrito.getPrecio()));

        //habitat
        Jaula j = new Jaula(100,2);
        j.addMascota(perrito);
        ArrayList<Mascota> list = j.getMacotaList();
        System.out.println(list);

        //venta
        Jugador player = Jugador.getJugador();
        player.darDinero(10000);
        try {
            player.comprarMascota(perrito);
        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
        System.out.println(player.getMascotas()+","+player.getPresupuesto());
        Cliente cliente = new Cliente();
        cliente.elegirMascota();
        cliente.Comprar();
        System.out.println(player.getMascotas()+","+player.getPresupuesto());
    }
}
