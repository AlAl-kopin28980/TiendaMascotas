package Logica;

public class Gato extends MascotaTerrestre {
    /**
     *
     * @param salud salud del gato al crearlo
     * @param felicidad felicidad del gato al crearlo
     * @param hambre hambre del gato al crearlo
     * @param color del gato
     */
    public Gato(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1500);
    }

    /**
     * al jugar la felicidad y hambre del gato aumentan
     */
    public void jugar(){
        if(felicidad<=93){
            felicidad=felicidad+7;}
        else{felicidad=100;}
        if (hambre<=97){hambre+=3;}
        else{hambre=100;}
    }

    @Override
    public String toString(){
       return "Gato "+super.toString();
    }
}
