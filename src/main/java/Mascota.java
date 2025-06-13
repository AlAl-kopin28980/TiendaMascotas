public abstract class Mascota {
   protected int salud;
   protected int felicidad;
   protected int hambre;
   protected TipoColor color;
   public Mascota(TipoColor color){
        salud=0;
        felicidad=0;
        hambre=100;
        this.color=color;
   }
   public abstract void jugar();
   public abstract void alimentar();
   public Mascota vender(){return this;}
    public void darMedicina(Medicina med){
        if(salud<100 && med.getContenido()>0) {
            int aux=salud;
            if((100-salud)<=med.getContenido()) {
                salud =100;
            }
            else{
                salud=salud+med.getContenido();
            }
            med.usar(salud - aux);
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

    public TipoColor getColor(){
        return color;
    }
}
