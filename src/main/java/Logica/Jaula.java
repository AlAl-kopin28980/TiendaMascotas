package Logica;

/**
 * Jaula que solo acepta animales terrestres (perros, gatos y hamsters)
 */
public class Jaula extends Habitat<MascotaTerrestre>{
    /**
     * @param precio por el que se puede comprar
     * @param size cantidad maxima de mascotas que pueden estar dentro
     */
    public Jaula(int precio, int size){
        super(precio,size,MascotaTerrestre.class);
    }
    @Override
    public String toString(){
        return "Jaula - "+super.toString();
    }
}
