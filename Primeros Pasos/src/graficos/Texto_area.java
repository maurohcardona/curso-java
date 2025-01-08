package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Texto_area {
    public static void main(String[] args) {
        
        Marco_texto_area miMarco = new Marco_texto_area();
        miMarco.setVisible(true);
    }
}

class Marco_texto_area extends JFrame{

    public Marco_texto_area(){

        setBounds(0,0,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Area");
        Lamina_texto_area miLamina = new Lamina_texto_area();
        add(miLamina);
    }
}

class Lamina_texto_area extends JPanel{

    private JTextArea miArea;

    public Lamina_texto_area(){
        
        add(new JLabel("Area: "));
        miArea = new JTextArea(10, 20);
        JScrollPane laminabarra = new JScrollPane(miArea);
        miArea.setLineWrap(true);
        add(laminabarra);
        JButton boton = new JButton("Enviar");
        add(boton);
        boton.addActionListener(new Escucha_texto2());

    }

    private class Escucha_texto2 implements ActionListener{

        public void actionPerformed(ActionEvent e){

            System.out.println(miArea.getText());
        }
    }
}