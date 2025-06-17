package Logica;

public abstract class Mascota {
   protected int salud;
   protected int felicidad;
   protected int hambre;
   protected TipoColor color;
   public Mascota(int salud,int felicidad,int hambre,TipoColor color){
        this.salud=salud;
        this.felicidad=felicidad;
        this.hambre=hambre;
        this.color=color;
   }
   public abstract void jugar();
   public abstract void alimentar(BolsaAlimento food);
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
