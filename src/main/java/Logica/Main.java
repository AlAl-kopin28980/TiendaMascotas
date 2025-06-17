package Logica;

public class Main {
    public static void main(String[] args){
        MascotaFactory fabrica=new MascotaFactory();
        Perro perrito=fabrica.createPerro();
        System.out.println(String.format("hambre: %d felicidad: %d salud: %d",perrito.getHambre(),perrito.getFelicidad(),perrito.getSalud()));
        Medicina med=new Medicina(150);
        BolsaAlimento food=new BolsaAlimento(50,"perro");

        perrito.darMedicina(med);
        System.out.println(med.getContenido());
        System.out.println(perrito.getSalud());
        System.out.println(perrito.getFelicidad());
        perrito.jugar();
        System.out.println(perrito.getFelicidad());
        System.out.println(perrito.getColor());
        perrito.alimentar(food);
        System.out.println(perrito.getHambre());
        perrito.alimentar(food);
        System.out.println(perrito.getHambre());
        System.out.println("comida restante: "+food.getContenido());
        perrito.alimentar(food);
        System.out.println(perrito.getHambre());

    }
}
