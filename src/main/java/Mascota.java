public abstract class Mascota {
   protected int salud;
   protected float felicidad;
   protected float hambre;
   public Mascota(){
        salud=0;
        felicidad=0;
        hambre=100;
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
}
