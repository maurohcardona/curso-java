package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Barra_herramientas {
    public static void main(String[] args) {
        
        MarcoBarra miMarco = new MarcoBarra();
        miMarco.setVisible(true);
        
    }
}

class MarcoBarra extends JFrame{
    
    JPanel lamina; 

    public MarcoBarra(){
        
        setBounds(50, 50, 500, 300);
        setTitle("Barra de Herramientas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lamina = new JPanel();
        add(lamina);
        
        Action accionAzul = new ActionColor("Azul", new ImageIcon("Primeros Pasos\\src\\graficos\\azul.jpg"), Color.BLUE);
        Action accionAmarillo = new ActionColor("Amarillo", new ImageIcon("Primeros Pasos\\src\\graficos\\amarillo.jpg"), Color.YELLOW);
        Action accionRojo = new ActionColor("Rojo", new ImageIcon("Primeros Pasos\\src\\graficos\\rojo.jpg"), Color.RED);

        Action accionSalir = new AbstractAction("Salir", new ImageIcon("Primeros Pasos\\src\\graficos\\azul.jpg")) {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        JMenu menu = new JMenu("Color");
        menu.add(accionAzul);
        menu.add(accionAmarillo);
        menu.add(accionRojo);

        JMenuBar barraMenues = new JMenuBar();
        barraMenues.add(menu);
        setJMenuBar(barraMenues);

        JToolBar barra = new JToolBar();
        barra.add(accionAzul);
        barra.add(accionAmarillo);
        barra.add(accionRojo);
        barra.addSeparator();
        barra.add(accionSalir);
        add(barra, BorderLayout.NORTH);
    }

    private class ActionColor extends AbstractAction{
        
        public ActionColor(String nombre, Icon icono, Color color_boton){
            
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
            putValue("color_de_fondo", color_boton);
        }
        
        public void actionPerformed(ActionEvent e) {
            
            Color c = (Color) getValue("color_de_fondo");
            lamina.setBackground(c);
        }
    }
}
