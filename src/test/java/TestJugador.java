import Logica.Excepciones.DineroInsuficienteException;
import Logica.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Test: Compra falla por falta de dinero") //compra se hace con perro (mascota) porque todas las compras funcionan igual
    public void testDineroInsuficiente() {
        Exception exception = assertThrows(DineroInsuficienteException.class,
                ()->{
                    jugador.comprarMascota(mascota);
                });

    }

    @Test
    @DisplayName("Test: Compra exitosa de mascota") //compra se hace con perro (mascota) porque todas las compras funcionan igual
    public void testCompraMascota() throws Exception{
        jugador.darDinero(10000);
        jugador.comprarMascota(mascota);
        assertEquals(mascota,jugador.getMascotas().getFirst());
    }

    @Test
    @DisplayName("Test: se da mascota de forma exitosa")  //todo objeto se da de la misma forma, por eso se testea solo mascota
    public void testDarMascota() throws Exception{
        jugador.darMascota(mascota);
        assertEquals(mascota,jugador.getMascotas().getFirst());
    }

    @Test
    @DisplayName("Test: Venta exitosa de mascota")
    public void testVentaMascota() throws Exception{
        jugador.darDinero(10000);
        jugador.comprarMascota(mascota);
        jugador.Vender(mascota);
        assertTrue(jugador.getMascotas().isEmpty());
        assertEquals(10000,jugador.getPresupuesto());  //(presupuesto original porque se recuperó el precio de la mascota)
    }
}
