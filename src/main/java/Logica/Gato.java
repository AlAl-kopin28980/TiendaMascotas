package Logica;

public class Gato extends MascotaDomestica {
    public Gato(TipoColor pelito){
        super(pelito);
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
