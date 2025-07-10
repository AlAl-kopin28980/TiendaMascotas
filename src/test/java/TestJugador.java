import Logica.Excepciones.DineroInsuficienteException;
import Logica.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJugador {
    private Jugador jugador;
    private Mascota mascota;
    @BeforeEach
    void setUp() {
        jugador=Jugador.getJugador();
        mascota=MascotaFactory.createMascota("perro");

    }

    @AfterEach
    void tearDown() {
        jugador.resetJugador();
    }

    @Test
    @DisplayName("Test: Compra falla por falta de dinero")
    public void testDineroInsuficiente() {
        Exception exception = assertThrows(DineroInsuficienteException.class,
                ()->{
                    jugador.comprarMascota(mascota);
                });

    }

    @Test
    @DisplayName("Test: Compra exitosa de mascota")
    public void testCompraMascota() throws Exception{
        jugador.darDinero(10000);
        jugador.comprarMascota(mascota);
        assertEquals(mascota,jugador.getMascotas().getFirst());
    }
}
