package Graphics;


import Logica.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Dibujo que representa a un Habitat
 */
public class DibujoHabitat extends JPanel {
    protected int x,y,h,w;
    protected BufferedImage image;
    private boolean active=true;
    private Habitat me;
    ArrayList<DibujoMascota> mascotas;

    /**
     * Inicia DibujoHabitat
     * @param x
     * @param y
     * @param w
     * @param h
     * @param me Habitat que imitar
     */
    public DibujoHabitat(int x, int y, int w, int h, Habitat me) {
        image=getImage(me);
        me.setDibujoHabitat(this);
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

    /**
     * se actualiza la imagen del habitat
     */
    public void updateImage(){
        image=getImage(me);
        this.revalidate();
        this.repaint();
    }

    /**
     * Obtiene la imagen que corresponde al tipo de Habitat
     * @param tipo Habitat a representar
     * @return Imagen correspondiente
     */
    public static BufferedImage getImage(Habitat tipo) {
        if (tipo instanceof Jaula) {
            if(tipo.getLimpieza()>70) return Sprites.GetSprite("jaula1");
            else return Sprites.GetSprite("jaulasucia");
        } else if (tipo instanceof JaulaPajaro) {
            if(tipo.getLimpieza()>70) return Sprites.GetSprite("birdycage");
            else return Sprites.GetSprite("birdcagesucia");
        } else if (tipo instanceof Pecera) {
            if(tipo.getLimpieza()>70) return Sprites.GetSprite("peceraa");
            else return Sprites.GetSprite("pecerasucia");
        }
        return null;
    }

    /**
     * Añade una Mascota al Habitat
     * y crea un DibujoMascota para ella
     * @param mascota
     */
    public void addMascota(Mascota mascota){
        me.addMascota(mascota);
        int wm = w/me.getSize();
        DibujoMascota dibumascota = new DibujoMascota(0,0,wm,wm,mascota);
        dibumascota.EntrarEn(this);
        mascotas.add(dibumascota);
        this.add(dibumascota);

        this.revalidate();
        this.repaint();
        System.out.println("dentro "+mascota);
    }

    /**
     * Saca a una Mascota del Habitat
     * @param mascota
     */
    public void sacarMascota(DibujoMascota mascota){
        me.sacarMascota(mascota.getMe());
        mascotas.remove(mascota);
        this.remove(mascota);
    }

    /**
     * Devuelve la lista de DibujoMascota contenidos
     * @return
     */
    public ArrayList<DibujoMascota> getMascotas(){
        return mascotas;
    }

    /**
     * Limpia el Habitat
     */
    public void limpiarHabitat() {
        me.limpiarHabitat();
        updateImage();
    }

    /**
     * Dibuja la imagen
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
     * Devuelve el Habitat representado
     * @return
     */
    public Habitat getMe() {
        return me;
    }

    /**
     *
     * @param active si es activo el elemento se hace visible
     */
    public void setActive(boolean active){
        this.active=active;
    }

    /**
     * Al clickear llama a que se muestre el menu de opciones en MiTienda
     * @param e
     */
    public void whenClick(MouseEvent e) {
        int relx = e.getX()-x;
        int rely = e.getY()-y;

        if (e.getButton()==1 && relx>=0 && relx<=w && rely>=0 && rely<=h) {
            MiTienda.getInstance().mostrarMenu(this);
        }
    }
}