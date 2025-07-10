package Logica;

public class Ave extends MascotaExotica {
    public Ave(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1000);
    }
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
    }
    @Override
    public String toString(){
        return "Ave "+super.toString();
    }
}
