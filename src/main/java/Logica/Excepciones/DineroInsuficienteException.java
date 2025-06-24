package Logica.Excepciones;

public class DineroInsuficienteException extends Exception {
    public DineroInsuficienteException() {

        super("No tiene dinero suficiente para realizar la compra.");
    }
}
