package Graphics;


import Logica.Habitat;
import Logica.Mascota;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class DibujoHabitat extends JPanel {
    protected int x,y,h,w;
    protected BufferedImage image;
    private boolean active=true;
    private Habitat me;
    ArrayList<DibujoMascota> mascotas;

    public DibujoHabitat(int x, int y, int w, int h, Habitat me) {
        image=Sprites.GetSprite("jaula");

        this.me=me;
        mascotas=new ArrayList<>();

        this.setOpaque(false);
        this.setLayout(new GridLayout(1,me.getSize()));

        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }

    public void addMascota(Mascota mascota){
        me.addMascota(mascota);
        int wm = w/me.getSize();
        DibujoMascota dibumascota = new DibujoMascota(0,0,wm,wm,mascota);
        dibumascota.EntrarEn(this);
        mascotas.add(dibumascota);
        this.add(dibumascota);
    }

    public void sacarMascota(DibujoMascota mascota){
        me.sacarMascota(mascota.getMe());
        mascotas.remove(mascota);
        this.remove(mascota);
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

    public void whenClick(MouseEvent e) {
        int relx = e.getX()-x;
        int rely = e.getY()-y;

        if (e.getButton()==1 && relx>=0 && relx<=w && rely>=0 && rely<=h) {
            MiTienda.getInstance().mostrarMenu(me);
        }
    }
}