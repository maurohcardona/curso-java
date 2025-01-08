import java.util.Random;

import javax.swing.JOptionPane;

public class Adivinar_numero {
    public static void main(String[] args) {

        int contador = 0;

        Random random = new Random();

        int num_random = random.nextInt(100);

        int num_jugador = 110;

        while (num_jugador != num_random) {

            num_jugador = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero a adivinar"));

            if (num_jugador > num_random) {

                System.out.println("El numero a adivinar es menor");
        
            } else if (num_jugador < num_random) {
                
                System.out.println("El numero a adivinar es mayor");

            }

            contador++;
        }

        System.out.println("Numero acertado");
        System.out.println("Numero de intentos: " + contador);

    }
}
