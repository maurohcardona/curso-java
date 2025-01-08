package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Jslider {
    public static void main(String[] args) {

        Marco_Jsilder miMarco = new Marco_Jsilder();
        miMarco.setVisible(true);
    }
}
class Marco_Jsilder extends JFrame{

    public Marco_Jsilder(){

        setBounds(0, 0, 600, 300);
        setTitle("JSilder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Lamina_texto_JSlider lamina_texto = new Lamina_texto_JSlider();
        Lamina_Jslider miLamina = new Lamina_Jslider(lamina_texto);
        add(lamina_texto, BorderLayout.NORTH);
        add(miLamina, BorderLayout.SOUTH);
    }
}

class Lamina_texto_JSlider extends JPanel{

    private JLabel texto;

    public Lamina_texto_JSlider(){

        texto = new JLabel("En un lugar de la mancha...");
        texto.setFont(new Font("Arial", Font.PLAIN, 50));
        add(texto);
    }

    public void cambia_tamano(int tamano){

        texto.setFont(new Font("Arial", Font.PLAIN, tamano));
    }
}
class Lamina_Jslider extends JPanel{

    Lamina_texto_JSlider texto;
    

    public Lamina_Jslider(Lamina_texto_JSlider texto){

        this.texto = texto;
        JSlider control = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
        control.setMinorTickSpacing(5);
        control.setMajorTickSpacing(25);
        control.setFont(new Font("Arial", 3, 10));
        control.setSnapToTicks(getFocusTraversalKeysEnabled());
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.addChangeListener(new Maneja_cambio(texto, control));
        add(control);
        
    }
}

class Maneja_cambio implements ChangeListener{

    private Lamina_texto_JSlider texto;
    private JSlider control;

    public Maneja_cambio(Lamina_texto_JSlider texto, JSlider control){

        this.texto = texto;
        this.control = control;
    }

    public void stateChanged(ChangeEvent e){

        texto.cambia_tamano(control.getValue());

    }
}