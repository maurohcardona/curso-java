package cosasbasicas;

import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;


public class Debug {
    public static void main(String[] args) {
        
        int elementos = parseInt(JOptionPane.showInputDialog("Introduce la cantidad de elementos"));

        int[] numeros = new int[elementos];

        for (int i = 0; i < elementos; i++) {
            
            numeros[i] = (int)(Math.random() * 100);
        }

        for(int numero: numeros){
            System.out.println(numero);
        }
    }

}
