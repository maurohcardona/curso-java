package eventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Evento_teclas {
    public static void main(String[] args) {

        Marco_teclas miMarco = new Marco_teclas();
        miMarco.setTitle("Evento con teclas");
        miMarco.setVisible(true);
        
    }
}

class Marco_teclas extends JFrame{

    public Marco_teclas(){

        setBounds(0,0,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Evento_de_teclado tecla = new Evento_de_teclado();
        addKeyListener(tecla);
    }
}

class Evento_de_teclado implements KeyListener{

    public void keyPressed(KeyEvent e){

        System.out.println(e.getKeyChar());
    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){}
}