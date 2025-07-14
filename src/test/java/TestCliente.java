import Logica.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCliente {
    private Jugador jugador;
    private Mascota perrito;  //probamos la compra solo con Perro porque es igual para todo tipo de mascota
    private Cliente cliente;
    private Habitat hogar;
    @BeforeEach
    void setUp() {
        cliente=new Cliente();
        jugador=Jugador.getJugador();
        perrito=MascotaFactory.createMascota("perro");
        jugador.darMascota(perrito);
        hogar=new Jaula(0,1);
    }

    @AfterEach
    void tearDown() {
       jugador.resetJugador();
       hogar=null;
       cliente=null;
       perrito=null;
    }

    @Test
    @DisplayName("Test: Se escoge una mascota para comprar dentro de las que tiene el jugador VISIBLES")
    public void testElegirMascota() throws Exception{
        jugador.darHabitat(hogar);
        perrito.EntrarEn(hogar);
        assertEquals(perrito,cliente.elegirMascota());
    }

    @Test
    @DisplayName("Test: Se trata de escoger una mascota cuando no hay visibles")
    public void testElegirMascotaMal() throws Exception{
        assertNull(cliente.elegirMascota());
    }

    @Test
    @DisplayName("Test: Se compra una mascota")
    public void testComprarMascota() throws Exception{
        jugador.darHabitat(hogar);
        perrito.EntrarEn(hogar);
        cliente.elegirMascota();
        cliente.Comprar();
        assertTrue(jugador.getMascotas().isEmpty());
    }

}
