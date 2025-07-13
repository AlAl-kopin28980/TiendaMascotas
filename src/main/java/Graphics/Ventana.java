package Graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana donde ocurre todo
 * Maneja que Scene esta activa y se muestra
 */
public final class Ventana extends JFrame {
    public Scene currentScene;

    private static Ventana instance = null;

    /**
     * Devuelve la instancia de Ventana
     * @return
     */
    public static Ventana getInstance(){
        if (instance==null) {
            return new Ventana();
        }else {
            return instance;
        }
    }
    /**
     * Inicia Ventana y Scenes
     */
    private Ventana() {
        super();

        instance=this;
        
        this.setTitle("Tienda De Mascotas");
        this.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(872, 640);



        MiTienda mitienda = MiTienda.getInstance();
        TiendaStock tienda= TiendaStock.getTiendaStock();

        currentScene = mitienda;
        currentScene.setActive(true);

        goToScene(mitienda);

        //this.pack();
        this.setVisible(true);
    }

    /**
     * Cambia de Scene
     * @param next siguiente Scene
     */
    public void goToScene(Scene next){
        currentScene.setActive(false);
        this.remove(currentScene);
        next.setActive(true);
        this.add(next);
        currentScene = next;

    }
}
