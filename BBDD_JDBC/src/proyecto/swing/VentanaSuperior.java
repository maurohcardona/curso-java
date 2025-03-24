package proyecto.swing;

import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import proyecto.ConnectionBBDD;

public class VentanaSuperior extends JPanel {
    
    private JComboBox<String> menu_marca, menu_precio;

    private TreeSet<String> lista_marca, lista_precio;

    public VentanaSuperior(){

        ConnectionBBDD miConexion = new ConnectionBBDD();
        
        lista_marca = miConexion.getColumna("MARCA");
        lista_precio = miConexion.getColumna("PRECIO");

        menu_marca = new JComboBox<>();
        menu_precio = new JComboBox<>();
        
        for(String marca : lista_marca) {

            menu_marca.addItem(marca);
        }

        for(String precio : lista_precio) {

            menu_precio.addItem(precio);
        }

        add(menu_marca);
        add(menu_precio);

    }

    public String getMarca(){

        if(menu_precio.getSelectedItem().toString().equalsIgnoreCase("todos")) return null;

        return menu_marca.getSelectedItem().toString();
    }

    public String getPrecio(){

        if(menu_precio.getSelectedItem().toString().equalsIgnoreCase("todos")) return null;

        return menu_precio.getSelectedItem().toString();
    }
}
