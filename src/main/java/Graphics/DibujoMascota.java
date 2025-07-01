package Graphics;


import Logica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DibujoMascota extends JComponent {
    protected int h,w;
    protected BufferedImage image;
    private boolean active=true;
    private Mascota me;

    public DibujoMascota(int x, int y, int w, int h, Mascota me) {
        setImage(me);
        this.me=me;
        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }

    public void setImage(Mascota tipo){
        if (tipo instanceof Perro) {
            image = switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("perro/naranjo");
                case BLANCO -> Sprites.GetSprite("perro/blanco");
                case NEGRO -> Sprites.GetSprite("perro/negro");
                case GRIS -> Sprites.GetSprite("perro/gris");
                case PATRON -> Sprites.GetSprite("perro/arcoiris");
            };
        } else if (tipo instanceof Gato) {
            image = switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("gato/ramirez");
                case BLANCO -> Sprites.GetSprite("gato/blanco");
                case NEGRO -> Sprites.GetSprite("gato/negro");
                case GRIS -> Sprites.GetSprite("gato/gris");
                case PATRON -> Sprites.GetSprite("gato/nyan");
            };
        }
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