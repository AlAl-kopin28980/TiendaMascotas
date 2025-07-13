package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Escena prototipo
 */
public abstract class Scene extends JPanel implements MouseListener {
    protected boolean active;
    protected boolean input_active;

    /**
     * Inicia la Scene
     * @param col color de fondo
     */
    public Scene(Color col){
        super();
        this.setBackground(col);
        addMouseListener(this);

        active = false;
        input_active = true;
    }

    @Override
    public void paintComponent(Graphics g){
        if (active) {
            super.paintComponent(g);
        }
    }

    /**
     * Activa o desactiva la Scene
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Activa o desactiva la capacidad de recibir Input del mouse
     * @param input_active
     */
    public void activeInput(boolean input_active) {
        this.input_active = input_active;
    }

    /**
     * Se llama al clickear en la Scene
     * @param e
     */
    abstract public void whenClick(MouseEvent e);

    /**
     * Pasa el click a whenClick, solo si el input esta activo
     * @param e the event to be processed
     */
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
