package Logica;

public abstract class Mascota {
   protected int salud;
   protected int felicidad;
   protected int hambre;
   protected TipoColor color;
   protected int precio;
   protected int tope;
   public Mascota(int salud,int felicidad,int hambre,TipoColor color,int tope){
        this.salud=salud;
        this.felicidad=felicidad;
        this.hambre=hambre;
        this.color=color;
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        this.tope=tope;
   }
   public abstract void jugar();
   public abstract void alimentar(BolsaAlimento food);


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

    public int getPrecio(){
        precio=(int)(tope*color.getPrecio())-hambre-200+felicidad+salud;
        return precio;}

    public Mascota vender(){return this;}
}
