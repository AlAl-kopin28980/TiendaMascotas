package Logica;

import Graphics.DibujoMascota;
import Logica.Excepciones.HabitatLlenoException;
import Logica.Excepciones.TipoMascotaIncorrecto;
import Logica.Insumos.Insumo;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Mascota {
   protected int salud;
   protected int felicidad;
   protected int hambre;
   protected TipoColor color;
   protected int precio;
   protected int tope;

   protected Habitat miHabitat = null;

   protected DibujoMascota miDibujo = null;

   private Timer timer;

    /**
     *
     * @param salud con la que la mascota es creada
     * @param felicidad con la que la mascota es creada
     * @param hambre con la que la mascota es creada
     * @param color de la mascota
     * @param tope número con el que se calcula el precio máximo de la mascota
     */
   public Mascota(int salud,int felicidad,int hambre,TipoColor color,int tope){
        this.salud=salud;
        this.felicidad=felicidad;
        this.hambre=hambre;
        this.color=color;
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        this.tope=tope;
        this.startTimer();
   }

    /**
     * cada 4 segundos el hambre aumenta y la felicidad y salud disminuyen
     */
   private void startTimer(){
       timer = new Timer();
       TimerTask task = new TimerTask() {
           @Override
           public void run() {
               if(felicidad>=1)felicidad--;
               if(salud>=1)salud--;
               if(hambre<=99)hambre++;

           }
       };

       timer.scheduleAtFixedRate(task, 4000, 2000);
   }

    public abstract void jugar();

    /**
     * @param con insumo a consumir
     */
    public void consumir(Insumo con){
       con.consumir(this);
    }

    /**
     * @param hogar habitat al que la mascota está entrando
     */
    public void EntrarEn(Habitat hogar){
        try{
            if (!hogar.getMacotaList().contains(this)) {
                hogar.addMascota(this);
                miHabitat = hogar;
            }
        }
        catch(TipoMascotaIncorrecto | HabitatLlenoException w){
            System.out.println(w.getMessage());
        }
    }

    /**
     * mascota sale de su habitat
     */
    public void Salir(){
        if (miHabitat!=null){
            miHabitat.sacarMascota(this);
            miHabitat = null;
        }
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getSalud() {
        return salud;
    }

    public int getHambre() {
        return hambre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public TipoColor getColor(){
        return color;
    }

    /**
     * @return precio calculado en base a su color y "stats"
     */
    public int getPrecio(){
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        return precio;}

    public Mascota vender(){return this;}

    public String toString(){
        String string="Color: "+color+" - Precio: $"+this.getPrecio();
        return string;
    }

    /**
     * @return string que incluye "stats"
     */
    public String toStringExtended(){
        String string=this.toString()+"\nHambre: "+hambre+"\nFelicidad: "+felicidad+"\nSalud: "+salud;
        return string;
    }

    /**
     * @param miDibujo se le da una referencia a su dibujo de interfaz gráfica
     */
    public void setDibujo(DibujoMascota miDibujo) {
        this.miDibujo = miDibujo;
    }
    public DibujoMascota getDibujo() {
        return miDibujo;
    }

    public Habitat getHabitat() {return miHabitat;}
}
