package Graphics;

import javax.swing.*;
import java.awt.*;

public abstract class Scene extends JPanel{
    private boolean active;

    public Scene(Color col){
        super();
        this.setBackground(col);

        active = false;
    }

    public void paintComponent(Graphics g){
        if (active) {
            super.paintComponent(g);
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
