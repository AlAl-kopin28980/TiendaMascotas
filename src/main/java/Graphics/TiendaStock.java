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


    private final ArrayList<String> tipos=new ArrayList<String>(Arrays.asList("Insumos","Mascotas","Habitats"));  //tengo que arreglar los tipos para el getImage
    private final ArrayList<String> insumos=new ArrayList<String>(Arrays.asList("Comida","Medicina","HyperComida"));


    public static TiendaStock getTiendaStock(){
        if (tienda==null){
            tienda=new TiendaStock();
        }
        return tienda;
    }

    private TiendaStock(){
        super(Color.LIGHT_GRAY);
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
    }

    public void whenClick(MouseEvent e){}

    @Override
    public void CallBackElement(Object option) {
        if (option=="Insumos"){
            menu=new ElementMenu(this,insumos,3,"¿Qué tipo de insumo desea?");
        }
        else if (option=="Mascotas"){}
        else if (option=="Habitats"){}
        else if (option=="Medicina"){

        }
    }
}
