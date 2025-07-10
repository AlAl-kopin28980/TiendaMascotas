package Logica;

public class Pez extends MascotaExotica {
    public Pez(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,500);
    }
    public void jugar(){
        if(felicidad<=80){
            felicidad=felicidad+20;}
        else{felicidad=100;}
    }
    @Override
    public String toString(){
        return "Pez "+super.toString();
    }
}
