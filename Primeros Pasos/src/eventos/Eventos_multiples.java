package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Eventos_multiples {
    
    public static void main(String[] args) {
        
        Marco_eventos_multiples miMarco = new Marco_eventos_multiples();
        miMarco.setVisible(true);
    }
}

class Marco_eventos_multiples extends JFrame{

    public Marco_eventos_multiples(){

        setBounds(0, 0, 600, 300);
        setTitle("Eventos multiples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina_eventos_multiples miLamina = new Lamina_eventos_multiples();
        add(miLamina);
    }
}

class Lamina_eventos_multiples extends JPanel {


    public Lamina_eventos_multiples(){
        
        setBackground(Color.PINK);
        ActionColor accion_amarillo = new ActionColor("Amarillo", new ImageIcon("src/graficos/amarillo.jpg"), Color.YELLOW);
        ActionColor accion_azul = new ActionColor("Azul", new ImageIcon("src/graficos/azul.jpg"), Color.BLUE);
        ActionColor accion_rojo = new ActionColor("Rojo", new ImageIcon("src/graficos/rojo.jpg"), Color.RED);
        add(new JButton(accion_amarillo));  
        add(new JButton(accion_azul));
        add(new JButton(accion_rojo));

        InputMap mapa_de_entrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        mapa_de_entrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
        mapa_de_entrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
        mapa_de_entrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
        ActionMap mapa_accion = getActionMap();
        mapa_accion.put("fondo_amarillo", accion_amarillo);
        mapa_accion.put("fondo_azul", accion_azul);
        mapa_accion.put("fondo_rojo", accion_rojo);
    }

    private class ActionColor extends AbstractAction{

        public ActionColor(String nombre, Icon icono, Color color_boton){
    
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
            putValue("Color de fondo", color_boton);
    
        }
    
        public void actionPerformed(ActionEvent e){
    
            Color c = (Color)getValue("Color de fondo");
            setBackground(c);
            
        }
    }
    

}

