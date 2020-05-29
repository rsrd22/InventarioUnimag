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
public class ModeloElemento {
    private String id;
    private String descripcion_elemento;
    private String codigo_elemento;
    private String id_usuario;
    private String fecha;

    public ModeloElemento() {
        this.id = null;
        this.descripcion_elemento = null;
        this.codigo_elemento = null;
        this.id_usuario = null;
        this.fecha = null;
    }

    public ModeloElemento(String id, String descripcion_elemento, String codigo_elemento, String id_usuario, String fecha) {
        this.id = id;
        this.descripcion_elemento = descripcion_elemento;
        this.codigo_elemento = codigo_elemento;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion_elemento() {
        return descripcion_elemento;
    }

    public void setDescripcion_elemento(String descripcion_elemento) {
        this.descripcion_elemento = descripcion_elemento;
    }

    public String getCodigo_elemento() {
        return codigo_elemento;
    }

    public void setCodigo_elemento(String codigo_elemento) {
        this.codigo_elemento = codigo_elemento;
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
