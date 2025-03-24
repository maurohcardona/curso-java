// package proyecto.swing;

// import javax.swing.JButton;
// import javax.swing.JPanel;

// public class VentanaInferior extends JPanel {
    
//     private JButton boton_consulta;
//     private VentanaSuperior lamina_superior;
//     private VentanaMedio lamina_medio;

//     public VentanaInferior(VentanaMedio lamina_medioo, VentanaSuperior lamina_superiorr){

//         this.lamina_medio = lamina_medioo;
//         this.lamina_superior = lamina_superiorr;

//         boton_consulta = new JButton("Consulta");

//         boton_consulta.addActionListener(new AccionBoton(lamina_medio, lamina_superior.getMarca(), lamina_superior.getPrecio()));
 
//         add(boton_consulta);
//     }

// }


package proyecto.swing;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaInferior extends JPanel {

    private JButton boton_consulta;
    private VentanaSuperior lamina_superior;
    private VentanaMedio lamina_medio;

    public VentanaInferior(VentanaMedio lamina_medio0, VentanaSuperior lamina_superiorr) {
        this.lamina_medio = lamina_medio0;
        this.lamina_superior = lamina_superiorr;

        boton_consulta = new JButton("Consulta"); 

        boton_consulta.addActionListener(e -> {
            String marca = lamina_superior.getMarca();
            String precio = lamina_superior.getPrecio();
            new AccionBoton(lamina_medio, marca, precio).actionPerformed(e);
        });

        add(boton_consulta);
    }
}
