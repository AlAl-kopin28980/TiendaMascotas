public class Medicina {
    private int contenido;
    public Medicina(int miligramos){
        contenido=miligramos;
    }
    public void usar(int dosis){
        contenido=contenido-dosis;
    }
    public int getContenido(){
        return contenido;
    }
}
