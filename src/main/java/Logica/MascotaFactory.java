package Logica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class MascotaFactory {
    private Random random = new Random();
    private ArrayList<TipoColor> colores=new ArrayList<TipoColor>(Arrays.asList(TipoColor.NARANJA,TipoColor.NEGRO,TipoColor.BLANCO,TipoColor.GRIS,TipoColor.PATRON));
    public Mascota createMascota(String tipo) throws Exception{
        switch (tipo) {
            case "perro": return new Perro(random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
            case "gato": return new Gato( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
            case "ave": return new Ave( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
            case "pez": return new Ave( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
            case "hamster": return new Ave( random.nextInt(101), random.nextInt(101), random.nextInt(101),colores.get(random.nextInt(5)));
            default:
                throw new Exception("Tipo incorrecto de mascota");
        }
    }

}


