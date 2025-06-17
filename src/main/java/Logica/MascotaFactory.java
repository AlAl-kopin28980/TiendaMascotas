package Logica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class MascotaFactory {
    Random random = new Random();
    ArrayList<TipoColor> colores=new ArrayList<TipoColor>(Arrays.asList(TipoColor.NARANJA,TipoColor.NEGRO,TipoColor.BLANCO,TipoColor.GRIS,TipoColor.PATRON));
    public  MascotaFactory(){

    }
    public Perro createPerro(){
        return new Perro( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
    }
    public Gato createGato(){
        return new Gato( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
    }
    public Ave createAve(){
        return new Ave( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
    }
    public Pez createPez(){
        return new Pez( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
    }
        public Hamster createHamster(){
        return new Hamster( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
    }
}


