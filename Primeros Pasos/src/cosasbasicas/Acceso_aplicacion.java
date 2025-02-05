package cosasbasicas;
import javax.swing.JOptionPane;

public class Acceso_aplicacion {
    public static void main(String[] args) {

        String contraseña_correcta = "estufa10";
        
        String contraseña = "";

        while (contraseña.equals(contraseña_correcta) == false) {

            contraseña = JOptionPane.showInputDialog("Ingrese la contraseña");

            if (contraseña.equals(contraseña_correcta) == false) {

                System.out.println("Contraseña Incorrecta");

            }
    
        }

        System.out.println("Contraseña correcta");
    }
}
