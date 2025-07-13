import Logica.Insumos.ConsumoAlimento;
import Logica.Insumos.ConsumoDiversion;
import Logica.Insumos.ConsumoMedicina;
import Logica.Insumos.Insumo;
import Logica.Jaula;
import Logica.Mascota;
import Logica.MascotaFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInsumo {
    private Mascota perro;
    private Insumo insumo;
    @BeforeEach
    void setUp() {
        perro= MascotaFactory.createMascota("perro");
        insumo=new Insumo("insumo",1,0);
    }

    @AfterEach
    void tearDown() {
        perro=null;
        insumo=null;
    }
    @Test
    @DisplayName("Test:mascota consume insumo con ConsumoAlimento decorator")
    public void testConsumir(){
        int hambre=perro.getHambre();
        insumo.addDecorator(new ConsumoAlimento(33));
        insumo.consumir(perro);
        assertTrue(perro.getHambre()<=hambre);
        assertEquals(0,insumo.getContenido());
    }

    @Test
    @DisplayName("Test:mascota consume insumo con ConsumoMedicina decorator")
    public void testSanar(){
        int salud=perro.getSalud();
        insumo.addDecorator(new ConsumoMedicina(33));
        insumo.consumir(perro);
        assertTrue(perro.getSalud()>=salud);
        assertEquals(0,insumo.getContenido());
    }

    @Test
    @DisplayName("Test:mascota consume insumo con ConsumoDiversion decorator")
    public void testConsumirHyperComida(){
        int felicidad= perro.getFelicidad();
        insumo.addDecorator(new ConsumoDiversion(33));
        insumo.consumir(perro);
        assertTrue( perro.getFelicidad()>=felicidad);
        assertEquals(0,insumo.getContenido());
    }
}
