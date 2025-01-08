package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Eventos1 {
    public static void main(String[] args) {

        Marco marco_botones = new Marco();
        marco_botones.setTitle("Marco con botones");
        marco_botones.setVisible(true);
        
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

class Lamina extends JPanel implements ActionListener{

    JButton boton_azul = new JButton("Azul");
    JButton boton_amarillo = new JButton("Amarillo");
    JButton boton_rojo = new JButton("Rojo");

    public Lamina(){

        setBackground(Color.PINK);
        add(boton_azul);
        add(boton_rojo);
        add(boton_amarillo);
        boton_azul.addActionListener(this);
        boton_amarillo.addActionListener(this);
        boton_rojo.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){

        Object boton = e.getSource();

        if(boton == boton_azul){

            setBackground(Color.BLUE);
        }
        else if(boton == boton_amarillo){

            setBackground(Color.YELLOW);
        }
        else if(boton == boton_rojo){

            setBackground(Color.RED);
        }
    }   

}
