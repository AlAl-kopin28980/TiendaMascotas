package Graphics;

import javax.swing.*;
import java.awt.*;

public final class Ventana extends JFrame {
    public Scene currentScene;

    private static Ventana instance = null;
    public static Ventana getInstance(){
        if (instance==null) {
            return new Ventana();
        }else {
            return instance;
        }
    }

    private Ventana() {
        super();

        instance=this;
        
        this.setTitle("Tienda De Mascotas");
        this.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(872, 640);

        currentScene = new MiTienda();
        currentScene.setActive(true);
        this.add(currentScene);

        //this.pack();
        this.setVisible(true);
    }

    public void goToScene(Scene next){
        currentScene.setActive(false);
        next.setActive(true);
        currentScene = next;

    }
}
