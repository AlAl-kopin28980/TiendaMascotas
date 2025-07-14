package Logica;

public class Ave extends Mascota{
    public Ave(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1000);
    }
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
        if (hambre<100){hambre++;}
    }
    @Override
    public String toString(){
        return "Ave "+super.toString();
    }
}
