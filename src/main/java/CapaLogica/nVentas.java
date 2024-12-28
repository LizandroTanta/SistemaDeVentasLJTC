/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mCompras;
import CapaDatos.mVentas;
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
public class nVentas {
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    
    String sql="";
    
    ResultSet rs;
    
    public DefaultTableModel mostrar(){
        DefaultTableModel modelo;
        
        String[] titulos = {"ID Producto", "Descripcón", "Cantidad", "Precio","IGV","Total"};
        modelo= new DefaultTableModel(null, titulos);
        String[] registro= new String[6];
        return modelo;
    }
    
    public DefaultTableModel mostrar1(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos = {"ID Venta", "ID Cliente", "Fecha", "Empleado","Comprobante","Número","Estado", "Sub Total", "Impuesto","Total"};
        modelo= new DefaultTableModel(null, titulos);
        String[] registro= new String[10];
        
        sql=("listarVentas'"+ buscar+"'");
        
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
                registro[6]= rs.getString(7);
                registro[7]= rs.getString(8);
                registro[8]= rs.getString(9);
                registro[9]= rs.getString(10);
                modelo.addRow(registro);
                
            }
            return modelo;
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
            
        }
    }
    
    public boolean insetarVenta(mVentas dts){
        
        String fecha, hora;
        
        fecha= funciones.getFechaActual();
        hora= funciones.getHoraActual();
        
        sql=("{call guardarVenta(?,?,?,?,?,?,?,?,?,?,?)}");
        
        try{
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fecha);
            pst.setString(2, hora);
            pst.setString(3, dts.getSerie());
            pst.setString(4, dts.getNumDocumento());
            pst.setString(5, dts.getTipoDocumento());
            pst.setDouble(6, dts.getSubTotal());
            pst.setDouble(7, dts.getIgv());
            pst.setDouble(8, dts.getTotal());
            pst.setString(9, dts.getEstado());
            pst.setInt(10, dts.getIdUsuario());
            pst.setString(11, dts.getIdCliente());
            
            int n= pst.executeUpdate();
            
            if (n!=0){
                return true;
            } else{
                return false;
            }
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public String IdVenta(){
        
        String idv="";
        sql= ("select max(idVenta) from Ventas");
        
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            rs= pst.executeQuery();
            
            while(rs.next()){
                idv=rs.getString(1);
            }
        }catch(SQLException e1){
            JOptionPane.showMessageDialog(null,"Error sql:"+ e1.getMessage());
            
        }
        return idv;
    }
    
    
    public int generarComprobanteFactura(){
        String sql= ("select max(numDocumento) as id from Ventas where tipoDocumento='Factura'");
        int cod = 0;
        
        try{
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            if(rs.next()){
                cod= rs.getInt("id")+1;
            }
        }catch(SQLException e1){
            JOptionPane.showMessageDialog(null,"Error sql:"+ e1.getMessage());
            
        }
        return cod;
    }
    
    public int generarComprobanteBoleta(){
        String sql= ("select max(numDocumento) as id from Ventas where tipoDocumento='Boleta'");
        int cod = 0;
        
        try{
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            if(rs.next()){
                cod= rs.getInt("id")+1;
            }
        }catch(SQLException e1){
            JOptionPane.showMessageDialog(null,"Error sql:"+ e1.getMessage());
            
        }
        return cod;
    }
    
}
