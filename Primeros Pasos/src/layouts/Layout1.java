package layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout1 {
    public static void main(String[] args) {
        
        Marco_layout miMarco = new Marco_layout();
        miMarco.setVisible(true);
    }
}

class Marco_layout extends JFrame{

    public Marco_layout(){

        setBounds(0, 0, 600, 300);
        setTitle("Marco Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina_layout miLamina = new Lamina_layout();
        Lamina_2 miLamina2 = new Lamina_2();
        add(miLamina, BorderLayout.NORTH);
        add(miLamina2, BorderLayout.SOUTH);
        
    }
}

class Lamina_layout extends JPanel{

        public Lamina_layout(){

            
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(new JButton("Amarillo"));
            add(new JButton("Rojo"));
            
        }
}

class Lamina_2 extends JPanel{

    public Lamina_2(){

        setLayout(new BorderLayout());
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);
    }
}