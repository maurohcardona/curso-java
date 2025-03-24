package proyecto.swing;

import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import proyecto.ConnectionBBDD;

public class VentanaMedio extends JPanel{

    private JTextArea area_texto;

    public VentanaMedio(){

        area_texto = new JTextArea(30,30);
        area_texto.setLineWrap(true);
        area_texto.setWrapStyleWord(true);
        area_texto.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(area_texto);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setTotales();

        add(scrollPane);
    }

    public void set_resultado(String texto){

        area_texto.append(texto);
    }

    public void setBlanc(){

        area_texto.setText("");
    }

    public void setTotales(){

        ConnectionBBDD miConexion = new ConnectionBBDD();

        ResultSet totales = miConexion.getTotales();

        try {

            area_texto.setText("");
            
            while (totales.next()) {
                
                area_texto.append("  " + totales.getString("NOMBRE") + " " + totales.getString("MARCA") + " $" + totales.getString("PRECIO") + "\n"); 
            
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}