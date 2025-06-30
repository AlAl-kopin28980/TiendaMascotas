package Logica;

import Logica.Insumos.*;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        Jugador jugador=Jugador.getJugador();
        jugador.darDinero(20000);
        Tienda tienda=new Tienda(3, jugador);
        tienda.comprarCosas();
    }
}
