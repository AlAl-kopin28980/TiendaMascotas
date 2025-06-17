package Logica;

public class Pez extends MascotaExotica {
    public Pez(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,500);
    }
    public void jugar(){
        if(felicidad<=80){
            felicidad=felicidad+20;}
        else{felicidad=100;}
    }
    public void alimentar(BolsaAlimento food){
        if (hambre>=20){
            hambre=hambre-food.sacarAlimento(20);
        }
        else{
            int minus=food.sacarAlimento(hambre);
            hambre=hambre-minus;
        }
    }
}
