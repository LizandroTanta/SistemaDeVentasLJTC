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
public class mCompras {
    
    private int idCompra;
    private Date fecha;
    private String hora;
    private String numDocumento;
    private String tipDocumento;
    private Double subTotal;
    private Double igv;
    private Double total;
    private String estado;
    private int idUsuario;
    private String idProveedor;

    public mCompras() {
    }
    
    

    public mCompras(int idCompra, Date fecha, String hora, String numDocumento, String tipDocumento, Double subTotal, Double igv, Double total, String estado, int idUsuario, String idProveedor) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.hora = hora;
        this.numDocumento = numDocumento;
        this.tipDocumento = tipDocumento;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idProveedor = idProveedor;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTipDocumento() {
        return tipDocumento;
    }

    public void setTipDocumento(String tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    
}
