/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mProducto;
import CapaDatos.mProveedor;
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
public class nProducto {
    
    private Conexion SQL = new Conexion();
    private Connection cn= SQL.conectar();
    
    String sql= "";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos = {"ID", "Serie", "Nombre", "Fecha Ingreso","Fecha Vencimiento","Precio Compra","Precio Venta", "Cantidad", "ID Categoria", "Categoria"};
        modelo= new DefaultTableModel(null, titulos);
        String[] registro= new String[10];
        
        sql=("listarProducto'"+ buscar+"'");
        
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
    
    public boolean insertar(mProducto dts){
        sql=("{call guardarProducto (?,?,?,?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, dts.getIdProducto());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNombre());
            pst.setDate(4, dts.getfIngreso());
            pst.setDate(5, dts.getfVencimiento());
            pst.setDouble(6, dts.getpVenta());
            pst.setDouble(7, dts.getpCompra());
            pst.setInt(8, dts.getIdCategoria());
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    public boolean editar(mProducto dts){
        sql=("{call editarProducto (?,?,?,?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, dts.getIdProducto());
            pst.setString(2, dts.getSerie());
            pst.setString(3, dts.getNombre());
            pst.setDate(4, dts.getfIngreso());
            pst.setDate(5, dts.getfVencimiento());
            pst.setDouble(6, dts.getpVenta());
            pst.setDouble(7, dts.getpCompra());
            pst.setInt(8, dts.getIdCategoria());
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
            
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    public boolean eliminar(mProducto dts){
        sql = ("{call eliminarProducto(?)}");
        try{
            
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, dts.getIdProducto());
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            } else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public int generarIdProducto(){
        String sql= ("select max(idProducto) as id from Productos");
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
    
    public boolean disminuir(int idProducto, int cantidad){
        
        sql="update Productos set cantidad=cantidad-?"+"where idProducto=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setInt(2, idProducto);
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean aumentar(int idProducto, int cantidad){
        
        sql="update Productos set cantidad=cantidad+?"+"where idProducto=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setInt(2, idProducto);
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}
