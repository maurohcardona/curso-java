package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jcheckbox {
    public static void main(String[] args) {

        Marco_checkbox miMarco = new Marco_checkbox();
        miMarco.setVisible(true);
    }
}

class Marco_checkbox extends JFrame{

    public Marco_checkbox(){
        
        setTitle("Jcheckbox");
        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Lamina_checkbox_texto lamina_texto = new Lamina_checkbox_texto();
        add(lamina_texto, BorderLayout.NORTH);
        add(new Lamina_botones_checkbox(lamina_texto), BorderLayout.SOUTH);
    }
}

class Lamina_checkbox_texto extends JPanel{

    JLabel texto;

    public Lamina_checkbox_texto(){

        Font miFuente = new Font("Arial", Font.PLAIN, 24);
        texto = new JLabel("En un lugar de la mancha, de cuyo nombre...");
        texto.setFont(miFuente);
        add(texto);
    }

    public void cambio_fuente(int tipo){

        texto.setFont(new Font("Arial", tipo, 24));
    }
}

class Lamina_botones_checkbox extends JPanel{

    JCheckBox boton1, boton2;
   
    public Lamina_botones_checkbox(Lamina_checkbox_texto lamina_texto){

        setLayout(new GridLayout(1,2));
        boton1 = new JCheckBox("Negrita");
        boton2 = new JCheckBox("Cursiva");
        add(boton1);
        add(boton2);
        boton1.addActionListener(new Maneja_checkbox(boton1, boton2, lamina_texto));
        boton2.addActionListener(new Maneja_checkbox(boton1, boton2, lamina_texto));
    }
}

class Maneja_checkbox implements ActionListener{

    JCheckBox boton1, boton2;
    Lamina_checkbox_texto lamina_texto;

    public Maneja_checkbox(JCheckBox boton1, JCheckBox boton2, Lamina_checkbox_texto lamina_texto){

        this.boton1 = boton1;
        this.boton2 = boton2;
        this.lamina_texto = lamina_texto;
    }

    public void actionPerformed(ActionEvent e){

        int tipo = 0;
        if(boton1.isSelected()) tipo+= Font.BOLD;
        if(boton2.isSelected()) tipo+= Font.ITALIC;
        lamina_texto.cambio_fuente(tipo);

    }
}