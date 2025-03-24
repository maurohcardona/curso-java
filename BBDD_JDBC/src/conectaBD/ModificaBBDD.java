package conectaBD;

import java.sql.*;

public class ModificaBBDD {
    public static void main(String[] args) {
        
        try {
            // Crear conexion
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/salvadora", "root", "estufa10");

            // Crear objeto statement
            Statement miStatement = miConexion.createStatement();

            //String instruccionSql = "INSERT INTO PRODUCTO (COD_PRODUCTO,NOMBRE,MARCA,COLOR,MODELO,STOCK,PRECIO) VALUES (NULL,'XBOX','MICROSOFT','NEGRA','SERIES X',15,700);";

            // String instruccionSql = "UPDATE PRODUCTO SET PRECIO=PRECIO*2 WHERE COD_PRODUCTO=123;";

            String instruccionSql = "DELETE FROM PRODUCTO WHERE COD_PRODUCTO=123;";

            miStatement.executeUpdate(instruccionSql);

            System.out.println("Datos insertados");
            
        } catch (Exception e) {
            
            System.err.println("No conecta");

            e.printStackTrace();
        }
    }
}
    

