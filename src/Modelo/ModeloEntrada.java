/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author MERRY
 */
public class ModeloEntrada {
    private String id;
    private String id_elemento;
    private String codigo_elemento;
    private String descripcion_elemento;
    private String lote;
    private String concentracion;
    private String marca;
    private String presentacion;
    private String riesgo;
    private String reg_sanitario;
    private String semaforizacion;
    private String fecha_vencimiento;
    private String fecha_inicio;
    private String fecha_fin;
    private String cantidad;
    private String fecha_entrada;
    private String id_usuario;
    private String fecha;
    
    public ModeloEntrada() {
        this.id = null;
        this.id_elemento = null;
        this.codigo_elemento = null;
        this.descripcion_elemento = null;
        this.lote = null;
        this.concentracion = null;
        this.marca = null;
        this.presentacion = null;
        this.riesgo = null;
        this.reg_sanitario = null;
        this.semaforizacion = null;
        
        this.fecha_vencimiento = null;
        this.fecha_inicio = null;
        this.fecha_fin = null;
        this.cantidad = null;
        this.fecha_entrada = null;
        this.id_usuario = null;
        this.fecha = null;
    }

    public ModeloEntrada(String id, String id_elemento, String codigo_elemento, String descripcion_elemento, String lote, String concentracion, String marca, String presentacion, String riesgo, String reg_sanitario, String semaforizacion, String fecha_vencimiento, String fecha_inicio, String fecha_fin, String cantidad, String fecha_entrada, String id_usuario, String fecha) {
        this.id = id;
        this.id_elemento = id_elemento;
        this.codigo_elemento = codigo_elemento;
        this.descripcion_elemento = descripcion_elemento;
        this.lote = lote;
        this.concentracion = concentracion;
        this.marca = marca;
        this.presentacion = presentacion;
        this.riesgo = riesgo;
        this.reg_sanitario = reg_sanitario;
        this.semaforizacion = semaforizacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cantidad = cantidad;
        this.fecha_entrada = fecha_entrada;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_elemento() {
        return id_elemento;
    }

    public void setId_elemento(String id_elemento) {
        this.id_elemento = id_elemento;
    }

    public String getCodigo_elemento() {
        return codigo_elemento;
    }

    public void setCodigo_elemento(String codigo_elemento) {
        this.codigo_elemento = codigo_elemento;
    }

    public String getDescripcion_elemento() {
        return descripcion_elemento;
    }

    public void setDescripcion_elemento(String descripcion_elemento) {
        this.descripcion_elemento = descripcion_elemento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getReg_sanitario() {
        return reg_sanitario;
    }

    public void setReg_sanitario(String reg_sanitario) {
        this.reg_sanitario = reg_sanitario;
    }

    public String getSemaforizacion() {
        return semaforizacion;
    }

    public void setSemaforizacion(String semaforizacion) {
        this.semaforizacion = semaforizacion;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
