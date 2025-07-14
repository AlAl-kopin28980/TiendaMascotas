package Logica;

public enum TipoColor {
    NARANJA(1.5),
    NEGRO(0.9),
    BLANCO(1),
    GRIS(1.4),
    PATRON(1.8);

    private final double precio;

    /**
     * @param precio decimal que luego se multiplica con el tope de cada mascota para calcular precio máximo de esta
     */
    TipoColor(double precio) {
        this.precio= precio;
    }
    public double getPrecio(){
        return precio;
    }
}
