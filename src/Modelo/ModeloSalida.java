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
public class ModeloSalida {
    private String id;
    private String id_elemento;
    private String codigo_elemento;
    private String descripcion_elemento;
    private String lote;
    private String cantidad;
    private String id_responsable;
    private String fecha_salida;
    private String id_usuario;
    private String fecha;
    
    public ModeloSalida() {
        this.id = null;
        this.id_elemento = null;
        this.codigo_elemento = null;
        this.descripcion_elemento = null;
        this.lote = null;
        this.cantidad = null;
        this.id_responsable = null;
        this.fecha_salida = null;
        this.id_usuario = null;
        this.fecha = null;
    }

    public ModeloSalida(String id, String id_elemento, String codigo_elemento, String descripcion_elemento, String lote, String cantidad, String id_responsable, String fecha_salida, String id_usuario, String fecha) {
        this.id = id;
        this.id_elemento = id_elemento;
        this.codigo_elemento = codigo_elemento;
        this.descripcion_elemento = descripcion_elemento;
        this.lote = lote;
        this.cantidad = cantidad;
        this.id_responsable = id_responsable;
        this.fecha_salida = fecha_salida;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(String id_responsable) {
        this.id_responsable = id_responsable;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
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
