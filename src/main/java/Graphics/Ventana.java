package Graphics;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Scene currentScene;

    public Ventana() {
        super();
        this.setTitle("Tienda De Mascotas");
        this.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(640, 640);

        currentScene = new MiTienda(this);
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
