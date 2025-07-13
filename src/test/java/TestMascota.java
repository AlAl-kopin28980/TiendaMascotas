import Logica.*;
import Logica.Insumos.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMascota {
    private Mascota perro;
    private Insumo insumo;
    private Habitat jaula;
    @BeforeEach
    void setUp() {
        perro= MascotaFactory.createMascota("perro"); //todas las mascotas funcionan de la misma forma, por eso solo probamos perro
        insumo=new Insumo("insumo",1,0);
        jaula=new Jaula(0,1);
    }

    @AfterEach
    void tearDown() {
        perro=null;
        jaula=null;
        insumo=null;
    }

    @Test
    @DisplayName("Test: Se juega con mascota ")  //lo unico que cambia con cada mascota es por cuanto sube el hambre y la felicidad
    public void testJugar(){
        int felicidad=perro.getFelicidad();
        int hambre=perro.getHambre();
        perro.jugar();
        assertTrue(perro.getHambre()>=hambre & perro.getFelicidad()>=felicidad);
    }

    /**todas las mascotas consumen insumos de la misma forma, por eso solo probamos perro*/

    @Test
    @DisplayName("Test:mascota consume comida")
    public void testConsumir(){
        int hambre=perro.getHambre();
        insumo.addDecorator(new ConsumoAlimento(33));
        perro.consumir(insumo);
        assertTrue(perro.getHambre()<=hambre);
        assertEquals(0,insumo.getContenido());
    }

    @Test
    @DisplayName("Test:mascota consume medicina")
    public void testSanar(){
        int salud=perro.getSalud();
        insumo.addDecorator(new ConsumoMedicina(33));
        perro.consumir(insumo);
        assertTrue(perro.getSalud()>=salud);
        assertEquals(0,insumo.getContenido());
    }

    @Test
    @DisplayName("Test:mascota consume hypercomida")
    public void testConsumirHyperComida(){
        int hambre=perro.getHambre();
        int salud= perro.getSalud();
        int felicidad= perro.getFelicidad();
        insumo.addDecorator(new ConsumoAlimento(33));
        insumo.addDecorator(new ConsumoDiversion(33));
        insumo.addDecorator(new ConsumoMedicina(33));
        perro.consumir(insumo);
        assertTrue(perro.getHambre()<=hambre & perro.getSalud()>=salud & perro.getFelicidad()>=felicidad);
        assertEquals(0,insumo.getContenido());
    }

    @Test
    @DisplayName("Test:mascota entra en habitat exitosamente")
    public void testEntrarHabitat(){
        perro.EntrarEn(jaula);
        assertEquals(jaula,perro.getHabitat());
    }

    @Test
    @DisplayName("Test: mascota trata de entrar en habitat incorrecto")
    public void testEntrarHabitatIncorrecto(){
        Habitat pecera=new Pecera(0,1);
        perro.EntrarEn(pecera);
        assertNull(perro.getHabitat());
    }

    @Test
    @DisplayName("Test:mascota sale de habitat")
    public void testSalirHabitat(){
        perro.EntrarEn(jaula);
        perro.Salir();
        assertNull(perro.getHabitat());
    }

}
