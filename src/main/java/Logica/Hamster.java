package Logica;

public class Hamster extends MascotaTerrestre {
    public Hamster(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,900);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
}
