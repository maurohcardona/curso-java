package cosasbasicas;

public class Ejemplo_array_2D {
    public static void main(String[] args) {
        
        double acumulado;

        double interes = 0.10;

        double [][] saldo = new double[6][5];

        for(int i=0; i<6; i++ ) {

            saldo[i][0] = 10000;
            acumulado = 10000;

            System.out.print(saldo[i][0] + " ");

            for(int j=0; i<5; i++) {

                acumulado += acumulado*interes;
                saldo[i][j] = acumulado;

                System.out.print(acumulado);

            }

            interes += 0.1;
            System.out.println("");
            
        }

        

    }
}
