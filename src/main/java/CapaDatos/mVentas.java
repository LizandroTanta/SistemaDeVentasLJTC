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
public class mVentas {
    
    private int idVenta;
    private Date fecha;
    private String hora;
    private String serie;
    private String numDocumento;
    private String tipoDocumento;
    private Double subTotal;
    private Double igv;
    private Double total;
    private String estado;
    private int idUsuario;
    private String idCliente;

    public mVentas() {
    }

    public mVentas(int idVenta, Date fecha, String hora, String serie, String numDocumento, String tipoDocumento, Double subTotal, Double igv, Double total, String estado, int idUsuario, String idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.serie = serie;
        this.numDocumento = numDocumento;
        this.tipoDocumento = tipoDocumento;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
    
}
