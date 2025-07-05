package Graphics;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Option extends JLabel implements MouseListener {
    OptionCall parent;

    String option;

    public Option(OptionCall parent, String option, int x, int y, int w, int h, java.awt.Color color){
        super(option);

        this.setBounds(x,y,w,h);
        this.setOpaque(true);
        this.setBackground(color);

        this.parent=parent;
        this.option=option;

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        parent.CallBack(option);
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
