package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public abstract class Scene extends JPanel implements MouseListener {
    private boolean active;

    public Scene(Color col){
        super();
        this.setBackground(col);
        addMouseListener(this);

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
