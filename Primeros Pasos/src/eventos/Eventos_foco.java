package eventos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Eventos_foco {
    public static void main(String[] args) {

        Marco_foco miMarco = new Marco_foco();
        miMarco.setVisible(true);
        
    }
}

class Marco_foco extends JFrame implements WindowFocusListener{

    public Marco_foco(){

        setBounds(0, 0, 600, 300);
        setTitle("Eventos de foco");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina_foco miLamina = new Lamina_foco();
        add(miLamina);
        addWindowFocusListener(this);
        
    }

    public void windowGainedFocus(WindowEvent e){

        System.out.println("La ventana ha ganado foco");
    }

    public void windowLostFocus(WindowEvent e){}
}

class Lamina_foco extends JPanel{

    JTextField cuadro1 = new JTextField();
    JTextField cuadro2 = new JTextField();

    public Lamina_foco(){

        setBackground(Color.GRAY);      
        setLayout(null);
        cuadro1 = new JTextField();
        cuadro2 = new JTextField();
        cuadro1.setBounds(50, 60, 150, 20);
        cuadro2.setBounds(50, 90, 150, 20);
        add(cuadro1);
        add(cuadro2);
        Evento_de_foco foco = new Evento_de_foco();
        cuadro1.addFocusListener(foco);
        cuadro2.addFocusListener(foco);
        
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.WHITE);
        g.drawString("Eventos de Foco", 10 , 30);
        
        
    } 

    private class Evento_de_foco implements FocusListener{

        public void focusGained(FocusEvent e){
            
            if(e.getSource()==cuadro1){
                System.out.println("El cuadro 1 ha ganado foco");
            }
            else if(e.getSource()==cuadro2){
                System.out.println("El cuadro 2 ha ganado foco");
            }
            
        };
    
        public void focusLost(FocusEvent e){

            String email = cuadro1.getText();

            if (email.contains("@")) {
                System.out.println("Email correcto");
            } else {
                System.out.println("Email incorrecto");
            }
        }
    };
}


