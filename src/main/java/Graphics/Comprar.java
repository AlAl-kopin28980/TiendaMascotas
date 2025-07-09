package Graphics;

import Logica.Tienda;

import java.awt.*;
import java.awt.event.MouseEvent;

public final class Comprar extends Scene implements OptionCall, ElementMenuCall {
    Tienda tienda = Tienda.getTienda();

    static Comprar instance = null;
    //OptionMenu
    Option mascotas = new Option(this,"Mascotas",300, 320,100,50,Color.red);
    Option comida = new Option(this,"Comida",600, 320,100,50,Color.BLUE);
    private ElementMenu objectmenu;
    public static Comprar getInstance(){
        if (instance!=null)
            return instance;
        else
            instance = new Comprar();
        return instance;
    }
    private Comprar() {
        super(Color.cyan);

        this.setLayout(null);

        this.add(mascotas);
        this.add(comida);
    }

    @Override
    public void whenClick(MouseEvent e) {

    }

    @Override
    public void CallBack(String option) {
        this.remove(mascotas);
        this.remove(comida);

        //objectmenu = new ElementMenu(this,tienda.ge(),6,"Comprar Mascota");

        this.revalidate();
        this.repaint();
    }

    @Override
    public void CallBackElement(Object option) {

    }
}
