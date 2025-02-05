package cosasbasicas;

import java.util.Scanner;

public class Evalua_edad {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu edad: ");
        
        int edad = entrada.nextInt();

        if (edad <= 18) {
            System.out.println("Eres menor de edad");
        } else if ( edad < 40){
            System.out.println("Eres mayor de edad pero no tan grande");
        }else {
            System.out.println("Eres viejo");
        }
    }
}
