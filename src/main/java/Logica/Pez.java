package Logica;

public class Pez extends MascotaExotica {
    public Pez(TipoColor color){
        super(color);
    }
    public void jugar(){
        if(felicidad<=80){
            felicidad=felicidad+20;}
        else{felicidad=100;}
    }
    public void alimentar(){
        if (hambre>=20){
            hambre=hambre-20;
        }
        else{
            hambre=0;
        }
    }
}
