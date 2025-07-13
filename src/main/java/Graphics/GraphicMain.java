package Graphics;

import Logica.Jugador;

/**
 * Clase Main para el lado Gráfico
 */
public class GraphicMain {
    /**
     * Crea la ventana
     * Da un presupuesto inicial al jugador
     * @param args
     */
    public static void main(String[] args) {
        Jugador.getJugador().darDinero(20000);
        Ventana v = Ventana.getInstance();
    }
}