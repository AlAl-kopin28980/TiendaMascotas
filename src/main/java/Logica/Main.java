package Logica;

public class Main {
    public static void main(String[] args){
        Mascota perrito=new Perro(TipoColor.NEGRO);
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
