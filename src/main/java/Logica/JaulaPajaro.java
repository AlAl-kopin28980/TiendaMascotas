package Logica;

public class JaulaPajaro extends Habitat<Ave>{
    public JaulaPajaro(int precio, int size){
        super(precio,size);
    }
    @Override
    public String toString(){
        return "Jaula para pájaro - "+super.toString();
    }
}
