package Logica;

import Logica.Excepciones.HabitatLlenoException;
import Logica.Excepciones.TipoMascotaIncorrecto;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Habitat en el que las mascotas pueden estar
 * @param <T> tipo de mascota que puede estar dentro
 */
public abstract class Habitat<T extends Mascota> {
    protected ArrayList<T> mascotas;
    protected int limpieza;
    protected int precio;
    protected int size;

    Class<T> tipoMascotaPermitido;

    private Timer timer;

    /**
     *
     * @param precio del habitat al comprarlo
     * @param size cantidad de mascotas que pueden estar dentro
     * @param tipoMascotaPermitido tipo de mascota que puede estar dentro
     */
    public Habitat(int precio, int size, Class<T> tipoMascotaPermitido){
        limpieza=100;
        this.precio=precio;
        this.size=size;

        mascotas = new ArrayList<T>();

        this.tipoMascotaPermitido=tipoMascotaPermitido;

        this.startTimer();
    }

    /**
     * cada cinco segundos, si hay una mascota adentro la limpieza del habitat disminuye
     */
    private void startTimer(){
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(!mascotas.isEmpty()) {
                    if(limpieza>=5)limpieza -= 5;
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

    /**
     * la limpieza del habitat es restaurada
     */
    public void limpiarHabitat(){
        limpieza=100;
    }

    /**
     *
     * @param mascota mascota que se desea entrar al habitat
     * @throws HabitatLlenoException si ya hay la cantidad de mascotas maxima
     * @throws TipoMascotaIncorrecto si se trata de entrar una mascota no permitida
     */
    public void addMascota(Mascota mascota) throws HabitatLlenoException,TipoMascotaIncorrecto {
        if (!tipoMascotaPermitido.isInstance(mascota)) {
            throw new TipoMascotaIncorrecto();
        }
        if (!mascotas.contains(mascota)){
            if (mascotas.size()<size) {
                mascotas.add((T) mascota);
                mascota.EntrarEn(this);
            }
            else{
                throw new HabitatLlenoException();}
        }else{
            System.out.println("Mascota ya estaba en el habitat");
        }
    }

    /**
     * @param i indice de la mascota a obtener
     * @return mascota que se obtuvo
     */
    public Mascota getMascota(int i){
        return mascotas.get(i);
    }

    /**
     * @return lista con mascotas adentro del habitat
     */
    public ArrayList<Mascota> getMacotaList(){
        return (ArrayList<Mascota>) mascotas;
    }

    /**
     * @param i indice de la mascota a sacar del habitat
     * @return mascota sacada
     */
    public Mascota sacarMascota(int i){
        if (i<mascotas.size()) {
            Mascota m = mascotas.remove(i);
            m.Salir();
            return m;
        }
        else return null;
    }

    /**
     * @param mascota mascota a sacar del habitat
     * @return mascota sacada
     * @throws TipoMascotaIncorrecto si se trata de sacar un tipo de mascota que no puede estar en el habitat
     */
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
        String string="Tamaño: "+size+" - $"+precio;
        return string;
    }
}
