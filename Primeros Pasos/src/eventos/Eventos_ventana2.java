package eventos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class Eventos_ventana2 {
    public static void main(String[] args) {

        Marco_ventana2 miMarco = new Marco_ventana2();
        miMarco.setTitle("Eventos ventanas 2");
        miMarco.setVisible(true);
        
    }
}

class Marco_ventana2 extends JFrame{

    public Marco_ventana2(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CambiaEstado nuevo_estado = new CambiaEstado();
        addWindowStateListener(nuevo_estado);
       
    }
}

class CambiaEstado implements WindowStateListener{

    public void windowStateChanged(WindowEvent e){

        System.err.println("La ventana ha cambiado de estado");

        if(e.getNewState()==Frame.MAXIMIZED_BOTH){
            System.err.println("La ventana ha sido maximizada");
        }
    }
}