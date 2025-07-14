package Logica;

public class Hamster extends MascotaTerrestre {
    /**
     *
     * @param salud con la que el hamster es creado
     * @param felicidad con la que el hamster es creado
     * @param hambre con la que el hamster es creado
     * @param color del hamster
     */
    public Hamster(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,900);
    }

    /**
     * la felicidad y el hambre del hamster aumentan al jugar con este
     */
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
        if (hambre<=95){hambre+=5;}
        else{hambre=100;}
    }
    @Override
    public String toString(){
        return "Hamster "+super.toString();
    }
}
