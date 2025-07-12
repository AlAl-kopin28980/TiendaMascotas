package Logica;

public class Jaula extends Habitat<MascotaTerrestre>{
    public Jaula(int precio, int size){
        super(precio,size,MascotaTerrestre.class);
    }
    @Override
    public String toString(){
        return "Jaula - "+super.toString();
    }
}
