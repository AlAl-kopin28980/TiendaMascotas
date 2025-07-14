package Logica;

/**
 * tipo de mascota que puede ser puesta en Jaula
 */
public abstract class MascotaTerrestre extends Mascota {
    public MascotaTerrestre(int salud,int felicidad,int hambre,TipoColor color,int tope){
        super(salud,felicidad,hambre,color,tope);
    }
}
