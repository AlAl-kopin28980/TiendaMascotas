package Logica;

import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Mascota> perros, gatos, aves, hamsters, peces;
    private ArrayList<Habitat> peceras, jaulas, jaulaspajaro;
    private ArrayList<Insumo> comida, medicina, comidaenhanced;
    private Insumo food;
    private Jugador jugador;
   // private int max;
    public Tienda(int max,Jugador jugador){
        this.jugador=jugador;
        perros=new ArrayList<>(); gatos=new ArrayList<>(); aves=new ArrayList<>(); hamsters=new ArrayList<>(); peces=new ArrayList<>();
        peceras=new ArrayList<>(); jaulaspajaro=new ArrayList<>(); jaulas= new ArrayList<>();
        comida=new ArrayList<>(); medicina=new ArrayList<>(); comidaenhanced=new ArrayList<>();
       // this.max=max;
        for(int i=1; i<=max;i++){
            perros.add(MascotaFactory.createMascota("perro"));
            gatos.add(MascotaFactory.createMascota("gato"));
            aves.add(MascotaFactory.createMascota("ave"));
            peces.add(MascotaFactory.createMascota("pez"));
            hamsters.add(MascotaFactory.createMascota("hamster"));
            peceras.add(new Pecera(300*i,i));
            jaulas.add(new Jaula(500*i,i));
            jaulaspajaro.add(new JaulaPajaro(450*i,i));
            comida.add(this.crearInsumo(1,i));
            medicina.add(this.crearInsumo(2,i));
            comidaenhanced.add(this.crearInsumo(3,i));
        }
    }
    public void comprarCosas(){
        int tipo=1;
        Scanner scanner = new Scanner(System.in);  // Scanner para ingresar indice
        while(tipo!=0) {  //cuando producto es cero indicamos que queremos salir del programa
            System.out.println("¿Qué desea comprar? \n0.Salir \n1.Insumos\n2.Mascotas\n3.Habitats \n4.Solicitar relleno de stock");
            System.out.println("Ingrese número de producto: ");
            tipo = scanner.nextInt();
            if (tipo >= 1 & tipo <= 4) {  //nos aseguramos que el indice no esté fuera de limites
                if (tipo==1){this.comprarInsumo();}
                else if (tipo==2){this.comprarMascota();}
                else if (tipo==3){this.comprarHabitat();}
                else{this.rellenarStock();}
            }
            else if(tipo!=0){
                System.out.println("Número NO válido, intente de nuevo");
                this.comprarCosas();
            }
        }
        if(tipo==0){
            System.out.println("Saliendo de la tienda");
        }

    }
    public void comprarInsumo(){
        Scanner scanner = new Scanner(System.in);
        int tipo=1;
        int index;
        while (tipo!=0) {
            System.out.println("Tipos de insumos disponibles: \n0.Salir \n1.Comida\n2.Medicina\n3.Comida mejorada");
            tipo = scanner.nextInt();
            if (tipo <= 3 & tipo >= 1) {
                int i=1;
                if (tipo == 1) {
                    System.out.println("Comida disponible: ");
                    for(Insumo comidita: comida){
                        System.out.println(i+"."+comidita);
                        i++;
                    }
                    intentarCompra(comida,1);
                } else if (tipo == 2) {
                    System.out.println("Medicina disponible: ");
                    for(Insumo meds: medicina){
                        System.out.println(i+"."+meds);
                        i++;}
                    intentarCompra(medicina,1);
                } else {
                    System.out.println("Comida mejorada disponible: ");
                        for(Insumo power: comidaenhanced){
                            System.out.println(i+"."+power);
                            i++;}
                    intentarCompra(comidaenhanced,1);
                }
            }
            else if (tipo!=0){
                System.out.println("Número inválido, intente de nuevo.");
                comprarInsumo();
            }
        }
        if(tipo==0){
            System.out.println("Saliendo de la sección de insumos");
        }
    }
    public void comprarMascota(){
        Scanner scanner = new Scanner(System.in);
        int tipo=1;
        int index;
        while (tipo!=0) {
            System.out.println("Tipos de mascotas disponibles: \n0.Salir \n1.Perros\n2.Gatos\n3.Hamsters\n4.Aves\n5.Peces");
            tipo = scanner.nextInt();
            if (tipo <= 5 & tipo >= 1) {
                int i=1;
                if (tipo == 1) {
                    System.out.println("Perros disponibles: ");
                    for(Mascota perro: perros){
                        System.out.println(i+"."+perro);
                        i++;
                    }
                    intentarCompra(perros,3);
                } else if (tipo == 2) {
                    System.out.println("Gatos disponibles: ");
                    for(Mascota gato: gatos){
                        System.out.println(i+"."+gato);
                        i++;}
                    intentarCompra(gatos,3);
                } else if (tipo == 3) {
                System.out.println("Hamsters disponibles: ");
                for(Mascota hamster: hamsters){
                    System.out.println(i+"."+hamster);
                    i++;}
                intentarCompra(hamsters,3);
                } else if (tipo == 4) {
                    System.out.println("Aves disponibles: ");
                    for(Mascota ave: aves){
                        System.out.println(i+"."+ave);
                        i++;}
                    intentarCompra(aves,3);
                } else {
                    System.out.println("Peces disponibles: ");
                    for(Mascota pez: peces){
                        System.out.println(i+"."+pez);
                        i++;}
                    intentarCompra(peces,3);
                }
            }
            else if (tipo!=0){
                System.out.println("Número inválido, intente de nuevo.");
                comprarMascota();
            }
        }
        if(tipo==0){
            System.out.println("Saliendo de la sección de mascotas");
        }
    }
    public void comprarHabitat(){
        Scanner scanner = new Scanner(System.in);
        int tipo=1;
        int index;
        while (tipo!=0) {
            System.out.println("Tipos de habitats disponibles: \n0.Salir \n1.Peceras\n2.Jaulas\n3.Jaulas para pájaros");
            tipo = scanner.nextInt();
            if (tipo <= 3 & tipo >= 1) {
                int i=1;
                if (tipo == 1) {
                    System.out.println("Peceras disponibles: ");
                    for(Habitat pecera: peceras){
                        System.out.println(i+"."+pecera);
                        i++;
                    }
                    intentarCompra(peceras,2);
                } else if (tipo == 2) {
                    System.out.println("Jaulas disponibles: ");
                    for(Habitat jaula: jaulas){
                        System.out.println(i+"."+jaula);
                        i++;}
                    intentarCompra(jaulas,2);
                } else {
                    System.out.println("Jaulas para pájaros disponibles: ");
                    for(Habitat caja: jaulaspajaro){
                        System.out.println(i+"."+caja);
                        i++;}
                    intentarCompra(jaulaspajaro,2);
                }
            }
            else if (tipo!=0){
                System.out.println("Número inválido, intente de nuevo.");
                comprarInsumo();
            }
        }
        if(tipo==0){
            System.out.println("Saliendo de la sección de habitats");
        }
    }
    private Insumo crearInsumo(int tipo, int i){
        if (tipo==1){
            food=new Insumo("comida",i+2,i*100);
            food.addDecorator(new ConsumoAlimento(33));
        }
        else if (tipo==2){
            food=new Insumo("medicina",i+2,i*100);
            food.addDecorator(new ConsumoMedicina(33));
        }
        else if (tipo==3){
            food=new Insumo("comida-mejorada",i+2,i*200);
            food.addDecorator(new ConsumoAlimento(22));
            food.addDecorator(new ConsumoDiversion(22));
            food.addDecorator(new ConsumoMedicina(22));
        }
        return food;
    }

    private void intentarCompra(ArrayList lista,int tipo) {
        int index;
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese el número del producto deseado: ");
        index= scan.nextInt();
        if (index <= lista.size() & index > 0) {
            try {
                if(tipo==1) {
                    jugador.comprarInsumo((Insumo) lista.get(index - 1));
                }
                else if (tipo==2){
                    jugador.comprarHabitat((Habitat) lista.get(index - 1));
                }
                else if(tipo==3){
                    jugador.comprarMascota((Mascota) lista.get(index - 1));
                }
                lista.remove(lista.get(index - 1));
                System.out.println("Compra ha sido exitosa");
            } catch (DineroInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Número inválido, intente de nuevo");
            intentarCompra(lista,tipo);
        }
    }

    private void rellenarStock(){
        //lo ideal seria que rellene los i que se sacaron, para que siempre estén las mismas porciones/tamaños
    }
}
