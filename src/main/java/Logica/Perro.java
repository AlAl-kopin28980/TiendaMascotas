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
}
