package Logica;

public class Gato extends MascotaTerrestre {
    public Gato(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1500);
    }
    public void jugar(){
        if(felicidad<=93){
            felicidad=felicidad+7;}
        else{felicidad=100;}
        if (hambre<=97){hambre+=3;}
        else{hambre=100;}
    }

    @Override
    public String toString(){
       return "Gato "+super.toString();
    }
}
