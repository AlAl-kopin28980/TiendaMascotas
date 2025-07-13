import Logica.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMascotaFactory {
    private Mascota perro;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test: Se crea mascota exitosamente")
    public void testCrearMascota() throws Exception{
        perro=MascotaFactory.createMascota("perro");
        assertTrue(perro instanceof Perro);
    }

    @Test
    @DisplayName("Test: No se crea mascota ")
    public void testCrearMascotaIncorrecta() throws Exception{
        perro=MascotaFactory.createMascota("hola");
        assertNull(perro);
    }
}
