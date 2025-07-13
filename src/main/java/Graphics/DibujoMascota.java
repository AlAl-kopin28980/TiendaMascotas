package Graphics;


import Logica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Dibujo que representa a una Mascota
 */
public class DibujoMascota extends JComponent {
    private int h,w;
    private BufferedImage image;
    private boolean active=true;
    private Mascota me;

    private DibujoHabitat miHabitat = null;

    /**
     * Inicia la posicion de la Imagen y que Imagen usar
     * @param x
     * @param y
     * @param w
     * @param h
     * @param me Mascota a representar
     */
    public DibujoMascota(int x, int y, int w, int h, Mascota me) {
        if (me!=null) {
            //hace que la Mascota tenga una referencia a su Dibujo
            //si no se quiere esto iniciar con Mascota null y luego usar setMascota
            //esto se usa para saber cual es el dibujo de la mascota que quiere el Comprador
            setMascota(me);
            me.setDibujo(this);
        }
        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }

    /**
     * Cambia la Mascota representada
     * @param me
     */
    public void setMascota(Mascota me){
        this.me=me;
        image = getImage(me);
    }

    /**
     * Devuelve la imagen que representa a una Mascota
     * @param tipo Mascota a representar
     * @return Imagen correspondiente
     */
    public static BufferedImage getImage(Mascota tipo){
        if (tipo instanceof Perro) {
            return switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("perro/naranjo");
                case BLANCO -> Sprites.GetSprite("perro/blanco");
                case NEGRO -> Sprites.GetSprite("perro/negro");
                case GRIS -> Sprites.GetSprite("perro/gris");
                case PATRON -> Sprites.GetSprite("perro/arcoiris");
            };
        } else if (tipo instanceof Gato) {
            return switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("gato/ramirez");
                case BLANCO -> Sprites.GetSprite("gato/blanco");
                case NEGRO -> Sprites.GetSprite("gato/negro");
                case GRIS -> Sprites.GetSprite("gato/gris");
                case PATRON -> Sprites.GetSprite("gato/nyan");
            };
        } else if (tipo instanceof Pez) {
            return switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("pez/naranjo");
                case BLANCO -> Sprites.GetSprite("pez/blanco");
                case NEGRO -> Sprites.GetSprite("pez/negro");
                case GRIS -> Sprites.GetSprite("pez/gris");
                case PATRON -> Sprites.GetSprite("pez/tropical");
            };
        } else if (tipo instanceof Ave) {
            return switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("ave/naranjo");
                case BLANCO -> Sprites.GetSprite("ave/blanco");
                case NEGRO -> Sprites.GetSprite("ave/miedo");
                case GRIS -> Sprites.GetSprite("ave/gris");
                case PATRON -> Sprites.GetSprite("ave/loro");
            };
        } else if (tipo instanceof Hamster) {
            return switch (tipo.getColor()) {
                case NARANJA -> Sprites.GetSprite("hamster/naranjo");
                case BLANCO -> Sprites.GetSprite("hamster/blanco");
                case NEGRO -> Sprites.GetSprite("hamster/negro");
                case GRIS -> Sprites.GetSprite("hamster/gris");
                case PATRON -> Sprites.GetSprite("hamster/kawaii");
            };
        } else{
            return null;
        }
    }

    /**
     * Establece una referencia a un DibujoHabitat
     * @param hogar DibujoHabitat a referencia
     */
    public void EntrarEn(DibujoHabitat hogar){
        miHabitat = hogar;
    }

    /**
     * Saca a la mascota de DibujoHabitat donde esta
     */
    public void Salir(){
        if (miHabitat!=null) {
            miHabitat.sacarMascota(this);

            miHabitat.revalidate();
            miHabitat.repaint();

            miHabitat = null;
        }
    }

    /**
     * Muestra la Imagen
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null && active) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
    }

    /**
     * Devuelve la Mascota representada
     * @return
     */
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