package Graphics;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Opcion de texto que al presionarla llama a Parent con su texto
 */
public class Option extends JLabel implements MouseListener {
    OptionCall parent;

    String option;

    /**
     * Inicia la Option
     * @param parent Objeto a llamar
     * @param option Opción que mostrar
     * @param x
     * @param y
     * @param w
     * @param h
     * @param color
     */
    public Option(OptionCall parent, String option, int x, int y, int w, int h, java.awt.Color color){
        super(option);

        this.setBounds(x,y,w,h);
        this.setOpaque(true);
        this.setBackground(color);

        this.parent=parent;
        this.option=option;

        addMouseListener(this);
    }

    /**
     * al clickear llama a Parent
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()==1)
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
