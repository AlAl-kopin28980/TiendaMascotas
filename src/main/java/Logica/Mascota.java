package Logica;

import Graphics.DibujoMascota;
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
   public Mascota(int salud,int felicidad,int hambre,TipoColor color,int tope){
        this.salud=salud;
        this.felicidad=felicidad;
        this.hambre=hambre;
        this.color=color;
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        this.tope=tope;
        this.startTimer();
   }
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

    public void consumir(Insumo con){
       con.consumir(this);
    }

    public void EntrarEn(Habitat hogar){
        miHabitat = hogar;
    }
    public void Salir(){
        miHabitat = null;
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

    public int getPrecio(){
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        return precio;}

    public Mascota vender(){return this;}

    public String toString(){
        String string="Color: "+color+" - Precio: $"+this.getPrecio();
        return string;
    }
    public String toStringExtended(){
        String string=this.toString()+"\nHambre: "+hambre+"\nFelicidad: "+felicidad+"\nSalud: "+salud;
        return string;
    }

    public void setDibujo(DibujoMascota miDibujo) {
        this.miDibujo = miDibujo;
    }
    public DibujoMascota getDibujo() {
        return miDibujo;
    }

    public Habitat getHabitat() {return miHabitat;}
}
