/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lizandro Tanta
 */
public class funciones {
    
    public static String getHoraActual(){
        
        Date hora = new Date();
        
        SimpleDateFormat formateador= new SimpleDateFormat("hh,mm,ss");
        return formateador.format(hora);
    }
    
    public static String getFechaActual(){
        
        Date hora = new Date();
        
        SimpleDateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(hora);
    }
    
}
