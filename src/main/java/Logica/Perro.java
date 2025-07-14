package Logica;

public class Perro extends MascotaTerrestre {
    /**
     *
     * @param salud con la que el perro es creado
     * @param felicidad con la que el perro es creado
     * @param hambre con la que el perro es creado
     * @param color del perro
     */
    public Perro(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,2000);
    }

    /**
     * se juega con el perro para aumentar su felicidad (y hambre)
     */
    public void jugar(){
        if(felicidad<=90){
            felicidad=felicidad+10;}
        else{felicidad=100;}
        if (hambre<=96){hambre+=4;}
        else{hambre=100;}
    }
    @Override
    public String toString(){
        return "Perro "+super.toString();
    }
}
