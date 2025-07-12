package Logica;

import Logica.Excepciones.HabitatLlenoException;
import Logica.Excepciones.TipoMascotaIncorrecto;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Habitat<T extends Mascota> {
    protected ArrayList<T> mascotas;
    protected int limpieza;
    protected int precio;
    protected int size;

    Class<T> tipoMascotaPermitido;

    private Timer timer;
    public Habitat(int precio, int size, Class<T> tipoMascotaPermitido){
        limpieza=100;
        this.precio=precio;
        this.size=size;

        mascotas = new ArrayList<T>();

        this.tipoMascotaPermitido=tipoMascotaPermitido;

        this.startTimer();
    }
    private void startTimer(){
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(!mascotas.isEmpty()) {
                    limpieza -= 5;
                    if (limpieza < 70) {
                        for (Mascota mascota : mascotas) {
                            if (mascota.getFelicidad() >= 3) {
                                mascota.setFelicidad(mascota.getFelicidad() - 3);//cada cinco segundos que la mascota sigue en un habitat sucio su felicidad disminuye en 3
                            }
                            if (mascota.getSalud() >= 1) {
                                mascota.setSalud(mascota.getSalud() - 1);
                            }//y su salud en 1
                        }
                    }
                }

            }
        };

        timer.scheduleAtFixedRate(task, 5000, 5000); //comienza al segundo 5, cada 5 segundos
    }
    public void limpiarHabitat(){
        limpieza=100;
    }

    public void addMascota(Mascota mascota) throws HabitatLlenoException,TipoMascotaIncorrecto {
        if (!tipoMascotaPermitido.isInstance(mascota)) {
            throw new TipoMascotaIncorrecto();
        }
        if (mascotas.size()<size) {
            mascotas.add((T) mascota);
            mascota.EntrarEn(this);
        }else{
            throw new HabitatLlenoException();
        }
    }
    public Mascota getMascota(int i){
        return mascotas.get(i);
    }
    public ArrayList<Mascota> getMacotaList(){
        return (ArrayList<Mascota>) mascotas;
    }

    public Mascota sacarMascota(int i){
        Mascota m = mascotas.remove(i);
        m.Salir();
        return m;
    }
    public Mascota sacarMascota(Mascota mascota) throws TipoMascotaIncorrecto{
        if (!tipoMascotaPermitido.isInstance(mascota)) {
            throw new TipoMascotaIncorrecto();
        }
        boolean succes = mascotas.remove((T)mascota);
        if (succes) {
            mascota.Salir();
            return mascota;
        } else {
            return null;
        }
    }

    public int getLimpieza(){
        return limpieza;
    }

    public int getSize() {
        return size;
    }

    public int getPrecio() {
        return precio;
    }

    public String toString() {
        String string="Tamaño: apto para "+size+" mascota(s). Precio: $"+precio;
        return string;
    }
}
