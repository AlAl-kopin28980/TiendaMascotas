package Graphics;

import Logica.Habitat;
import Logica.Insumos.Insumo;
import Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class ElementMenu extends JPanel implements MouseListener {
    ElementMenuCall parent;

    int x, y, w, h;
    int columns;

    ArrayList options;
    ArrayList<BufferedImage> images;

    public ElementMenu(ElementMenuCall parent, ArrayList options, int columns, String message) {
        super();

        x = 0;
        y = 0;
        w = Ventana.getInstance().getWidth();
        h = Ventana.getInstance().getHeight();
        this.setBounds(x, y, w, h);
        this.setOpaque(true);
        this.setBackground(Color.ORANGE);
        //text
        JLabel txt = new JLabel(message);
        txt.setBounds(w/2,h/2,100,20);
        txt.setBackground(Color.ORANGE);
        this.add(txt);

        this.parent = parent;
        this.options = options;
        this.columns = columns;

        this.images = new ArrayList<>();

        for (Object obj : options) {
            images.add(getImage(obj));
        }

        addMouseListener(this);
    }

    private BufferedImage getImage(Object obj) {
        if (obj instanceof Mascota){
            return DibujoMascota.getImage((Mascota) obj);
        } else if (obj instanceof Habitat) {
            return DibujoHabitat.getImage((Habitat) obj);
        }else if (obj instanceof Insumo){
            String name = ((Insumo) obj).getNombre();
            if (Objects.equals(name, "medicina")) {
                return Sprites.GetSprite("medicina");
            } else if (Objects.equals(name, "comida-mejorada")) {
                return Sprites.GetSprite("supercomida", "jpg");
            } else {
                return Sprites.GetSprite("comida", "jpg");
            }
        }else if (obj instanceof String){
           if(obj.equals("Perros")) {return Sprites.GetSprite("perros","jpeg");}
           else if(obj.equals("Gatos")) {return Sprites.GetSprite("gatos","jpg");}
           else if(obj.equals("Peces")) {return Sprites.GetSprite("peces","jpeg");}
           else if(obj.equals("Aves")) {return Sprites.GetSprite("aves","jpeg");}
           else if(obj.equals("Hamsters")) {return Sprites.GetSprite("hamsters","jpeg");}

           else if(obj.equals("Mascotas")) {return Sprites.GetSprite("mascotas","jpg");}
           else if(obj.equals("Insumos")) {return Sprites.GetSprite("insumos");}
           else if(obj.equals("Habitats")) {return Sprites.GetSprite("habitats","jpg");}

           else if(obj.equals("Peceras")) {return Sprites.GetSprite("pecera","jpg");}
           else if(obj.equals("Jaulas")) {return Sprites.GetSprite("jaula","jpg");}
           else if(obj.equals("JaulasPajaro")) {return Sprites.GetSprite("birdcage","jpg");}

           else if(obj.equals("Medicina")) {return Sprites.GetSprite("medicina");}
           else if(obj.equals("Comida")) {return Sprites.GetSprite("comida","jpg");}
           else if(obj.equals("HyperComida")) {return Sprites.GetSprite("supercomida","jpg");}

           else{return null;}


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
                int imgY = row * imageSize + 20;

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
        //g2d.setFont(new Font("arial",Font.PLAIN,8));
        FontMetrics fm = g2d.getFontMetrics();

        for (int i = 0; i < images.size(); i++) {
            if (images.get(i) != null) {
                int col = i % columns;
                int row = i / columns;

                int imgX = col * imageSize;
                int imgY = row * imageSize + 20;

                // Dibuja la imagen
                g2d.drawImage(images.get(i), imgX, imgY, imageSize, imageSize, this);

                // Obtiene el texto
                String text = options.get(i).toString();

                // Calcula el ancho del texto para centrarlo
                int textWidth = fm.stringWidth(text);
                g2d.setFont(new Font("arial",Font.PLAIN,(11*imageSize/textWidth)));
                int textX = imgX; //+ (imageSize - textWidth) / 2;
                int textY = imgY + imageSize + fm.getAscent(); // Justo debajo de la imagen

                // Dibuja el texto
                g2d.setColor(Color.BLACK);
                g2d.drawString(text, textX, textY);
            }
        }
    }
}