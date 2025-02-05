package cosasbasicas;

import javax.swing.JOptionPane;

public class Entrada_ejemplo_2 {
    public static void main(String[] args) {
        
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre: ");

        String edad = JOptionPane.showInputDialog("Introduce tu edad");

        Integer.parseInt(edad);

        System.out.println("Hola, tu nombre es " + nombre + ", y tienes " + edad + " años");
    }
}
