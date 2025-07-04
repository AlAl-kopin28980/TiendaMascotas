package Graphics;

import Logica.Cliente;
import Logica.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DibujoComprador extends JPanel {
    private int h,w;
    private BufferedImage image;
    private BufferedImage globo;
    private Cliente me = null;

    private DibujoMascota mascotaelegida;

    public DibujoComprador(int x, int y, int w, int h) {
        image = Sprites.GetSprite("puerta_cerrada");
        globo = Sprites.GetSprite("globo_texto");
        this.me=me;
        this.w=w;
        this.h=h;

        this.setBounds(x,y,w,h);
        this.setOpaque(false);
        this.setLayout(null);

        mascotaelegida = new DibujoMascota(30,12,100,100,null);
        this.add(mascotaelegida);

        EntrarCliente();
        AceptarCompra();
    }

    public void EntrarCliente(){
        me = new Cliente();
        image = Sprites.GetSprite("puerta_abierta_persona");
        mascotaelegida.setMascota(me.elegirMascota());
    }

    public void SalirCliente(){
        me.Salir();
        image = Sprites.GetSprite("puerta_cerrada");
        mascotaelegida.setMascota(null);
        me = null;
    }

    public void AceptarCompra(){
        me.Comprar();
        mascotaelegida.getMe().getDibujo().Salir();
        SalirCliente();
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
