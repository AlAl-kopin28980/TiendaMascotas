package Logica;

public class Ave extends MascotaExotica {
    public Ave(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color);
    }
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
    }
    public void alimentar(BolsaAlimento food){
        if (hambre>=5){
            hambre=hambre-food.sacarAlimento(5);
        }
        else{
            int minus=food.sacarAlimento(hambre);
            hambre=hambre-minus;
        }
    }
}
