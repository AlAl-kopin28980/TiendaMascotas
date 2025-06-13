public class Ave extends MascotaExotica{
    public Ave(){
        super();
    }
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
    }
    public void alimentar(){
        if (hambre>=5){
            hambre=hambre-5;
        }
        else{
            hambre=0;
        }
    }
}
