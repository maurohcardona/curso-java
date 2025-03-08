package cliente.clases;

import javax.swing.JFrame;

public class Marco extends JFrame {

    public Marco(Lamina miLamina) {

        setBounds(600, 300, 250, 350);
        setTitle("Chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miLamina);
        addWindowListener(new EnvioOnline(miLamina));
        
    }
    
}
