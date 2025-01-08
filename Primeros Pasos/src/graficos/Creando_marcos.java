package graficos;
import java.awt.Frame;

import javax.swing.*;

public class Creando_marcos {
    public static void main(String[] args) {

        miMarco marco1 = new miMarco();
        
    }
}

class miMarco extends JFrame{

    public miMarco(){

        setSize(500, 300);
        //setBounds(500, 300, 400, 200); Aplica alto y ancho y la posicion al iniciarse
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alto programa");
        setLocation(400, 200);
        setResizable(false); // Para anular agrandar o achicar la ventana
        //setExtendedState(Frame.MAXIMIZED_BOTH); Para abrir la ventana en pantalla completa
    }
}

