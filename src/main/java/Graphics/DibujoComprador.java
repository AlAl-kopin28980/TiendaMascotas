package Graphics;

import Logica.Cliente;
import Logica.Jugador;
import Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Muestra una puerta, al hacer click entra un comprador y permite aceptar o rechazar la compra
 */
public class DibujoComprador extends JPanel implements OptionCall {
    private int x,y,h,w;
    private BufferedImage image;
    private BufferedImage globo;
    private Cliente me = null;

    Option si = new Option(this,"Si",50,400,100,50,Color.green);
    Option no = new Option(this,"No",150,400,100,50,Color.red);

    private DibujoMascota mascotaelegida;

    /**
     * Inicia a DibujoComprador
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public DibujoComprador(int x, int y, int w, int h) {
        image = Sprites.GetSprite("puerta_cerrada");
        globo = Sprites.GetSprite("globo_texto");
        this.me=me;

        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;

        this.setBounds(x,y,w,h);
        this.setOpaque(false);
        this.setLayout(null);

        mascotaelegida = new DibujoMascota(30,12,100,100,null);
        this.add(mascotaelegida);
    }

    /**
     * Crea un Cliente, elige una mascota y añade el prompt para elegir
     */
    public void EntrarCliente(){
        me = new Cliente();
        Mascota elegida = me.elegirMascota();
        if (elegida!=null) {
            image = Sprites.GetSprite("puerta_abierta_persona");
            mascotaelegida.setMascota(elegida);

            this.add(si);
            this.add(no);
            MiTienda.getInstance().activeInput(false);

            this.revalidate();
            this.repaint();
        }else SalirCliente();
    }

    /**
     * Cierra la puerta y desctiva el prompt
     */
    public void SalirCliente(){
        me.Salir();
        image = Sprites.GetSprite("puerta_cerrada");
        mascotaelegida.setMascota(null);
        me = null;

        this.remove(si);
        this.remove(no);

        this.revalidate();
        this.repaint();
    }

    /**
     * Acepta la compra de la Mascota elegida
     */
    public void AceptarCompra(){
        me.Comprar();
        mascotaelegida.getMe().getDibujo().Salir();
        MiTienda.getInstance().getMoneyCount().revalidate();
        MiTienda.getInstance().getMoneyCount().repaint();
        SalirCliente();
    }

    /**
     * Al hacer click llama a EntrarCliente()
     * @param e
     */
    public void whenClick(MouseEvent e) {
        int relx = e.getX()-x;
        int rely = e.getY()-y;

        if (e.getButton()==1 && relx>=0 && relx<=w && rely>=0 && rely<=h) {
            if (me == null)
                EntrarCliente();
        }
    }

    /**
     * Dibuja las imagenes
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (image != null) {
            g2d.drawImage(image, 0, 0, w, h, this);
        }
        if (globo != null && me!=null) {
            g2d.drawImage(globo, 0, 0, 166, 156, this);
        }
    }

    /**
     * Toma la opcion elegida en el promt
     * Si es "Si" llama a AceptarCompra()
     * Si es "No" llama a SalirCliente()
     * @param option Opcion elegida
     */
    @Override
    public void CallBack(String option) {
        if (Objects.equals(option, "Si")){
            AceptarCompra();
        }else if (Objects.equals(option, "No")){
            SalirCliente();
        }
        MiTienda.getInstance().activeInput(true);
    }
}
