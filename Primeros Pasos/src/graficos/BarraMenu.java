package graficos;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BarraMenu {
    public static void main(String[] args) {

        MarcoMenu miMarco = new MarcoMenu();
        miMarco.setVisible(true);
       
    }
}

class MarcoMenu extends JFrame{

    public MarcoMenu(){

        setBounds(0, 0, 600, 300);
        setTitle("JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LaminaMenu());
    }
}

class LaminaMenu extends JPanel{

    public LaminaMenu(){

        JMenuBar miBarra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edicion");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardarComo = new JMenuItem("Guardar Como");
        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("Primeros Pasos\\src\\graficos\\cortar.png"));
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("Pegar");
        JMenuItem generales = new JMenuItem("Generales");
        JMenuItem opcion1 = new JMenuItem("Opcion 1");
        JMenuItem opcion2 = new JMenuItem("Opcion 2");
        archivo.add(guardar);
        archivo.add(guardarComo);
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();
        edicion.add(opciones);
        opciones.add(opcion1);
        opciones.add(opcion2);
        herramientas.add(generales);
        miBarra.add(archivo);
        miBarra.add(edicion);
        miBarra.add(herramientas);
        add(miBarra);

    }
}