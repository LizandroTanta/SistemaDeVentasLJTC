/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lizandro Tanta
 */
public class nUsuario {
    
    private Conexion SQL = new Conexion();
    private Connection cn= SQL.conectar();
    
    String sql= "";
    
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        
        DefaultTableModel modelo;
        
        String[] titulos = {"ID Usuario", "ID Empleado", "Nombre","Apellidos","Usuario","Contraseña", "Acceso", "Estado"};
        modelo=new DefaultTableModel(null, titulos);
        
        String [] registro = new String[8];       
        
        sql= ("listarUsuario'"+buscar+"'");
        
        try{
            
            Statement st= cn.createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                registro[0]= rs.getString(1);
                registro[1]= rs.getString(2);
                registro[2]= rs.getString(3);
                registro[3]= rs.getString(4);
                registro[4]= rs.getString(5);
                registro[5]= rs.getString(6);
                registro[6]= rs.getString(7);
                registro[7]= rs.getString(8);
                modelo.addRow(registro);          
            }
            return modelo;
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }      
    }
    
    public boolean insertar(mUsuario dts){
        sql=("{call guardarUsuarios (?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dts.getIdEmpleado());
            pst.setString(2, dts.getUsuario());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getAcceso());
            pst.setString(5, dts.getEstado());
            
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
    
    public boolean editar(mUsuario dts){
        sql=("{call editarUsuarios (?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dts.getIdEmpleado());
            pst.setString(2, dts.getUsuario());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getAcceso());
            pst.setString(5, dts.getEstado());
            
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
    
    public boolean eliminar(mUsuario dts){
        sql=("{call eliminarUsuario (?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dts.getIdUsuario());
            
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
    
    
     public DefaultTableModel login(String usuario, String password){
        
        DefaultTableModel modelo;
        
        String[] titulos = {"ID Usuario", "ID Empleado", "Nombre","Apellidos","Usuario","Contraseña", "Acceso", "Estado"};
        modelo=new DefaultTableModel(null, titulos);
        
        String [] registro = new String[8];       
        
        sql= ("sesion'"+usuario+"','"+password+"'");
        totalRegistros=0;
        try{
            
            Statement st= cn.createStatement();
            
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                registro[0]= rs.getString(1);
                registro[1]= rs.getString(2);
                registro[2]= rs.getString(3);
                registro[3]= rs.getString(4);
                registro[4]= rs.getString(5);
                registro[5]= rs.getString(6);
                registro[6]= rs.getString(7);
                registro[7]= rs.getString(8);
                totalRegistros = totalRegistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
        
        
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }      
    }
}
