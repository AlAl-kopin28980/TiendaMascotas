public class Main {
    public static void main(String[] args){
        Mascota perrito=new Perro();
        Medicina med=new Medicina(150);
        perrito.darMedicina(med);
        System.out.println(med.getContenido());
    }
}
