/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lizandro Tanta
 */
public class Conexion {
    static Connection conn = null;
    
    public static Connection conectar(){
        
        String url= "jdbc:sqlserver://localhost\\DESKTOP-7C286SS:1433;databaseName=dbSVentas;Encrypt=True;TrustServerCertificate=True";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch(ClassNotFoundException e){
            System.out.println("error de sql"+ e.getMessage());
            
        }
        
        try{
            conn = DriverManager.getConnection(url, "sa", "root");
        }catch(SQLException e){
            System.out.println("Error de conexion con el driver"+ e.getMessage());
            
        }
        return conn;
    }
    
}
