package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Scene extends JPanel implements MouseListener {
    protected boolean active;
    protected boolean input_active;

    public Scene(Color col){
        super();
        this.setBackground(col);
        addMouseListener(this);

        active = false;
        input_active = true;
    }

    public void paintComponent(Graphics g){
        if (active) {
            super.paintComponent(g);
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void activeInput(boolean input_active) {
        this.input_active = input_active;
    }

    abstract public void whenClick(MouseEvent e);

    @Override
    public void mouseClicked(MouseEvent e) {
        if (active && input_active){
            whenClick(e);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
