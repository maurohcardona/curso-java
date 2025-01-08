import javax.swing.JOptionPane;

public class Peso_ideal {
    public static void main(String[] args) {

        String sexo = "";

        do {

            sexo = JOptionPane.showInputDialog("Ingrese 'H' para hombre o 'M' para mujer");
            
        } while (sexo.equalsIgnoreCase("H") == false && (sexo.equalsIgnoreCase("M") == false));
        
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su altura en cm"));

        int peso_ideal = 0;

        if (sexo.equalsIgnoreCase("H")) {

            peso_ideal = altura - 110;
        
        }else if (sexo.equalsIgnoreCase("M")) {
            
            peso_ideal = altura - 120;
            
        }

        System.out.println("Tu peso ideal es de " + peso_ideal + "kg");

    }
}
