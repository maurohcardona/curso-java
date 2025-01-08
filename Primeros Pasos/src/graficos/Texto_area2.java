package graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Texto_area2 {
    public static void main(String[] args) {
        
        Marco_texto_area2 miMarco = new Marco_texto_area2();
        miMarco.setVisible(true);
    }
}

class Marco_texto_area2 extends JFrame{

    private Lamina_texto_area2 lamina_texto_area2;
    private Lamina_botones botones;

    public Marco_texto_area2(){
        
        setBounds(0,0,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Area 2");
        setLayout(new BorderLayout());
        lamina_texto_area2 = new Lamina_texto_area2();
        botones = new Lamina_botones(lamina_texto_area2);
        add(lamina_texto_area2, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }
}

class Lamina_texto_area2 extends JPanel{

    private JTextArea miArea;
    private JScrollPane lamina_barras;

    public Lamina_texto_area2(){

        miArea = new JTextArea(10, 39);
        miArea.setLineWrap(false);
        lamina_barras = new JScrollPane(miArea);
        add(lamina_barras);
    }

    public void establece_texto(){

        miArea.append("En un lugar de la mancha, de cuyo nombre no quiero acordarme.");
    }

    public void salto_de_linea(){

       miArea.setLineWrap(!miArea.getLineWrap());
    }

    public boolean isLineWrap() {
        return miArea.getLineWrap();
    }
}

class Lamina_botones extends JPanel{

    private JButton boton_salto_linea;

    public Lamina_botones(Lamina_texto_area2 texto_area){

        JButton boton_insertar = new JButton("Insertar");
        boton_salto_linea = new JButton("Salto de linea desactivado");
        boton_insertar.addActionListener(new Evento_insertar(texto_area));
        boton_salto_linea.addActionListener(new Evento_salto_linea(texto_area, this));
        add(boton_insertar);
        add(boton_salto_linea);
    }

    public void cambio_nombre(boolean activado){

        if(activado){
            boton_salto_linea.setText("Salto de linea activado");
        }
        else{
            boton_salto_linea.setText("Salto de linea desactivado");
        }
    }
}

class Evento_insertar implements ActionListener{

    private Lamina_texto_area2 texto_area;

    public Evento_insertar(Lamina_texto_area2 texto_area){

        this.texto_area = texto_area;

    }

    public void actionPerformed(ActionEvent e) {
        
        texto_area.establece_texto();
    }    
}

class Evento_salto_linea implements ActionListener{

    private Lamina_texto_area2 texto_area;
    private Lamina_botones botones;

    public Evento_salto_linea(Lamina_texto_area2 texto_area, Lamina_botones botones){

        this.texto_area = texto_area;
        this.botones = botones;
    }

    public void actionPerformed(ActionEvent e){

        texto_area.salto_de_linea();
        botones.cambio_nombre(texto_area.isLineWrap());
    }
}