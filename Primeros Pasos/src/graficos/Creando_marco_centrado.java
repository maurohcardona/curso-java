package graficos;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class Creando_marco_centrado {
    public static void main(String[] args) {

        Ventana ventana1 = new Ventana();
        
    }
}

class Ventana extends JFrame{

    public Ventana(){

        Toolkit mi_pantalla = Toolkit.getDefaultToolkit();
        Dimension resolucion = mi_pantalla.getScreenSize();
        int altura = resolucion.height;
        int ancho = resolucion.width;
        setBounds(ancho/4, altura/4, ancho/2, altura/2);
        setVisible(true);
        setTitle("Marco Centrado");
        Image logo = mi_pantalla.getImage("C:/Users/mauro/OneDrive/Documentos/Curso de Java/Primeros Pasos/src/graficos/icono.png");
        setIconImage(logo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}