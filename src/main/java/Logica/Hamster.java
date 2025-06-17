package Logica;

public class Hamster extends MascotaExotica {
    public Hamster(TipoColor color){
        super(color);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
}
