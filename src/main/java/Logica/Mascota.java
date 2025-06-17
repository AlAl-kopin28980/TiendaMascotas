package Logica;

import Logica.Insumos.Insumo;

public abstract class Mascota {
   protected int salud;
   protected int felicidad;
   protected int hambre;
   protected TipoColor color;
   public Mascota(TipoColor color){
        salud=0;
        felicidad=0;
        hambre=0;
        this.color=color;
   }
   public abstract void jugar();

   public Mascota vender(){return this;}
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
}
