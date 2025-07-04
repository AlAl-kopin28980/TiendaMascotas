package Graphics;

import Logica.Cliente;
import Logica.Jugador;
import Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DibujoComprador extends JPanel {
    private int x,y,h,w;
    private BufferedImage image;
    private BufferedImage globo;
    private Cliente me = null;

    private DibujoMascota mascotaelegida;

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

    public void EntrarCliente(){
        me = new Cliente();
        Mascota elegida = me.elegirMascota();
        if (elegida!=null) {
            image = Sprites.GetSprite("puerta_abierta_persona");
            mascotaelegida.setMascota(elegida);
            this.revalidate();
            this.repaint();
        }else SalirCliente();
    }

    public void SalirCliente(){
        me.Salir();
        image = Sprites.GetSprite("puerta_cerrada");
        mascotaelegida.setMascota(null);
        me = null;

        this.revalidate();
        this.repaint();
    }

    public void AceptarCompra(){
        me.Comprar();
        mascotaelegida.getMe().getDibujo().Salir();
        MoneyCount.getInstance().revalidate();
        MoneyCount.getInstance().repaint();
        SalirCliente();
    }

    public void whenClick(MouseEvent e) {
        int relx = e.getX()-x;
        int rely = e.getY()-y;

        if (e.getButton()==1 && relx>=0 && relx<=w && rely>=0 && rely<=h) {
            if (me == null)
                EntrarCliente();
            else
                AceptarCompra();
        }
    }

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
}
