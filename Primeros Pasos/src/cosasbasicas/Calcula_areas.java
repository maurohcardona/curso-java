import java.util.Scanner;

import javax.swing.JOptionPane;

public class Calcula_areas {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        System.out.println("Elije una opcion: \n1: Cuadrado \n2: Rectangulo \n3: Triangulo \n4: Circulo");

        int forma = entrada.nextInt();

        switch (forma) {
            case 1: 

                int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce la medida de una de sus areas: "));

                double area_cuadrado = Math.pow(lado, 2);

                System.out.println("El area del cuadrado es igual a " + area_cuadrado );
                
                break;
            
            case 2:

                int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));

                int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));

                System.out.println("El area del rectangulo es: " + base*altura);

                break;
            
            case 3:

                int base_t = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));

                int altura_t = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));

                System.out.println("El area del rectangulo es: " + (base_t*altura_t/2));

                break;
            
            case 4:

                int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio del circulo: "));

                double area_c = Math.PI*Math.pow(radio,2);

                System.out.print("El area del rectangulo es: ");

                System.out.printf("%1.2f", area_c);

                break;
        
            default:

                System.out.println("La opcion ingresada no es valida");

                break;
        }
    }
}
