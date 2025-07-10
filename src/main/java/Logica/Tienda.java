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
   // private int max;
    public Tienda(int max){
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
            System.out.println("¿Qué desea comprar? \n0.Salir \n1.Insumos\n2.Mascotas\n3.Habitats");
            System.out.println("Ingrese número de producto: ");
            tipo = scanner.nextInt();
            if (tipo >= 1 & tipo <= 3) {  //nos aseguramos que el indice no esté fuera de limites
                if (tipo==1){this.comprarInsumo();}
                else if (tipo==2){this.comprarMascota();}
                else{this.comprarHabitat();}
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
                    index=intentarCompra(comida,1);
                    if (index!=-1){
                        comida.add(crearInsumo(1,index));}
                } else if (tipo == 2) {
                    System.out.println("Medicina disponible: ");
                    for(Insumo meds: medicina){
                        System.out.println(i+"."+meds);
                        i++;}
                    index=intentarCompra(medicina,1);
                    if (index!=-1){
                        medicina.add(crearInsumo(2,index));}
                } else {
                    System.out.println("Comida mejorada disponible: ");
                        for(Insumo power: comidaenhanced){
                            System.out.println(i+"."+power);
                            i++;}
                    index=intentarCompra(comidaenhanced,1);
                    if (index!=-1){
                        comidaenhanced.add(crearInsumo(3,index));}
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
                    index=intentarCompra(perros,3);
                    if (index!=-1){
                        perros.add(MascotaFactory.createMascota("perro"));}
                } else if (tipo == 2) {
                    System.out.println("Gatos disponibles: ");
                    for(Mascota gato: gatos){
                        System.out.println(i+"."+gato);
                        i++;}
                    index=intentarCompra(gatos,3);
                    if (index!=-1){
                        gatos.add(MascotaFactory.createMascota("gato"));}
                } else if (tipo == 3) {
                    System.out.println("Hamsters disponibles: ");
                    for(Mascota hamster: hamsters){
                        System.out.println(i+"."+hamster);
                        i++;}
                    index=intentarCompra(hamsters,3);
                    if (index!=-1){
                        hamsters.add(MascotaFactory.createMascota("hamster"));}
                } else if (tipo == 4) {
                    System.out.println("Aves disponibles: ");
                    for(Mascota ave: aves){
                        System.out.println(i+"."+ave);
                        i++;}
                    index=intentarCompra(aves,3);
                    if (index!=-1){
                        aves.add(MascotaFactory.createMascota("ave"));}
                } else {
                    System.out.println("Peces disponibles: ");
                    for(Mascota pez: peces){
                        System.out.println(i+"."+pez);
                        i++;}
                    index=intentarCompra(peces,3);
                    if (index!=-1){
                        peces.add(MascotaFactory.createMascota("pez"));}
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
                    index=intentarCompra(peceras,2);
                    if (index!=-1){
                        peceras.add(new Pecera(300*index,index));}
                } else if (tipo == 2) {
                    System.out.println("Jaulas disponibles: ");
                    for(Habitat jaula: jaulas){
                        System.out.println(i+"."+jaula);
                        i++;}
                    index=intentarCompra(jaulas,2);
                    if (index!=-1){
                        jaulas.add(new Jaula(500*index,index));}
                } else {
                    System.out.println("Jaulas para pájaros disponibles: ");
                    for(Habitat caja: jaulaspajaro){
                        System.out.println(i+"."+caja);
                        i++;}
                    index=intentarCompra(jaulaspajaro,2);
                    if (index!=-1){
                        jaulaspajaro.add(new JaulaPajaro(450*index,index));}
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

    private int intentarCompra(ArrayList lista,int tipo) {
        int index;
        int check=-1;
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese el número del producto deseado: ");
        index= scan.nextInt();
        if (index <= lista.size() & index > 0) {
            try {
                if(tipo==1) {
                    Jugador.getJugador().comprarInsumo((Insumo) lista.get(index - 1));
                }
                else if (tipo==2){
                    Jugador.getJugador().comprarHabitat((Habitat) lista.get(index - 1));
                }
                else if(tipo==3){
                    Jugador.getJugador().comprarMascota((Mascota) lista.get(index - 1));
                }
                lista.remove(lista.get(index - 1));
                System.out.println("Compra ha sido exitosa");
                check=index;
            } catch (DineroInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Número inválido, intente de nuevo");
            intentarCompra(lista,tipo);
        }
        return check;
    }

    public void ComprarPerro(Mascota mascota){
        try {
            Jugador.getJugador().comprarMascota(mascota);
            perros.remove(mascota);
            perros.add(MascotaFactory.createMascota("perro"));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarGato(Mascota mascota){
        try {
            Jugador.getJugador().comprarMascota(mascota);
            gatos.remove(mascota);
            gatos.add(MascotaFactory.createMascota("perro"));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarAves(Mascota mascota){
        try {
            Jugador.getJugador().comprarMascota(mascota);
            aves.remove(mascota);
            aves.add(MascotaFactory.createMascota("perro"));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarHamster(Mascota mascota){
        try {
            Jugador.getJugador().comprarMascota(mascota);
            hamsters.remove(mascota);
            hamsters.add(MascotaFactory.createMascota("perro"));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarPeces(Mascota mascota){
        try {
            Jugador.getJugador().comprarMascota(mascota);
            peces.remove(mascota);
            peces.add(MascotaFactory.createMascota("perro"));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }

    public void ComprarJaula(Habitat jaula){
        try {
            Jugador.getJugador().comprarHabitat(jaula);
            int i = jaulas.indexOf(jaula);
            jaulas.remove(jaula);
            jaulas.add(new Jaula(500*i,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarJaulaPajaro(Habitat jaula){
        try {
            Jugador.getJugador().comprarHabitat(jaula);
            int i = jaulaspajaro.indexOf(jaula);
            jaulaspajaro.remove(jaula);
            jaulaspajaro.add(new Jaula(450*i,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarPecera(Habitat jaula){
        try {
            Jugador.getJugador().comprarHabitat(jaula);
            int i = peceras.indexOf(jaula);
            peceras.remove(jaula);
            peceras.add(new Jaula(300*i,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }

    public void ComprarComida(Insumo insumo){
        try {
            Jugador.getJugador().comprarInsumo(insumo);
            int i = comida.indexOf(insumo);
            comida.remove(insumo);
            comida.add(crearInsumo(1,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarMedicina(Insumo insumo){
        try {
            Jugador.getJugador().comprarInsumo(insumo);
            int i = medicina.indexOf(insumo);
            medicina.remove(insumo);
            medicina.add(crearInsumo(2,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
    public void ComprarSuperComida(Insumo insumo){
        try {
            Jugador.getJugador().comprarInsumo(insumo);
            int i = comidaenhanced.indexOf(insumo);
            comidaenhanced.remove(insumo);
            comidaenhanced.add(crearInsumo(3,i));

        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }

    //mascotas
    public ArrayList<Mascota> getPerros() {
        return perros;
    }
    public ArrayList<Mascota> getGatos() {
        return gatos;
    }
    public ArrayList<Mascota> getAves() {
        return aves;
    }
    public ArrayList<Mascota> getHamsters() {
        return hamsters;
    }
    public ArrayList<Mascota> getPeces() {
        return peces;
    }
    //habitats
    public ArrayList<Habitat> getJaulas() {
        return jaulas;
    }
    public ArrayList<Habitat> getJaulaspajaro() {
        return jaulaspajaro;
    }
    public ArrayList<Habitat> getPeceras() {
        return peceras;
    }
    //insumos
    public ArrayList<Insumo> getComida() {
        return comida;
    }
    public ArrayList<Insumo> getMedicina() {
        return medicina;
    }
    public ArrayList<Insumo> getComidaenhanced() {
        return comidaenhanced;
    }
}
