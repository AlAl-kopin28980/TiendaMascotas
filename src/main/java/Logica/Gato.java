package Logica;

public class Gato extends MascotaDomestica {
    public Gato(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1500);
    }
    public void jugar(){
        if(felicidad<=93){
            felicidad=felicidad+7;}
        else{felicidad=100;}
    }
    public void alimentar(BolsaAlimento food){
        if (hambre>=10){
            hambre=hambre-food.sacarAlimento(10);
        }
        else{
            int minus=food.sacarAlimento(hambre);
            hambre=hambre-minus;
        }
    }
}
