package layouts;

import javax.swing.*;

public class DisposicionMUelle{
    public static void main(String[] args) {
        
        MarcoMuelle miMarco = new MarcoMuelle();
        miMarco.setVisible(true);
    }
}

class MarcoMuelle extends JFrame {

    public MarcoMuelle(){

        setBounds(0, 0, 600, 300);
        setTitle("Marco Muelle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaMuelle miLamina = new LaminaMuelle();
        add(miLamina);
    }
    
}

class LaminaMuelle extends JPanel {

    public LaminaMuelle(){

        JButton boton1, boton2, boton3;

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");

        SpringLayout miLayout = new SpringLayout();
        setLayout(miLayout);

        add(boton1);
        add(boton2);
        add(boton3);

        Spring miMuelle = Spring.constant(10, 100, 1000);
        Spring muelleRigido = Spring.constant(10);

        miLayout.putConstraint(SpringLayout.WEST, boton1, miMuelle, SpringLayout.WEST, this);
        miLayout.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);
        miLayout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);
        miLayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3);

    }
}