package Graphics;


import Logica.Habitat;
import Logica.Mascota;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class DibujoHabitat extends JPanel {
    protected int h,w;
    protected BufferedImage image;
    private boolean active=true;
    private Habitat me;
    ArrayList<DibujoMascota> mascotas;

    public DibujoHabitat(int x, int y, int w, int h, Habitat me) {
        try {
            image= ImageIO.read(new File("src/main/resources/jaula.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.me=me;
        mascotas=new ArrayList<>();

        //this.setLayout(null);
        this.setLayout(new GridLayout(1,me.getSize()));

        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }
    /*
    public void setImage(int type){
        try {
            if(type==1){image = ImageIO.read(new File("src/main/resources/Coca.png"));}
            else if(type==2){image = ImageIO.read(new File("src/main/resources/Sprite.png"));}
            else if(type==3){image = ImageIO.read(new File("src/main/resources/Fanta.png"));}
            else if(type==4){image = ImageIO.read(new File("src/main/resources/Super8.png"));}
            else if(type==5){image = ImageIO.read(new File("src/main/resources/Snickers.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public void addMascota(Mascota mascota){
        me.addMascota(mascota);
        int wm = w/me.getSize();
        DibujoMascota dibumascota = new DibujoMascota(10,10,wm-10,wm-10,mascota);
        mascotas.add(dibumascota);
        this.add(dibumascota);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null && active) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
    }

    /**
     *
     * @param active si es activo el elemento se hace visible
     */
    public void setActive(boolean active){
        this.active=active;
    }
}