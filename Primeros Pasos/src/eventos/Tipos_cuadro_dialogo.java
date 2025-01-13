package eventos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tipos_cuadro_dialogo {
    public static void main(String[] args) {
    
        MarcoDialogo miMarco = new MarcoDialogo();
        miMarco.setVisible(true);
    }
}

class MarcoDialogo extends JFrame {

    public MarcoDialogo() {

        setBounds(0, 0, 600, 400);
        setTitle("Marco Dialogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaDialogo miLamina = new LaminaDialogo();
        add(miLamina);
    }
}

class LaminaDialogo extends JPanel {

    JButton boton1, boton2, boton3, boton4;

    public LaminaDialogo() {

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");
        boton3 = new JButton("Boton 3");
        boton4 = new JButton("Boton 4");
        
        boton1.addActionListener(new AccionBotones());
        boton2.addActionListener(new AccionBotones());
        boton3.addActionListener(new AccionBotones());
        boton4.addActionListener(new AccionBotones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);

    }

    private class AccionBotones implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
        
            if(e.getSource() == boton1){
                JOptionPane.showMessageDialog(LaminaDialogo.this, "Ha precionado el boton 1", "Advertencia", 3);
            }
            else if(e.getSource() == boton2){
                JOptionPane.showInputDialog(LaminaDialogo.this, "Ha precionado el boton 2");
            }
            else if(e.getSource() == boton3){
                JOptionPane.showConfirmDialog(LaminaDialogo.this, "Ha precionado el boton 3?", "V Confirmar", 2);
            }
            else if(e.getSource() == boton4){
                JOptionPane.showOptionDialog(LaminaDialogo.this, "Elije", "Opciones", 1, 1, null, null, null);
            }
        }
    }   
}
