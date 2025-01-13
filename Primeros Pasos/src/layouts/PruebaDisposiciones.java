package layouts;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class PruebaDisposiciones {
    public static void main(String[] args) {
        
        MarcoDisposiciones miMarco = new MarcoDisposiciones();
        miMarco.setVisible(true);
    }
}

class MarcoDisposiciones extends JFrame{
    
    public MarcoDisposiciones(){
        
        setBounds(0, 0, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Prueba de disposiciones");
        setLayout(new BorderLayout());

        JLabel rotulo1 = new JLabel("Nombre: ");
        JTextField texto1 = new JTextField(10); 
        texto1.setMaximumSize(texto1.getPreferredSize());
        Box cajaH1 = Box.createHorizontalBox();
        cajaH1.add(rotulo1);
        cajaH1.add(Box.createHorizontalStrut(10));
        cajaH1.add(texto1);

        JLabel rotulo2 = new JLabel("Contraseña: ");
        JTextField texto2 = new JTextField(10);
        texto2.setMaximumSize(texto2.getPreferredSize());
        Box cajaH2 = Box.createHorizontalBox();
        cajaH2.add(rotulo2);
        cajaH2.add(Box.createHorizontalStrut(10));
        cajaH2.add(texto2);

        JButton boton1 = new JButton("Aceptar");
        JButton boton2 = new JButton("Cancelar");
        Box cajaH3 = Box.createHorizontalBox();
        cajaH3.add(boton1);
        cajaH3.add(Box.createGlue());
        cajaH3.add(boton2);

        Box cajaV = Box.createVerticalBox();
        cajaV.add(cajaH1);
        cajaV.add(cajaH2);
        cajaV.add(cajaH3);

        add(cajaV, BorderLayout.CENTER);
    }
}

