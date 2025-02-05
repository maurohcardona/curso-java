package acceso_ficheros;

import java.io.*;

public class Creando {
    public static void main(String[] args) {

        File ruta = new File("C:\\Users\\mauro\\OneDrive\\Documentos\\Curso de Java\\Primeros Pasos\\Nuevo directorio");

        //ruta.mkdir();

        File archivo = new File("C:\\Users\\mauro\\OneDrive\\Documentos\\Curso de Java\\Primeros Pasos\\Nuevo directorio\\archivo.txt");

        try {

            archivo.createNewFile();
            

        } catch (IOException e) {

            System.out.println("No se ha podido crear el archivo");
        }

        Escribiendo accede_es = new Escribiendo();
        
        accede_es.escribir(archivo.getAbsolutePath(), true);
    }
}
