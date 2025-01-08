package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuado_texto {
    public static void main(String[] args) {

        Marco_texto miMarco = new Marco_texto();
        miMarco.setVisible(true);
        
    }
}

class Marco_texto extends JFrame{

    public Marco_texto(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cuadro de texto");
        Lamina_texto miLamina = new Lamina_texto();
        add(miLamina);
    }
}

class Lamina_texto extends JPanel{

    private JTextField campo1 = new JTextField(20);
    private JLabel resultado = new JLabel("",JLabel.CENTER);
    
    public Lamina_texto(){

        setLayout(new BorderLayout());
        JPanel lamina2 = new JPanel();
        lamina2.setLayout(new FlowLayout());
        lamina2.add(new JLabel("Email: "));
        JButton boton1 = new JButton("Comprobar");
        lamina2.add(campo1);
        lamina2.add(boton1);
        boton1.addActionListener(new Captura_texto());
        add(lamina2,BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);

    }

    private class Captura_texto implements ActionListener{

        public void actionPerformed(ActionEvent e){

            int arrobas = 0;
            String email = campo1.getText();
            for(int i=0; i<email.length(); i++){
                if(email.charAt(i)=='@'){
                    arrobas++;
                }
            }
            if(arrobas == 1){
                resultado.setText("Email correcto");
            }
            else{
                resultado.setText("Email incorrecto");
            }
        }
    }
}
