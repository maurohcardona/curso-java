package cosasbasicas;

import java.util.*;

public class Enum {

    // enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE}
    enum Talla {

        MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");

        private Talla(String abreviatura){

            this.abreviatura = abreviatura;
        }

        private String abreviatura;

        public String dame_abreviatura(){
            return abreviatura;
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Elija su Talla: Mini, Medaino, Grande, Muy grande");

        String entrada_datos = entrada.next().toUpperCase();

        Talla la_talla = Enum.Talla.valueOf(Talla.class, entrada_datos);

        System.out.println("Talla= " + la_talla);

        System.out.println("Abreviatura= " + la_talla.dame_abreviatura());
        

    }
}
