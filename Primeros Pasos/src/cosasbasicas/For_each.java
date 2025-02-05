package cosasbasicas;

import java.util.Random;

public class For_each {
    public static void main(String[] args) {
        
        int[] matriz_aleatorios = new int[150];

        Random random = new Random();
        
        for(int i=0; i<matriz_aleatorios.length; i++) {

            matriz_aleatorios[i] = random.nextInt(100);

        }

        for (int numeros : matriz_aleatorios) {
            
            System.out.println(numeros);
        }
    }
}
