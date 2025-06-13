package Graphics;


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

    public DibujoMascota(int x, int y, int w, int h, int type) {
        try {
            image= ImageIO.read(new File("src/main/resources/Crash-Bandicoot-PNG-Image.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.w=w;
        this.h=h;
        this.setBounds(x,y,w,h);
    }
    /*
    public void setImage(int type){
        try {
            if(type==1){image = ImageIO.read(new File("src/main/resources/Coca.png"));}
            else if(type==2){image = ImageIO.read(new File("src/main/resources/Sprite.png"));}
            else if(type==3){image = ImageIO.read(new File("src/main/resources/Fanta.png"));}
            else if(type==4){image = ImageIO.read(new File("src/main/resources/Super8.png"));}
            else if(type==5){image = ImageIO.read(new File("src/main/resources/Snickers.png"));}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

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