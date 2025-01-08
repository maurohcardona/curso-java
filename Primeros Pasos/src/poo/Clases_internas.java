package poo;
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

import javax.swing.Timer;

public class Clases_internas {
    public static void main(String[] args) {
        
        Reloj miReloj = new Reloj(3000, true);

        miReloj.enMarcha();

        JOptionPane.showMessageDialog(null,"Pulsa aceptar para detener");

        System.exit(0);
    }
}

class Reloj {

    private int intervalo;
    private boolean sonido;

    public Reloj(int intervalo, boolean sonido){

        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void enMarcha(){

        ActionListener oyente = new DameLaHora2();

        Timer mitemporizador = new Timer(intervalo, oyente);

        mitemporizador.start();
    }

    private class DameLaHora2 implements ActionListener {

        public void actionPerformed(ActionEvent e){

            Date ahora = new Date();

            System.out.println("Te pongo la hora cada 3 sg " + ahora);

            if(sonido){
                
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }
}
