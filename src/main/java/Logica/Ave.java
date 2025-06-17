package Logica;

public class Ave extends MascotaExotica {
    public Ave(TipoColor color){
        super(color);
    }
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
    }
}
