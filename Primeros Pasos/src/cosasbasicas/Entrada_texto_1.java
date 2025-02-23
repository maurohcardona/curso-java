package cosasbasicas;

import java.util.*;

public class Entrada_texto_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu nombre: ");

        String nombre_usuario = entrada.nextLine();

        System.out.println("Introduce tu edad: ");

        int edad_usuario = entrada.nextInt();

        entrada.close();

        System.out.println("Hola " + nombre_usuario + " tu edad es de " + edad_usuario + " anos");

	}

}
