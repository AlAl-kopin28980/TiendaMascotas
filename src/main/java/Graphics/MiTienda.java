package Graphics;

import Logica.*;
import Logica.Excepciones.DineroInsuficienteException;

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
        DibujoHabitat dibu2=new DibujoHabitat(100,200,200,100,new Pecera(100,2));
        habitats.add(dibu2);
        this.add(dibu2);
        DibujoHabitat dibu3=new DibujoHabitat(100,100,200,100,new JaulaPajaro(100,2));
        habitats.add(dibu3);
        this.add(dibu3);
        Hamster p = new Hamster(60,50,0, TipoColor.NARANJA);
        Gato q = new Gato(60,50,0, TipoColor.BLANCO);
        dibu1.addMascota(p);
        dibu1.addMascota(q);
        Pez p2 = new Pez(60,50,0, TipoColor.NEGRO);
        Pez q2 = new Pez(60,50,0, TipoColor.GRIS);
        dibu2.addMascota(p2);
        dibu2.addMascota(q2);
        Hamster p3 = new Hamster(60,50,0, TipoColor.PATRON);
        dibu3.addMascota(p3);
        try {
            Jugador.getJugador().comprarMascota(p);
            Jugador.getJugador().comprarMascota(q);
        } catch (DineroInsuficienteException e) {
            throw new RuntimeException(e);
        }

        //jugador
        this.add(new DibujoComprador(513,52,362,603));

        this.add(new MoneyCount(10,10,100,50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }
}
