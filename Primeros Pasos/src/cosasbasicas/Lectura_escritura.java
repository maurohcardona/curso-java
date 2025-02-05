package cosasbasicas;

import java.io.*;


import java.io.IOException;

public class Lectura_escritura {
    public static void main(String[] args) {
        
        try {

            FileInputStream archivo = new FileInputStream("Primeros Pasos\\src\\graficos\\imagen1.jpg");

            boolean final_archivo = false;

            while (final_archivo != true) {
                int byte_entrada = archivo.read();
                if (byte_entrada != -1) {
                    System.out.println(byte_entrada);
                } else {
                    final_archivo = true;
                }    
            }

            archivo.close();
            
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}
