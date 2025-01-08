package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Escribiendo_en_marco {
    public static void main(String[] args) {
        
        Marco_con_texto miMarco = new Marco_con_texto();
        miMarco.setVisible(true);

    }
}

class Marco_con_texto extends JFrame{

    public Marco_con_texto(){

        setSize(1000, 700);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Primer Texto");
        Lamina_figuras miLamina = new Lamina_figuras();
        add(miLamina);
        miLamina.setBackground(SystemColor.window);

    }
}


class Lamina_figuras extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.setFont(new Font("Courier", Font.BOLD, 18));
        g.setColor(Color.BLUE);
        g.drawString("Estamos aprendiendo Swing", 10, 30);
        g.drawRect(50, 50, 200, 200);

        Graphics2D g2 = (Graphics2D)g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
        g2.setPaint(Color.BLUE);
        g2.draw(rectangulo);
        g2.setPaint(Color.RED);
        g2.fill(rectangulo);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.setPaint(new Color(109,172,59));
        g2.fill(elipse);

        g2.setPaint(Color.BLUE);
        g2.draw(new Line2D.Double(100, 100, 300, 250));
        

        double centro_x = rectangulo.getCenterX();
        double centro_y = rectangulo.getCenterY();
        double radio = 150;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centro_x,centro_y, centro_x+radio, centro_y+radio);
        g2.setPaint(Color.MAGENTA);
        g2.draw(circulo);
    }
}