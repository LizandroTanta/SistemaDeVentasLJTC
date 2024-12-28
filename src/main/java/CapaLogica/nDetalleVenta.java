/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mDetalleDeCompra;
import CapaDatos.mDetalleVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lizandro Tanta
 */
public class nDetalleVenta {
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos = {"ID Venta", "ID Producto", "Producto", "Cantidad","Precio Venta","Total"};
        modelo= new DefaultTableModel(null, titulos);
        String[] registro= new String[6];
        
        sql=("listarDetalleVenta'"+ buscar+"'");
        
        try{
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while (rs.next()){
                registro[0]= rs.getString(1);
                registro[1]= rs.getString(2);
                registro[2]= rs.getString(3);
                registro[3]= rs.getString(4);
                registro[4]= rs.getString(5);
                registro[5]= rs.getString(6);  
                modelo.addRow(registro);
                
            }
            return modelo;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
            
        }
    }
    
    public boolean insertarDetalleVenta(mDetalleVentas dts){
        
        sql=("{call guardarDetalleVenta (?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setInt(1,dts.getIdVenta());
            pst.setString(2,dts.getIdProducto());
            pst.setInt(3,dts.getCantidad());
            pst.setDouble(4,dts.getPrecio());
            pst.setDouble(5,dts.getTotal()); 
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            } else{
                return false;
            }
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
}
