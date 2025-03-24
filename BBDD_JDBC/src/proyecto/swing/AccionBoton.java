package proyecto.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import proyecto.ConnectionBBDD;


public class AccionBoton implements ActionListener {

    private VentanaMedio lamina;
    private String marca;
    private String precio;

    public AccionBoton(VentanaMedio lamina, String marca, String precio) {

        this.lamina = lamina;
        this.marca = marca;
        this.precio = precio;

    }
    
    public void actionPerformed(ActionEvent e){

        ConnectionBBDD miConexion = new ConnectionBBDD();

        ResultSet resultado = miConexion.getResultSet(marca, precio);

        try {

            lamina.setBlanc();
            
            while(resultado.next()){

                lamina.set_resultado("  " + resultado.getString("NOMBRE") + " " + resultado.getString("MARCA") + " $" + resultado.getString("PRECIO") + "\n");
                
            }
        } catch (Exception e1) {

            e1.printStackTrace();
        }
    }
}
