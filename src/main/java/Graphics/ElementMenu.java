package Graphics;

import Logica.Habitat;
import Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ElementMenu extends JPanel implements MouseListener {
    ElementMenuCall parent;

    int x, y, w, h;
    int columns;

    ArrayList options;
    ArrayList<BufferedImage> images;

    public ElementMenu(ElementMenuCall parent, ArrayList options, int columns) {
        super();

        x = 0;
        y = 0;
        w = Ventana.getInstance().getWidth();
        h = Ventana.getInstance().getHeight();
        this.setBounds(x, y, w, h);
        this.setOpaque(true);
        this.setBackground(Color.ORANGE);

        this.parent = parent;
        this.options = options;
        this.columns = columns;

        this.images = new ArrayList<>();

        // Aquí deberías cargar la imagen de cada objeto.
        for (Object obj : options) {
            images.add(getImage(obj));
        }

        addMouseListener(this);
    }

    private BufferedImage getImage(Object obj) {
        if (obj instanceof Mascota){
            return DibujoMascota.getImage((Mascota) obj);
        } else if (obj instanceof Habitat) {
            return Sprites.GetSprite("jaula");
        }else{
            return null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            int imageSize = w / columns;
            for (int i = 0; i < images.size(); i++) {
                int col = i % columns;
                int row = i / columns;

                int imgX = col * imageSize;
                int imgY = row * imageSize;

                if (mouseX >= imgX && mouseX < imgX + imageSize &&
                        mouseY >= imgY && mouseY < imgY + imageSize) {
                    parent.CallBackElement(options.get(i));
                    break;
                }
            }
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int imageSize = w / columns;
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i) != null) {
                int col = i % columns;
                int row = i / columns;

                int imgX = col * imageSize;
                int imgY = row * imageSize;

                g2d.drawImage(images.get(i), imgX, imgY, imageSize, imageSize, this);
            }
        }
    }
}