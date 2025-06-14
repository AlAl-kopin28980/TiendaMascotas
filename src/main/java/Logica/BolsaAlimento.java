package Logica;

public class BolsaAlimento {
    private int contenido;
    private String tipo;
    public BolsaAlimento(int tamaño, String tipo){
        contenido=tamaño;
        this.tipo=tipo;
    }
    public String getTipo(){return tipo;}
    public int getContenido(){return contenido;}
    public int sacarAlimento(int cantidad){
        if (contenido>=cantidad){
            contenido=contenido-cantidad;
            return cantidad;
        }
        else{
            int aux=contenido;
            contenido=0;
            return aux;
        }
    }
}

