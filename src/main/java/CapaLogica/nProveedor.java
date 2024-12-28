/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

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
public class nProveedor {
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String[] titulos= {"ID", "Razón Social","Ruc","Telefono","Dirección"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[5];
        
        sql=("buscarProveedor'"+buscar+"'");
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                
                modelo.addRow(registro);
            }
            return modelo;
        } catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
            
        }      
    }
    
    public boolean insertar(mProveedor dts){
        sql=("{call guardarProveedor (?,?,?,?,?)}");
        
        try{
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,dts.getIdProveedor());
            pst.setString(2,dts.getRazonSocial());
            pst.setString(3,dts.getRuc());
            pst.setString(4,dts.getTelefono());
            pst.setString(5,dts.getDireccion());
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(mProveedor dts){
        sql=("{call editarProveedor (?,?,?,?,?)}");
        
        try{
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,dts.getIdProveedor());
            pst.setString(2,dts.getRazonSocial());
            pst.setString(3,dts.getRuc());
            pst.setString(4,dts.getTelefono());
            pst.setString(5,dts.getDireccion());
            
            int n= pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        } catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(mProveedor dts){
        
        sql=("{call eliminarProveedor (?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dts.getIdProveedor());
            
            int n= pst.executeUpdate();
            
            if (n!=0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public int generarIdProveedor(){
        String sql= ("select max(idProveedor) as id from Proveedor");
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
