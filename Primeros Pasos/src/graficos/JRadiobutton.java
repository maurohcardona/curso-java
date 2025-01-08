package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadiobutton {
    public static void main(String[] args) {
        
        Marco_radiobutton miMarco = new Marco_radiobutton();
        miMarco.setVisible(true);
    }
}

class Marco_radiobutton extends JFrame{

    public Marco_radiobutton(){

        setBounds(0, 0, 600, 300);
        setTitle("JRadioButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Lamina_radiotexto lamina_radiotexto = new Lamina_radiotexto();
        Lamina_radiobotones lamina_radiobotones = new Lamina_radiobotones(lamina_radiotexto);
        add(lamina_radiotexto, BorderLayout.NORTH);
        add(lamina_radiobotones, BorderLayout.SOUTH);
    }
}

class Lamina_radiotexto extends JPanel{

    private JLabel texto;

    public Lamina_radiotexto(){

        Font miFuente = new Font("Arial", Font.PLAIN, 24);
        texto = new JLabel("En un rincon de la mancha...");
        texto.setFont(miFuente);
        add(texto);
    }

    public void cambio_fuente(int tamano){

        texto.setFont(new Font("Arial", Font.PLAIN, tamano));
    }
}

class Lamina_radiobotones extends JPanel{

    JRadioButton texto_chico;
    JRadioButton texto_mediano;
    JRadioButton texto_grande;
    Lamina_radiotexto lamina_radiotexto;

    public Lamina_radiobotones(Lamina_radiotexto lamina_radiotexto){

        this.lamina_radiotexto = lamina_radiotexto;
        ButtonGroup miGrupo = new ButtonGroup();
        texto_chico = new JRadioButton("Texto chico", false);
        texto_mediano = new JRadioButton("Texto mediano", true);
        texto_grande = new JRadioButton("Texto grande", false);
        miGrupo.add(texto_chico);
        miGrupo.add(texto_mediano);
        miGrupo.add(texto_grande);
        texto_chico.addActionListener(new Maneja_radiobutton(10, lamina_radiotexto));
        texto_mediano.addActionListener(new Maneja_radiobutton(24, lamina_radiotexto));
        texto_grande.addActionListener(new Maneja_radiobutton(36, lamina_radiotexto));
        add(texto_chico);
        add(texto_mediano);
        add(texto_grande);

    }
}

class Maneja_radiobutton implements ActionListener{

    int tamano;
    Lamina_radiotexto lamina_radiotexto;

    public Maneja_radiobutton(int tamano, Lamina_radiotexto lamina_radiotexto){

        this.lamina_radiotexto = lamina_radiotexto;
        this.tamano = tamano;

    }

    public void actionPerformed(ActionEvent e){

        lamina_radiotexto.cambio_fuente(tamano);
    }
}