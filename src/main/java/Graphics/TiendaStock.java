package Graphics;

import Logica.*;
import Logica.Insumos.Insumo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public final class TiendaStock extends Scene implements ElementMenuCall{
    private static TiendaStock tienda= null;
    private Tienda inventario;
    private ArrayList<Mascota> perros, gatos, aves, hamsters, peces;
    private ArrayList<Habitat> peceras, jaulas, jaulaspajaro;
    private ArrayList<Insumo> comida, medicina, comidaenhanced;
    private ElementMenu menu;

    Ventana window;

    private final ArrayList<String> tipos=new ArrayList<String>(Arrays.asList("Insumos","Mascotas","Habitats"));  //tengo que arreglar los tipos para el getImage
    private final ArrayList<String> insumos=new ArrayList<String>(Arrays.asList("Comida","Medicina","HyperComida"));
    private final ArrayList<String> mascotas=new ArrayList<String>(Arrays.asList("Perros","Gatos","Hamsters","Aves","Peces"));
    private final ArrayList<String> habitats=new ArrayList<String>(Arrays.asList("Peceras","Jaulas","JaulasPajaro"));

    public static TiendaStock getTiendaStock(){
        if (tienda==null){
            tienda=new TiendaStock();
        }
        return tienda;
    }

    private TiendaStock(){
        super(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.window=Ventana.getInstance();

        inventario= Tienda.getTienda();
        perros=inventario.getPerros();
        gatos=inventario.getGatos();
        hamsters=inventario.getHamsters();
        peces=inventario.getPeces();
        aves=inventario.getAves();
        peceras=inventario.getPeceras();
        jaulas=inventario.getJaulas();
        jaulaspajaro=inventario.getJaulaspajaro();
        medicina=inventario.getMedicina();
        comida=inventario.getComida();
        comidaenhanced=inventario.getComidaenhanced();


        menu=new ElementMenu(this,tipos,3,"¿Qué desea comprar?"); //arreglar tipos
        this.add(menu,0);
    }

    public void whenClick(MouseEvent e){
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }

    @Override
    public void CallBackElement(Object option) {
        this.remove(menu);
        activeInput(true);

        if (option=="Insumos"){
            menu=new ElementMenu(this,insumos,3,"¿Qué tipo de insumo desea?");
        }
        if (option=="Medicina"){
            menu=new ElementMenu(this,medicina,3,"¿Qué tipo de medicina desea?");
        }
        if ((option instanceof Insumo) && ((Insumo) option).getNombre()=="medicina"){
            inventario.ComprarMedicina((Insumo)option);
        }
        if (option=="Comida"){
            menu=new ElementMenu(this,comida,3,"¿Qué tipo de comida desea?");
        }
        if ((option instanceof Insumo) && ((Insumo) option).getNombre()=="comida"){
            inventario.ComprarComida((Insumo)option);
        }
        if (option=="HyperComida"){
            menu=new ElementMenu(this,comidaenhanced,3,"¿Qué tipo de hypercomida desea?");
        }
        if ((option instanceof Insumo) && ((Insumo) option).getNombre().equals("comida-mejorada")){
            inventario.ComprarSuperComida((Insumo)option);
        }


        if (option=="Mascotas"){
            menu=new ElementMenu(this,mascotas,5,"¿Qué tipo de mascota desea?");
        }
        if (option=="Perros"){
            menu=new ElementMenu(this,perros,3,"¿Qué tipo de perro desea?");
        }
        if ((option instanceof Perro)){
            inventario.ComprarPerro((Mascota)option);
        }
        if (option=="Gatos"){
            menu=new ElementMenu(this,gatos,3,"¿Qué tipo de gato desea?");
        }
        if ((option instanceof Gato)){
            inventario.ComprarGato((Mascota)option);
        }
        if (option=="Hamsters"){
            menu=new ElementMenu(this,hamsters,3,"¿Qué tipo de hamster desea?");
        }
        if ((option instanceof Hamster)){
            inventario.ComprarHamster((Mascota)option);
        }
        if (option=="Aves"){
            menu=new ElementMenu(this,aves,3,"¿Qué tipo de ave desea?");
        }
        if ((option instanceof Ave)){
            inventario.ComprarAves((Mascota)option);
        }
        if (option=="Peces"){
            menu=new ElementMenu(this,peces,3,"¿Qué tipo de pez desea?");
        }
        if ((option instanceof Pez)){
            inventario.ComprarPeces((Mascota)option);
        }


        if (option=="Habitats"){
            menu=new ElementMenu(this,habitats,3,"¿Qué tipo de habitat desea?");
        }
        if (option=="Peceras"){
            menu=new ElementMenu(this,peceras,3,"¿Qué tipo de pecera desea?");
        }
        if ((option instanceof Pecera)){
            inventario.ComprarPecera((Habitat)option);
        }
        if (option=="Jaulas"){
            menu=new ElementMenu(this,jaulas,3,"¿Qué tipo de jaula desea?");
        }
        if ((option instanceof Jaula)){
            inventario.ComprarJaula((Habitat)option);
        }
        if (option=="JaulasPajaro"){
            menu=new ElementMenu(this,jaulaspajaro,3,"¿Qué tipo de jaula para pájaros desea?");
        }
        if ((option instanceof JaulaPajaro)){
            inventario.ComprarJaulaPajaro((Habitat)option);
        }
        //Jugador.getJugador().showInventario();
        //System.out.println("   ");
        this.add(menu,0);
        this.revalidate();
        this.repaint();
    }
}
