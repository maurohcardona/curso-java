package poo;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

public class Prueba_temporizador {
    public static void main(String[] args) {

        dame_la_hora oyente = new dame_la_hora();
        
        Timer mi_temporizador = new Timer(5000, oyente);

        mi_temporizador.start();

        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");

        System.exit(0);
    }
}

class dame_la_hora implements ActionListener {

    public void actionPerformed(ActionEvent e){

        Date ahora = new Date();

        System.out.println("La hora cada 5 segundos es: " + ahora);

        Toolkit.getDefaultToolkit().beep();
    };
}
