package Logica;

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
               felicidad--;
               salud--;
               hambre++;

           }
       };

       timer.scheduleAtFixedRate(task, 0, 2000);
   }

   public abstract void jugar();

    public void consumir(Insumo con){
       con.consumir(this);
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
}
