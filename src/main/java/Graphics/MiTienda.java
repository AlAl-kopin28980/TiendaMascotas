package Graphics;

import Logica.*;

import java.awt.*;
import java.util.ArrayList;

public class MiTienda extends Scene{
    ArrayList<DibujoHabitat> habitats;

    Ventana window;
    public MiTienda(){
        super(Color.DARK_GRAY);
        this.setLayout(null);
        this.window=Ventana.getInstance();

        habitats = new ArrayList<>();
        DibujoHabitat dibu1=new DibujoHabitat(100,300,200,100,new Jaula(100,2));
        habitats.add(dibu1);
        this.add(dibu1);
        DibujoHabitat dibu2=new DibujoHabitat(100,200,200,100,new Jaula(100,2));
        habitats.add(dibu2);
        this.add(dibu2);
        DibujoHabitat dibu3=new DibujoHabitat(100,100,200,100,new Jaula(100,2));
        habitats.add(dibu3);
        this.add(dibu3);
        Perro p = new Perro(60,50,0, TipoColor.NARANJA);
        Perro q = new Perro(60,50,0, TipoColor.BLANCO);
        dibu1.addMascota(p);
        dibu1.addMascota(q);
        Perro p2 = new Perro(60,50,0, TipoColor.NEGRO);
        Perro q2 = new Perro(60,50,0, TipoColor.GRIS);
        dibu2.addMascota(p2);
        dibu2.addMascota(q2);
        Perro p3 = new Perro(60,50,0, TipoColor.PATRON);
        dibu3.addMascota(p3);

        this.add(new MoneyCount(10,10,100,50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }
}
