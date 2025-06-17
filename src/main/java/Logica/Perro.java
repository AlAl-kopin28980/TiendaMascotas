package Logica;

public class Perro extends MascotaDomestica {
    public Perro(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
}
