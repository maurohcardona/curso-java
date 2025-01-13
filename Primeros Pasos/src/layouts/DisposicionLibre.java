package layouts;

import java.awt.LayoutManager;
import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;

public class DisposicionLibre {
    public static void main(String[] args) {
        
        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setVisible(true);
    }
}

class MarcoLibre extends JFrame{

    public MarcoLibre(){

        setBounds(0, 0, 600, 400);
        setTitle("Marco Libre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);
    }
}

class LaminaLibre extends JPanel{

    public LaminaLibre(){

        setLayout(new EnColumnas());
        setBorder(null);

        JLabel nombre = new JLabel("Nombre");
        JLabel apellido = new JLabel("Apeliido");
        JLabel edad = new JLabel("Edad");
        JTextField c_nombre = new JTextField();
        JTextField c_apellido = new JTextField();
        JTextField c_edad = new JTextField();

        add(nombre);
        add(c_nombre);
        add(apellido);
        add(c_apellido);
        add(edad);
        add(c_edad);
    }
}

class EnColumnas implements LayoutManager{

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Implementation here
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // Implementation here
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // Implementation here
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // Implementation here
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {

        int d = parent.getWidth();
        int x = d / 2;
        int y = 20;
        int contador = 0;
        int n = parent.getComponentCount();

        for (int i = 0; i < n; i++) {
            contador++;
            Component c = parent.getComponent(i);
            c.setBounds(x-100, y, 100, 20);
            x += 100;
            if (contador % 2 == 0) {
                x = d / 2;
                y += 40;
            }
        }
    }
}