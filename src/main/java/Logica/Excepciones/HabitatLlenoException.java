package Logica.Excepciones;

public class HabitatLlenoException extends RuntimeException {
    public HabitatLlenoException() {
        super("El habitat esta lleno");
    }
}
