package Logica;

public class Perro extends MascotaDomestica {
    public Perro(TipoColor pelito){
        super(pelito);
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
    public void alimentar(BolsaAlimento food){
        if (hambre>=8){
            hambre=hambre-food.sacarAlimento(8);
        }
        else{
            int minus=food.sacarAlimento(hambre);
            hambre=hambre-minus;
        }
    }
}
