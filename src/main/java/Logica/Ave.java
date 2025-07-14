package Logica;

public class Ave extends Mascota{
    /**
     *
     * @param salud salud con que el ave es creada
     * @param felicidad con la que el ave es creada
     * @param hambre con la que el ave es creada
     * @param color con el que el ave es creada
     */
    public Ave(int salud,int felicidad,int hambre,TipoColor color){
        super(salud,felicidad,hambre,color,1000);
    }

    /** al jugar la felicidad del ave aumenta, pero también le da hambre
     */
    public void jugar(){
        if(felicidad<=95){
        felicidad=felicidad+5;}
        else{felicidad=100;}
        if (hambre<100){hambre++;}
    }
    @Override
    public String toString(){
        return "Ave "+super.toString();
    }
}
