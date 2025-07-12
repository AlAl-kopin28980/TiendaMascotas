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
    private Option cancelar = new Option(this,"Cancelar",0,250,100,50,Color.red);
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
        DibujoHabitat dibu1=new DibujoHabitat(100,300,200,100,new Jaula(100,2));
        habitats.add(dibu1);
        this.add(dibu1);
        DibujoHabitat dibu2=new DibujoHabitat(100,200,200,100,new Pecera(200,2));
        habitats.add(dibu2);
        this.add(dibu2);
        DibujoHabitat dibu3=new DibujoHabitat(100,100,200,100,new JaulaPajaro(300,2));
        habitats.add(dibu3);
        this.add(dibu3);
        Hamster p = new Hamster(60,50,0, TipoColor.NARANJA);
        Gato q = new Gato(60,50,0, TipoColor.BLANCO);
        dibu1.addMascota(p);
        dibu1.addMascota(q);
        Pez p2 = new Pez(60,50,0, TipoColor.NEGRO);
        Pez q2 = new Pez(60,50,0, TipoColor.GRIS);
        dibu2.addMascota(p2);
        dibu2.addMascota(q2);
        Hamster p3 = new Hamster(60,50,0, TipoColor.PATRON);
        //dibu3.addMascota(p3);

        Jugador player = Jugador.getJugador();
        player.darMascota(p);
        player.darMascota(q);
        player.darMascota(p2);
        player.darMascota(q2);
        player.darMascota(p3);

        Insumo hypercomida = new Insumo("hypercomida",2,100);
        hypercomida.addDecorator(new ConsumoAlimento(100));
        hypercomida.addDecorator(new ConsumoMedicina(100));
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
            objectmenu = new ElementMenu(this,mascotas,6,"Con quien quieres jugar?");
            this.add(objectmenu,0);
        } else if (Objects.equals(option, "Alimentar") && !mascotas.isEmpty() && !Jugador.getJugador().getInsumos().isEmpty()) {
            objectmenu = new ElementMenu(this, mascotas, 6, "A quien vas a alimentar?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Entrar") && mascotas.size()<habitatselect.getMe().getSize()) {
            objectmenu = new ElementMenu(this, Jugador.getJugador().getMascotas(), 6, "Que mascota entraras al habitat?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Sacar") && !mascotas.isEmpty()) {
            objectmenu = new ElementMenu(this, mascotas, 6, "Que mascota vas a sacar?");
            this.add(objectmenu, 0);
        } else if (Objects.equals(option, "Limpiar")) {
            habitatselect.limpiarHabitat();
            activeInput(true);
        } else{
            activeInput(true);
        }

        //implementar consumir

        this.remove(jugar);
        this.remove(alimentar);
        this.remove(entrar);
        this.remove(sacar);
        this.remove(limpiar);
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
        }

        this.revalidate();
        this.repaint();
    }
}
