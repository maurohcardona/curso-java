package acceso_ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_fichero {
    public static void main(String[] args) {
        
        Escribiendo escribiendo = new Escribiendo();
        
        escribiendo.escribir("/home/mauro/Desktop/Texto2", true);
    }
}


class Escribiendo {
    

    public void escribir(String ruta, boolean append) {

        String frase = "Esto es una prueba de escritura 2";

        try {
            
            FileWriter escritura = new FileWriter(ruta, append);

            for (int i = 0; i < frase.length(); i++) {
                
                escritura.write(frase.charAt(i));
            }

            escritura.close();

        } catch (IOException e) {
            
            System.out.println("No se ha encontrado el archivo");
        }
        
    }
}