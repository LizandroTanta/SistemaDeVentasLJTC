/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.mEmpleado;
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
public class nEmpleado {
    
    private Conexion SQL = new Conexion();
    private Connection cn= SQL.conectar();
    
    String sql= "";
    
    
    public DefaultTableModel mostrar(String buscar){
        
        DefaultTableModel modelo;
        
        String[] titulos = {"Codigo: ", "Nombre", "Apellidos:","DNI","Telefono","Dirección"};
        modelo=new DefaultTableModel(null, titulos);
        
        String [] registro = new String[6];       
        
        sql= ("buscarEmpleado'"+buscar+"'");
        
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
                
                modelo.addRow(registro);
                
            }
            return modelo;
        
        
        } catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }      
    }
    
    public boolean insertar(mEmpleado dts){
        
        sql= ("{call guardarEmpleado (?,?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1,dts.getIdEmpleado());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());
            
            int n = pst.executeUpdate();
            
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
    
    public boolean editar(mEmpleado dts){
        
        sql= ("{call editarEmpleado (?,?,?,?,?,?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1,dts.getIdEmpleado());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());
            
            int n = pst.executeUpdate();
            
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
    
    public boolean eliminar(mEmpleado dts){
        
        sql= ("{call eliminarEmpleado (?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1,dts.getIdEmpleado());
            
            
            int n = pst.executeUpdate();
            
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
    
    public int generarIdEmpleado(){
        String sql= ("select max(idEmpleado) as id from Empleados");
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
    

    

