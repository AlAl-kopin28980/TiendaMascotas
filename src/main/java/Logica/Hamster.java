package Logica;

public class Hamster extends MascotaExotica {
    public Hamster(TipoColor color){
        super(color);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
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
