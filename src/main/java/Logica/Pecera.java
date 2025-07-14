package Logica;

/**
 * pecera que solo acepta peces
 */
public class Pecera extends Habitat<Pez>{
    /**
     * @param precio por el que se compra
     * @param size cantidad maxima de peces que pueden estar dentro
     */
    public Pecera(int precio, int size){
        super(precio, size, Pez.class);
    }
    @Override
    public String toString(){
        return "Pecera - "+super.toString();
    }
}
