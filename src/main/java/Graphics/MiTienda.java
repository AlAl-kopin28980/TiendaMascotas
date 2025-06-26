package Graphics;

import Logica.*;

import java.awt.*;
import java.util.ArrayList;

public class MiTienda extends Scene{
    ArrayList<DibujoHabitat> habitats;

    Ventana window;
    public MiTienda(Ventana window){
        super(Color.DARK_GRAY);
        this.setLayout(null);
        this.window=window;

        habitats = new ArrayList<>();
        Jaula habitat = new Jaula(100,2);
        DibujoHabitat dibu=new DibujoHabitat(250,300,200,100,habitat);
        habitats.add(dibu);
        this.add(dibu);
        Perro p = new Perro(60,50,0, TipoColor.NEGRO);
        dibu.addMascota(p);
        dibu.addMascota(p);

        this.add(new MoneyCount(10,10,100,50,100));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }
}
