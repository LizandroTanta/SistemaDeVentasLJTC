/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.sql.Date;

/**
 *
 * @author Lizandro Tanta
 */
public class mProducto {
    
    private String idProducto;
    private int idCategoria;
    private String serie;
    private String nombre;
    private Date fIngreso;
    private Date fVencimiento;
    private Double pVenta;
    private Double pCompra;

    public mProducto() {
    }

    public mProducto(String idProducto, int idCategoria, String serie, String nombre, Date fIngreso, Date fVencimiento, Double pVenta, Double pCompra) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.serie = serie;
        this.nombre = nombre;
        this.fIngreso = fIngreso;
        this.fVencimiento = fVencimiento;
        this.pVenta = pVenta;
        this.pCompra = pCompra;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getfIngreso() {
        return fIngreso;
    }

    public void setfIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }

    public Date getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(Date fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public Double getpVenta() {
        return pVenta;
    }

    public void setpVenta(Double pVenta) {
        this.pVenta = pVenta;
    }

    public Double getpCompra() {
        return pCompra;
    }

    public void setpCompra(Double pCompra) {
        this.pCompra = pCompra;
    }
    
    
    
    
}
