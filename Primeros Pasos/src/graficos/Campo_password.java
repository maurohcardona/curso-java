package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Campo_password {
    public static void main(String[] args) {

        Marco_password miMarco = new Marco_password();
        miMarco.setVisible(true);
        
    }
}

class Marco_password extends JFrame{

    public Marco_password(){

        setBounds(0, 0 , 600, 300);
        setTitle("Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina_password miLamina = new Lamina_password();
        add(miLamina);
    }

}

class Lamina_password extends JPanel{

    JPasswordField password;
    JLabel comprobar;
    JButton boton;

    Lamina_password(){

        setLayout(new BorderLayout());
        JPanel lamina2 = new JPanel();
        lamina2.setLayout(new GridLayout(2,2));
        add(lamina2, BorderLayout.NORTH);
        lamina2.add(new JLabel("Usuario", JLabel.CENTER));
        lamina2.add(new JTextField(15));
        lamina2.add(new JLabel("Password", JLabel.CENTER));
        lamina2.add(password = new JPasswordField(15));
        boton = new JButton("Enviar");
        add(boton, BorderLayout.SOUTH);
        password.getDocument().addDocumentListener(new Comprobar_pass());

    }

    private class Comprobar_pass implements DocumentListener{
        
        public void insertUpdate(DocumentEvent e) {

           verificacion();
            
        }

        public void removeUpdate(DocumentEvent e) {
        
            verificacion();
        }

        public void changedUpdate(DocumentEvent e) {
            
                
        }

        private void verificacion(){

            char[] pass = password.getPassword();

            if(pass.length < 8 ){
                password.setBackground(Color.RED);
            }
            else if(pass.length > 12){
                password.setBackground(Color.RED);
            }
            else{
                password.setBackground(Color.WHITE);
            }
        }
        
    
    }
}