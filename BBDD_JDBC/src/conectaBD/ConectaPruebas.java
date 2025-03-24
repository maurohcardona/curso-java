package conectaBD;

import java.sql.*;

class ConectaPruebas {
    public static void main(String[] args) {
        
        try {
            // Crear conexion
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/salvadora", "root", "estufa10");

            // Crear objeto statement
            Statement miStatement = miConexion.createStatement();

            // Ejecutar sql
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTO");

            // Recorrer el resulset
            while (miResultSet.next()) {
                
                System.out.println(miResultSet.getString("COD_PRODUCTO") + " " + (miResultSet.getString("NOMBRE")) + " " + (miResultSet.getString("PRECIO")));
            }
        } catch (Exception e) {
            
            System.err.println("No conecta");

            e.printStackTrace();
        }
    }
}