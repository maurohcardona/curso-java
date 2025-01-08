package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Oyentes_multiples {
    public static void main(String[] args) {

        Marco_oyentes marco_principal = new Marco_oyentes();
        marco_principal.setTitle("Marco principal");
        marco_principal.setVisible(true);
        
    }
}

class Marco_oyentes extends JFrame{

    public Marco_oyentes(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina_oyente miLamina = new Lamina_oyente();
        add(miLamina);
        
    }
}

class Lamina_oyente extends JPanel{

    JButton boton_cerrar;

    public Lamina_oyente(){

        ActionAbrirVentana abrir_nueva_ventana = new ActionAbrirVentana("Nueva ventana", new ImageIcon("src/graficos/amarillo.jpg"));
        add(new JButton(abrir_nueva_ventana));
        boton_cerrar = new JButton("Cerrar todo");
        add(boton_cerrar);
        

    }

    private class ActionAbrirVentana extends AbstractAction{

        public ActionAbrirVentana(String nombre, Icon icono){

            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Abre una nueva ventana");
        }

        public void actionPerformed(ActionEvent e){

            Marco_emergente nuevo_marco = new Marco_emergente(boton_cerrar);
            nuevo_marco.setVisible(true);

        }
    }
}

class Marco_emergente extends JFrame{

    private static int contador = 0;

    public Marco_emergente(JButton boton_de_principal){
        
        contador++;
        setTitle("Marco numero: " + contador);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(contador*40, contador*40, 600, 300);
        Cierra_todos cerrar_ventanas =  new Cierra_todos();
        boton_de_principal.addActionListener(cerrar_ventanas);
        
    }

    private class Cierra_todos implements ActionListener{

        public void actionPerformed(ActionEvent e){

            dispose();

        }
    }
}
