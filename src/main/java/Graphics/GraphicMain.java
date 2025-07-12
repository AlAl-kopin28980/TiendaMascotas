package Graphics;

import Logica.Jugador;

public class GraphicMain {
    public static void main(String[] args) {
        Jugador.getJugador().darDinero(1);
        Ventana v = Ventana.getInstance();
    }
}