package Logica;

public class Pez extends Mascota {
    /**
     *
     * @param salud con la que el pez es creado
     * @param felicidad con la que el pez es creado
     * @param hambre con la que el pez es creado
     * @param color con la que el pez es creado
     */
    public Pez(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,500);
    }

    /**
     * al jugar con el pez su felicidad y hambre aumentan
     */
    public void jugar(){
        if(felicidad<=80){
            felicidad=felicidad+20;}
        else{felicidad=100;}
        if (hambre<=92){hambre+=8;}
        else{hambre=100;}
    }
    @Override
    public String toString(){
        return "Pez "+super.toString();
    }
}
