package eventos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos_ventana {
    public static void main(String[] args) {
        
        Marco_ventana miMarco = new Marco_ventana();
        miMarco.setTitle("Evento ventanas");
        miMarco.setVisible(true);
    }
}

class Marco_ventana extends JFrame{

    public Marco_ventana(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        M_ventana oyente = new M_ventana();
        addWindowListener(oyente);
    }
}

class M_ventana implements WindowListener{

    public void windowActivated(WindowEvent e){

        System.out.println("Ventana activada");
    }

    public void windowClosed(WindowEvent e){}

    public void windowClosing(WindowEvent e){

        System.out.println("Ventana cerrando");
    }

    public void windowDeactivated(WindowEvent e){

        System.out.println("Ventana desactivada");
    }

    public void windowDeiconified(WindowEvent e){

        System.out.println("Ventana restaurada");
    }

    public void windowIconified(WindowEvent e){

        System.out.println("Ventana minimizada");
    }

    public void windowOpened(WindowEvent e){

        System.out.println("Ventana abierta");
    }
}