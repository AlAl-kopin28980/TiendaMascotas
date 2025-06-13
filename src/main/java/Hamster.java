public class Hamster extends MascotaExotica{
    public Hamster(){
        super();
    }
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
    }
    public void alimentar(){
        if (hambre>=10){
            hambre=hambre-10;
        }
        else{
            hambre=0;
        }
    }
}
