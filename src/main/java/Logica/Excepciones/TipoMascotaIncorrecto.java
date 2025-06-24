package Logica.Excepciones;

public class TipoMascotaIncorrecto extends RuntimeException {
    public TipoMascotaIncorrecto() {
        super("El tipo de Mascota es el incorrecto");
    }
}
