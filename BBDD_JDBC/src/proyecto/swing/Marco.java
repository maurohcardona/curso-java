package proyecto.swing;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Marco extends JFrame {
    
    public Marco() {

        setBounds(200, 200, 300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        VentanaSuperior lamina_superior = new VentanaSuperior();
        VentanaMedio lamina_media = new VentanaMedio();
        VentanaInferior lamina_inferior = new VentanaInferior(lamina_media, lamina_superior);

        add(lamina_superior, BorderLayout.NORTH);
        add(lamina_media, BorderLayout.CENTER);
        add(lamina_inferior, BorderLayout.SOUTH);
    }

}
