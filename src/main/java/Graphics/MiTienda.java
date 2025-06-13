package Graphics;

import java.awt.*;
import java.util.ArrayList;

public class MiTienda extends Scene{
    ArrayList<DibujoMascota> mascotas;
    Ventana window;
    public MiTienda(Ventana window){
        super(Color.DARK_GRAY);
        this.setLayout(null);
        this.window=window;

        mascotas = new ArrayList<>();
        addMascota(300,300,60,60);
        addMascota(100,350,60,60);
        addMascota(450,320,60,60);

        this.add(new MoneyCount(10,10,100,50,100));
    }

    public void addMascota(int x, int y, int w, int h){
        DibujoMascota mascota = new DibujoMascota(x,y,w,h,0);
        mascotas.add(mascota);
        this.add(mascota);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }
}
