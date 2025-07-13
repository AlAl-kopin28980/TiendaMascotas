package Graphics;

import Logica.*;
import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.ConsumoAlimento;
import Logica.Insumos.ConsumoMedicina;
import Logica.Insumos.Insumo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public final class MiTienda extends Scene implements OptionCall, ElementMenuCall{
    ArrayList<DibujoHabitat> habitats;
    DibujoComprador puerta;

    Ventana window;
    static MiTienda instance = null;

    //OptionMenu
    private DibujoHabitat habitatselect;
    private Option jugar = new Option(this,"Jugar",0,0,100,50,Color.ORANGE);
    private Option alimentar = new Option(this,"Alimentar",0,50,100,50,Color.pink);
    private Option entrar = new Option(this,"Entrar",0,100,100,50,Color.ORANGE);
    private Option sacar = new Option(this,"Sacar",0,150,100,50,Color.pink);
    private Option limpiar = new Option(this,"Limpiar",0,200,100,50,Color.ORANGE);
    private Option cambiar = new Option(this,"Cambiar",0,250,100,50,Color.pink);
    private Option cancelar = new Option(this,"Cancelar",0,300,100,50,Color.red);
    //ObjectMenu
    private String selectedOption;
    private Mascota mascotaselect;
    private ElementMenu objectmenu;
    public static MiTienda getInstance(){
        if (instance!=null)
            return instance;
        else
            instance = new MiTienda();
        return instance;
    }
    private MiTienda(){
        super(Color.DARK_GRAY);
        this.setLayout(null);
        this.window=Ventana.getInstance();

        habitats = new ArrayList<>();
        DibujoHabitat dibu1 = addHabitat(new Jaula(100,2));

        Hamster p = new Hamster(60,50,0, TipoColor.NARANJA);
        dibu1.addMascota(p);

        Jugador player = Jugador.getJugador();
        player.darMascota(p);

        Insumo hypercomida = new Insumo("comida",2,100);
        hypercomida.addDecorator(new ConsumoAlimento(100));
        player.darInsumo(hypercomida);

        //jugador
        puerta = new DibujoComprador(513,52,362,603);
        this.add(puerta);

        this.add(MoneyCount.getInstance());

        //a tienda
        JButton goBack = new JButton("Tienda");
        goBack.setBounds(0,490,100,100);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana.getInstance().goToScene(TiendaStock.getTiendaStock());
                Ventana.getInstance().revalidate();
                Ventana.getInstance().repaint();
            }
        });
        this.add(goBack,0);
    }

    public DibujoHabitat addHabitat(Habitat habitat){
        return addHabitat(habitat,habitats.size());
    }
    public DibujoHabitat addHabitat(Habitat habitat, int i) {
        for (DibujoHabitat existente : habitats) {
            if (existente.getMe() == habitat) {
                return null; //no crea un dibujo nuevo si ya existe uno
            }
        }

        DibujoHabitat dibu=new DibujoHabitat(73+250*(i/4),350-100*(i%4),100*habitat.getSize(),100,habitat);
        Jugador.getJugador().darHabitat(habitat);

        if (i<8) {
            habitats.add(i,dibu);
            this.add(dibu);
            return dibu;
        }

        return null;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }

    public void whenClick(MouseEvent e) {
        puerta.whenClick(e);
        for (DibujoHabitat habitat : habitats){
            habitat.whenClick(e);
        }
    }

    public void mostrarMenu(DibujoHabitat habitat){
        habitatselect = habitat;

        this.add(jugar);
        this.add(alimentar);
        this.add(entrar);
        this.add(sacar);
        this.add(limpiar);
        this.add(cambiar);
        this.add(cancelar);
        this.revalidate();
        this.repaint();
        activeInput(false);
    }
    @Override
    public void CallBack(String option) {
        selectedOption = option;
        ArrayList mascotas = habitatselect.getMe().getMacotaList();
        if (Objects.equals(option, "Jugar") && !mascotas.isEmpty()){
            objectmenu = new ElementMenu(this,mascotas,3,"Con quien quieres jugar?");
            this.add(objectmenu,0);
        } else if (Objects.equals(option, "Alimentar") && !mascotas.isEmpty() && !Jugador.getJugador().getInsumos().isEmpty()) {
            objectmenu = new ElementMenu(this, mascotas, 3, "A quien vas a alimentar?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Entrar") && mascotas.size()<habitatselect.getMe().getSize()) {
            objectmenu = new ElementMenu(this, Jugador.getJugador().getMascotas(), 6, "Que mascota entraras al habitat?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Sacar") && !mascotas.isEmpty()) {
            objectmenu = new ElementMenu(this, mascotas, 3, "Que mascota vas a sacar?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Limpiar")) {
            habitatselect.limpiarHabitat();
            activeInput(true);
        }else if (Objects.equals(option, "Cambiar")) {
            objectmenu = new ElementMenu(this, Jugador.getJugador().getHabitats(), 6, "Que mascota vas a sacar?");
            this.add(objectmenu, 0);
        } else{
            activeInput(true);
        }

        //implementar consumir

        this.remove(jugar);
        this.remove(alimentar);
        this.remove(entrar);
        this.remove(sacar);
        this.remove(limpiar);
        this.remove(cambiar);
        this.remove(cancelar);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void CallBackElement(Object option) {
        this.remove(objectmenu);
        activeInput(true);
        if (option instanceof Mascota){
            if (Objects.equals(selectedOption, "Jugar")) {
                Mascota m = (Mascota) option;
                m.jugar();
                System.out.println("Jugamos con " + m);
            } else if (Objects.equals(selectedOption, "Alimentar")) {
                Mascota m = (Mascota) option;
                mascotaselect = m;
                ArrayList insumos = Jugador.getJugador().getInsumos();
                objectmenu = new ElementMenu(this,insumos,6,"Con que lo vas a alimentar?");
                activeInput(false);
                this.add(objectmenu,0);
                System.out.println("Alimentaremos a " + m);
            } else if (Objects.equals(selectedOption, "Entrar")) {
                Mascota m = (Mascota) option;
                try {
                    m.getDibujo().Salir();
                    habitatselect.addMascota(m);
                    System.out.println(m + " entra a " + habitatselect.getMe());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (Objects.equals(selectedOption, "Sacar")) {
                Mascota m = (Mascota) option;
                m.getDibujo().Salir();
                System.out.println("Sacamos a "+m+" de "+habitatselect);
            }
        } else if (option instanceof Insumo) {
            Insumo in = (Insumo) option;
            mascotaselect.consumir(in);
            System.out.println("Alimentamos a " + mascotaselect + " con " + in);
        } else if (option instanceof Habitat) {
            int i = habitats.indexOf(habitatselect);
            DibujoHabitat thenew = addHabitat((Habitat) option, i);
            if (thenew!=null) { //si se creo un dibujo nuevo, quita el anterior
                System.out.println("cambiamos a "+habitatselect+" con "+thenew);
                for (DibujoMascota dibu : habitatselect.getMascotas()) {
                    dibu.Salir();
                }
                this.remove(habitatselect);
                habitats.remove(habitatselect);
            }
        }

        this.revalidate();
        this.repaint();
    }
}
