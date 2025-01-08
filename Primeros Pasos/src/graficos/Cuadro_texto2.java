package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Cuadro_texto2 {
    public static void main(String[] args) {

        Marco_texto2 miMarco = new Marco_texto2();
        miMarco.setVisible(true);
    }
}

class Marco_texto2 extends JFrame{

    public Marco_texto2(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cuadro de texto");
        Lamina_texto2 miLamina = new Lamina_texto2();
        add(miLamina);
    }
}

class Lamina_texto2 extends JPanel{

    public Lamina_texto2(){
        
        JTextField miCampo = new JTextField(20);
        miCampo.getDocument().addDocumentListener(new Escucha_texto());
        // Document miDoc = miCampo.getDocument();
        // miDoc.addDocumentListener(new Escucha_texto());
        add(miCampo);
    }

    private class Escucha_texto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Haz insertado texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Haz borrado texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }
}


