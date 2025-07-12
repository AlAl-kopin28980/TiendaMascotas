package Graphics;

import Logica.*;
import Logica.Excepciones.DineroInsuficienteException;
import Logica.Insumos.Insumo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public final class TiendaStock extends Scene implements ElementMenuCall{
    private static TiendaStock tienda= null;
    private Tienda inventario;
    private ArrayList<Mascota> perros, gatos, aves, hamsters, peces;
    private ArrayList<Habitat> peceras, jaulas, jaulaspajaro;
    private ArrayList<Insumo> comida, medicina, comidaenhanced;
    private ElementMenu menu;
    private ElementMenu menu1;

    JButton goBack;
    JButton cancel;

    Ventana window;

    private final ArrayList<String> tipos=new ArrayList<String>(Arrays.asList("Insumos","Mascotas","Habitats"));  //tengo que arreglar los tipos para el getImage
    private final ArrayList<String> insumos=new ArrayList<String>(Arrays.asList("Comida","Medicina","HyperComida"));
    private final ArrayList<String> mascotas=new ArrayList<String>(Arrays.asList("Perros","Gatos","Hamsters","Aves","Peces"));
    private final ArrayList<String> habitats=new ArrayList<String>(Arrays.asList("Peceras","Jaulas","JaulasPajaro"));

    public static TiendaStock getTiendaStock(){
        if (tienda==null){
            tienda=new TiendaStock();
        }
        return tienda;
    }

    private TiendaStock(){
        super(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.window=Ventana.getInstance();

        inventario= Tienda.getTienda();
        perros=inventario.getPerros();
        gatos=inventario.getGatos();
        hamsters=inventario.getHamsters();
        peces=inventario.getPeces();
        aves=inventario.getAves();
        peceras=inventario.getPeceras();
        jaulas=inventario.getJaulas();
        jaulaspajaro=inventario.getJaulaspajaro();
        medicina=inventario.getMedicina();
        comida=inventario.getComida();
        comidaenhanced=inventario.getComidaenhanced();


        menu1=new ElementMenu(this,tipos,3,"¿Qué desea comprar?"); //arreglar tipos
        //go back
        goBack = new JButton("A casa");
        goBack.setBounds(0,490,100,100);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana.getInstance().goToScene(MiTienda.getInstance());
                Ventana.getInstance().revalidate();
                Ventana.getInstance().repaint();
            }
        });
        //cancel
        cancel = new JButton("Cancelar");
        cancel.setBounds(0,490,100,100);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TiendaStock.getTiendaStock().remove(menu);
                menu=menu1;
                menu.add(goBack,0);
                TiendaStock.getTiendaStock().add(menu);
                TiendaStock.getTiendaStock().revalidate();
                TiendaStock.getTiendaStock().repaint();
            }
        });

        menu1.add(goBack,0);
        menu=menu1;
        this.add(menu,0);
    }

    public void whenClick(MouseEvent e){
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(0,320,window.getWidth(),window.getHeight());
    }

    @Override
    public void CallBackElement(Object option) {
        this.remove(menu);
        activeInput(true);

        try {
            if (option == "Insumos") {
                menu = new ElementMenu(this, insumos, 3, "¿Qué tipo de insumo desea?");
            }
            if (option == "Medicina") {
                menu = new ElementMenu(this, medicina, 3, "¿Qué tipo de medicina desea?");
            }
            if ((option instanceof Insumo) && ((Insumo) option).getNombre() == "medicina") {
                inventario.ComprarMedicina((Insumo) option);
                menu = menu1;
            }
            if (option == "Comida") {
                menu = new ElementMenu(this, comida, 3, "¿Qué tipo de comida desea?");
            }
            if ((option instanceof Insumo) && ((Insumo) option).getNombre() == "comida") {
                inventario.ComprarComida((Insumo) option);
                menu = menu1;
            }
            if (option == "HyperComida") {
                menu = new ElementMenu(this, comidaenhanced, 3, "¿Qué tipo de hypercomida desea?");
            }
            if ((option instanceof Insumo) && ((Insumo) option).getNombre().equals("comida-mejorada")) {
                inventario.ComprarSuperComida((Insumo) option);
                menu = menu1;
            }


            if (option == "Mascotas") {
                menu = new ElementMenu(this, mascotas, 5, "¿Qué tipo de mascota desea?");
            }
            if (option == "Perros") {
                menu = new ElementMenu(this, perros, 3, "¿Qué tipo de perro desea?");
            }
            if ((option instanceof Perro)) {
                inventario.ComprarPerro((Mascota) option);
                new DibujoMascota(0, 0, 100, 100, (Mascota) option);
                menu = menu1;
            }
            if (option == "Gatos") {
                menu = new ElementMenu(this, gatos, 3, "¿Qué tipo de gato desea?");
            }
            if ((option instanceof Gato)) {
                inventario.ComprarGato((Mascota) option);
                new DibujoMascota(0, 0, 100, 100, (Mascota) option);
                menu = menu1;
            }
            if (option == "Hamsters") {
                menu = new ElementMenu(this, hamsters, 3, "¿Qué tipo de hamster desea?");
            }
            if ((option instanceof Hamster)) {
                inventario.ComprarHamster((Mascota) option);
                new DibujoMascota(0, 0, 100, 100, (Mascota) option);
                menu = menu1;
            }
            if (option == "Aves") {
                menu = new ElementMenu(this, aves, 3, "¿Qué tipo de ave desea?");
            }
            if ((option instanceof Ave)) {
                inventario.ComprarAves((Mascota) option);
                new DibujoMascota(0, 0, 100, 100, (Mascota) option);
                menu = menu1;
            }
            if (option == "Peces") {
                menu = new ElementMenu(this, peces, 3, "¿Qué tipo de pez desea?");
            }
            if ((option instanceof Pez)) {
                inventario.ComprarPeces((Mascota) option);
                new DibujoMascota(0, 0, 100, 100, (Mascota) option);
                menu = menu1;
            }


            if (option == "Habitats") {
                menu = new ElementMenu(this, habitats, 3, "¿Qué tipo de habitat desea?");
            }
            if (option == "Peceras") {
                menu = new ElementMenu(this, peceras, 3, "¿Qué tipo de pecera desea?");
            }
            if ((option instanceof Pecera)) {
                inventario.ComprarPecera((Habitat) option);
                menu = menu1;
            }
            if (option == "Jaulas") {
                menu = new ElementMenu(this, jaulas, 3, "¿Qué tipo de jaula desea?");
            }
            if ((option instanceof Jaula)) {
                inventario.ComprarJaula((Habitat) option);
                menu = menu1;
            }
            if (option == "JaulasPajaro") {
                menu = new ElementMenu(this, jaulaspajaro, 3, "¿Qué tipo de jaula para pájaros desea?");
            }
            if ((option instanceof JaulaPajaro)) {
                inventario.ComprarJaulaPajaro((Habitat) option);
                menu = menu1;
            }
        } catch (DineroInsuficienteException e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.INFORMATION_MESSAGE);
            menu=menu1;
        }
        //Jugador.getJugador().showInventario();
        //System.out.println("   ");
        if (menu!=menu1) {
            menu.add(cancel, 0);
        }

        menu.add(goBack,0);
        this.add(menu,0);
        this.revalidate();
        this.repaint();
    }
}
