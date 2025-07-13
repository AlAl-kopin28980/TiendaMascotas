import Logica.Excepciones.DineroInsuficienteException;
import Logica.*;
import Logica.Excepciones.HabitatLlenoException;
import Logica.Excepciones.TipoMascotaIncorrecto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestHabitat {
    private Habitat pecera;
    private Habitat jaula;
    private Mascota perrito;
    private Mascota extra;
    @BeforeEach
    void setUp() {
        pecera=new Pecera(100,1);
        jaula=new Jaula(100,1);
        perrito=MascotaFactory.createMascota("perro");
        extra=MascotaFactory.createMascota("perro");
    }

    @AfterEach
    void tearDown() {
        pecera=null;
        jaula=null;
        perrito=null;
        extra=null;
    }

    @Test
    @DisplayName("Test: Se añade mascota exitosamente")
    public void testAgregarMascota() throws Exception{
        jaula.addMascota(perrito);
        assertEquals(perrito,jaula.getMascota(0));
    }

    @Test
    @DisplayName("Test: Se saca mascota exitosamente")
    public void testSacarMascota() throws Exception{
        jaula.addMascota(perrito);
        Mascota mascota=jaula.sacarMascota(perrito);
        assertEquals(perrito,mascota);
    }

    @Test
    @DisplayName("Test: Falla agregar mascota por tipo de mascota incorrecta")
    public void testAgregarMascotaIncorrecta() {
        Exception exception = assertThrows(TipoMascotaIncorrecto.class,
                ()->{
                    pecera.addMascota(perrito);
                });
    }

    @Test
    @DisplayName("Test: Falla agregar mascota por habitat lleno")
    public void testHabitatLleno() {
        jaula.addMascota(perrito);
        Exception exception = assertThrows(HabitatLlenoException.class,
                ()->{
                    jaula.addMascota(extra);
                });
    }

    @Test
    @DisplayName("Test: Falla sacar mascota por tipo de mascota incorrecta")
    public void testSacarMascotaIncorrecta() {
        Exception exception = assertThrows(TipoMascotaIncorrecto.class,
                ()->{
                    pecera.sacarMascota(perrito);
                });
    }

    @Test
    @DisplayName("Test: Se trata de sacar mascota no en habitat")
    public void testSacarMascotaNoDentro() throws Exception{
        Mascota mascota=jaula.sacarMascota(perrito);
        assertNull(mascota);
    }

    @Test
    @DisplayName("Test: Se trata de agregar mascota ya en habitat")
    public void testAgregarMascotaDentro() throws Exception{
        jaula.addMascota(perrito);
        jaula.addMascota(perrito);
        assertEquals(1,jaula.getMacotaList().size());
    }


    @Test
    @DisplayName("Test: Se saca limpia habitat")
    public void testLimpiarHabitat() throws Exception {
        jaula.addMascota(perrito);
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotEquals(100,jaula.getLimpieza());
        jaula.limpiarHabitat();
        assertEquals(100,jaula.getLimpieza());
    }
}

