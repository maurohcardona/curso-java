package eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Evento_mouse {
    public static void main(String[] args) {

        Marco_mouse miMarco = new Marco_mouse();
        miMarco.setTitle("Evento con mouse");
        miMarco.setVisible(true);
        
    }
}
 class Marco_mouse extends JFrame{

    public Marco_mouse(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Eventos_de_mouse click = new Eventos_de_mouse();
        addMouseListener(click);
    }
}

class Eventos_de_mouse implements MouseListener{

    public void mouseExited(MouseEvent e){};

    public void mouseReleased(MouseEvent e){

        System.err.println("Seha soltado el click");
        
    };

    public void mouseClicked(MouseEvent e){

        System.out.println("Se ha hecho click en la coordenada x:" + e.getX() + ", y:" + e.getY());
    };

    public void mousePressed(MouseEvent e){

        System.out.println("Se ha presionado click");
    };

    public void mouseEntered(MouseEvent e){};

}