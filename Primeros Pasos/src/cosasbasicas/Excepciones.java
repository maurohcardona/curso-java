package cosasbasicas;

import static java.lang.Integer.parseInt;

import javax.swing.JOptionPane;

public class Excepciones {
    public static void main(String[] args) {
        
        try {
            diviciones();
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por 0");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("No has introducido un número");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
        }
        
    }

    public static void diviciones(){

        int num1 = parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
        int num2 = parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
        
        System.out.println("El resultado es: " + num1/num2);
    }
}