/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizandro Tanta
 */
public class nCategoria {
    
    private Conexion SQL = new Conexion();
    private Connection cn= SQL.conectar();
    
    String sql= "";
    
    public boolean insertar(mCategoria dts){
        sql=("{call registrarCategoria (?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, dts.getnCategoria());
            
            int n= pst.executeUpdate();
            
            if(n !=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
