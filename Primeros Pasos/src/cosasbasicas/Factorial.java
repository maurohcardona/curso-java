package cosasbasicas;

import javax.swing.JOptionPane;

public class Factorial {
    public static void main(String[] args) {
        
        int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero"));

        int resultado = num;

        for(int i= num-1; i>0; i-- ){

            resultado *= i; 

        }

        System.out.println(resultado);

    }
}
