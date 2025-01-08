package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Eventos2 {
    public static void main(String[] args) {

        Marco miMarco = new Marco();
        miMarco.setTitle("Eventos 2");
        miMarco.setVisible(true);
        
    }
    
}

class Marco extends JFrame{

    public Marco(){
 
     setBounds(0, 0, 500, 300);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Lamina lamina1 = new Lamina();
     add(lamina1);
     
    }
 }
 
 class Lamina extends JPanel{
 
     JButton boton_azul = new JButton("Azul");
     JButton boton_amarillo = new JButton("Amarillo");
     JButton boton_rojo = new JButton("Rojo");
 
     public Lamina(){
 
        setBackground(Color.PINK);
        add(boton_azul);
        add(boton_rojo);
        add(boton_amarillo);

        ColorFondo amarillo = new ColorFondo(Color.YELLOW);
        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo rojo = new ColorFondo(Color.RED);

        boton_azul.addActionListener(azul);
        boton_amarillo.addActionListener(amarillo);
        boton_rojo.addActionListener(rojo);
    }

    private class ColorFondo implements ActionListener{

        private Color color_fondo;
    
        public ColorFondo(Color c){
    
            color_fondo = c;
    
        }
    
        public void actionPerformed(ActionEvent e){
    
            setBackground(color_fondo);
    
        }
    }    
 
}


     