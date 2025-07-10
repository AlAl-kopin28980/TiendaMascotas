import Logica.*;
import Logica.Insumos.*;
import Logica.Excepciones.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;


public class TestTienda {
    private Jugador jugador;
    private Tienda tienda;
    @BeforeEach
    void setUp() {
        jugador=Jugador.getJugador();
        tienda=Tienda.getTienda();
    }

    @AfterEach
    void tearDown() {
        jugador.resetJugador();
    }

    @Test
    @DisplayName("Test: Compras exitosas")
    public void testComprarExitosamente()  {
        jugador.darDinero(20000);
        Insumo optimo=tienda.getComidaenhanced().get(2);
        // se simula input del usuario

        String input = "1\n3\n3\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        tienda.comprarCosas();
        Insumo compra=jugador.getInsumos().get(0);

        assertEquals(compra, optimo);
        //jugador.showInventario();

        //System.setIn(System.in);
    }


    @Test
    @DisplayName("Test: Compra falla por falta de dinero")
    public void testDineroInsuficiente() {
        String input = "1\n3\n3\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        tienda.comprarCosas();
        assertTrue(jugador.getInsumos().isEmpty());


    }
}
