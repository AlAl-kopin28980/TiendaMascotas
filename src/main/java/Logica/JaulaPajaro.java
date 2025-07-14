package Logica;

/**
 * jaula para pajaros que solo acepta aves
 */
public class JaulaPajaro extends Habitat<Ave>{
    /**
     * @param precio por el que se compra
     * @param size cantidad maxima de aves que pueden estar dentro
     */
    public JaulaPajaro(int precio, int size){
        super(precio,size,Ave.class);
    }
    @Override
    public String toString(){
        return "Jaula para pájaro - "+super.toString();
    }
}
