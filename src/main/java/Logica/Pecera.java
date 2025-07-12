package Logica;

public class Pecera extends Habitat<Pez>{
    public Pecera(int precio, int size){
        super(precio, size);
    }
    @Override
    public String toString(){
        return "Pecera - "+super.toString();
    }
}
