package cosasbasicas;
import javax.swing.JOptionPane;

public class Arrays_2 {
    public static void main(String[] args) {
        
        String [] paises = new String[8];

        for (int i=0; i<paises.length; i++) {

            paises[i] = JOptionPane.showInputDialog("Ingrese el pais " + (i+1));
        }

        

        for (String elemento: paises) {

            System.out.println(elemento);
        }
    }
}
