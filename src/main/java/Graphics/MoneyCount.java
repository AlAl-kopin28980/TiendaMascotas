package Graphics;

import Logica.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Muestra cuanto dinero tiene el Jugador
 */
public class MoneyCount extends JComponent {
    private JLabel texto=new JLabel("inicio");
    private BufferedImage image;
    private int x,y,w,h;

    private static MoneyCount instance = null;

    /**
     * Inicia el contador
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public MoneyCount(int x, int y, int w, int h){
        this.setLayout(null);
        this.setBounds(x,y,w,h);
        this.add(texto);

        texto.setFont(new Font("Arial",Font.PLAIN,28));

        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;

        image=Sprites.GetSprite("moneda");
    }

    /**
     * Muestra el dinero como texto y una moneda
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.white);
        g.fillRect(0,0,w,h);

        if (image != null) {
            g2d.drawImage(image, 3, 3, 44, 44, this);
        }

        texto.setText("$"+ Jugador.getJugador().getPresupuesto());
        texto.setBounds(49,0,w-44,h);
        texto.setForeground(Color.BLUE);
        texto.setOpaque(false);
    }
}
