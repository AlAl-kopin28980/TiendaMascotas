package Logica;

public class Perro extends MascotaTerrestre {
    public Perro(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,2000);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
    @Override
    public String toString(){
        return "Perro "+super.toString();
    }
}
