package acceso_ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_fichero {
    public static void main(String[] args) {
        
        Leer_Fichero accediendo = new Leer_Fichero();
        
        accediendo.leer();
    }
}

class Leer_Fichero {

    public void leer() {

        try {
            
            FileReader entrada = new FileReader("/home/mauro/Desktop/Texto");

            BufferedReader mibuffer = new BufferedReader(entrada);

            String linea = "";

            while (linea != null) {
                
                linea = mibuffer.readLine();
                
                if (linea != null) {
                    
                    System.out.println(linea);
                }
            }

            entrada.close();

        } catch (IOException e) {
            
            System.out.println("No se ha encontrado el archivo");
        }
        
    }
}