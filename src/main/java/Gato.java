public class Gato extends MascotaDomestica{
    public Gato(TipoColor pelito){
        super(pelito);
    }
    public void jugar(){
        if(felicidad<=93){
            felicidad=felicidad+7;}
        else{felicidad=100;}
    }
    public void alimentar(){
        if (hambre>=8){
            hambre=hambre-8;
        }
        else{
            hambre=0;
        }
    }
}
