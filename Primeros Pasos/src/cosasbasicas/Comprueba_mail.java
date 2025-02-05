package cosasbasicas;

import javax.swing.JOptionPane;

public class Comprueba_mail {
    public static void main(String[] args) {

        int arroba = 0;
        int punto = 0;
        
        String mail = JOptionPane.showInputDialog("Ingrese un mail");

        for(int i=0; i < mail.length(); i++) {

            if(mail.charAt(i)=='@') {
                
                arroba++;
            }
            if (mail.charAt(i)=='.') {

                punto++;
            }
            
        }

        if (arroba == 1 && punto >= 1) {
            
            System.out.println("El mail ingresado es un mail valido");

        }else  {
            
            System.out.println("El mail ingresado no es un mail valido");
        }
    }
}
