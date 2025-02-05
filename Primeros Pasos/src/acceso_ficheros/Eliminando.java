package acceso_ficheros;

import java.io.*;

public class Eliminando {
    public static void main(String[] args) {
        
        File archivo = new File("C:\\Users\\mauro\\OneDrive\\Documentos\\Curso de Java\\Primeros Pasos\\Nuevo directorio\\archivo.txt");
        
        archivo.delete();
    }
}
