package Logica;

public class Gato extends MascotaDomestica {
    public Gato(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color);
    }
    public void jugar(){
        if(felicidad<=93){
            felicidad=felicidad+7;}
        else{felicidad=100;}
    }
}
