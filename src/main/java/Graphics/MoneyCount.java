package Graphics;

import javax.swing.*;
import java.awt.*;

public class MoneyCount extends JComponent {
    private int money;
    private JLabel texto=new JLabel("inicio");
    int x,y,w,h;

    public MoneyCount(int x, int y, int w, int h, int money){
        this.money=money;

        this.setLayout(null);
        this.setBounds(x,y,w,h);
        this.add(texto);

        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.setColor(Color.white);
        //g.fillRect(0,0,w,h);
        texto.setText("$"+money);
        texto.setBounds(0,0,w,h);
        texto.setForeground(Color.BLUE);
        texto.setOpaque(true);
    }
}
