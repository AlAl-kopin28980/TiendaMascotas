package Graphics;


import Logica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DibujoMascota extends JComponent {
    private int h,w;
    private BufferedImage image;
    private boolean active=true;
    private Mascota me;

    private DibujoHabitat miHabitat = null;

    public DibujoMascota(int x, int y, int w, int h, Mascota me) {
        if (me!=null) {
            setImage(me);
            me.setDibujo(this);
        }
        this.me=me;
        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }

    public void setMascota(Mascota me){
        this.me=me;
        setImage(me);
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
        } else if (tipo instanceof Pez) {
            image = switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("pez/naranjo");
                case BLANCO -> Sprites.GetSprite("pez/blanco");
                case NEGRO -> Sprites.GetSprite("pez/negro");
                case GRIS -> Sprites.GetSprite("pez/gris");
                case PATRON -> Sprites.GetSprite("pez/tropical");
            };
        } else if (tipo instanceof Ave) {
            image = switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("ave/naranjo");
                case BLANCO -> Sprites.GetSprite("ave/blanco");
                case NEGRO -> Sprites.GetSprite("ave/miedo");
                case GRIS -> Sprites.GetSprite("ave/gris");
                case PATRON -> Sprites.GetSprite("ave/loro");
            };
        } else if (tipo instanceof Hamster) {
            image = switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("hamster/naranjo");
                case BLANCO -> Sprites.GetSprite("hamster/blanco");
                case NEGRO -> Sprites.GetSprite("hamster/negro");
                case GRIS -> Sprites.GetSprite("hamster/gris");
                case PATRON -> Sprites.GetSprite("hamster/kawaii");
            };
        } else{
            image = null;
        }
    }

    public void EntrarEn(DibujoHabitat hogar){
        miHabitat = hogar;
    }
    public void Salir(){
        miHabitat.sacarMascota(this);

        miHabitat.revalidate();
        miHabitat.repaint();

        miHabitat = null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null && active) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
    }

    public Mascota getMe() {
        return me;
    }

    /**
     *
     * @param active si es activo el elemento se hace visible
     */
    public void setActive(boolean active){
        this.active=active;
    }
}