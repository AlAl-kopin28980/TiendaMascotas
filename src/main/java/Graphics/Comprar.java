package Graphics;

import java.awt.*;
import java.awt.event.MouseEvent;

public final class Comprar extends Scene {

    static Comprar instance = null;

    public static Comprar getInstance(){
        if (instance!=null)
            return instance;
        else
            instance = new Comprar();
        return instance;
    }
    private Comprar() {
        super(Color.cyan);
    }

    @Override
    public void whenClick(MouseEvent e) {

    }
}
