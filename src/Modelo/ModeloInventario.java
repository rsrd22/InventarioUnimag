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
public class ModeloInventario {
    private String id;
    private String codigo_elemento;
    private String id_elemento;
    private String descripcion_elemento;
    private String entradas;
    private String salidas;
    private String stock;

    public ModeloInventario() {
        this.id = null;
        this.codigo_elemento = null;
        this.id_elemento = null;
        this.descripcion_elemento = null;
        this.entradas = null;
        this.salidas = null;
        this.stock = null;
    }

    public ModeloInventario(String id, String codigo_elemento, String id_elemento, String descripcion_elemento, String entradas, String salidas, String stock) {
        this.id = id;
        this.codigo_elemento = codigo_elemento;
        this.id_elemento = id_elemento;
        this.descripcion_elemento = descripcion_elemento;
        this.entradas = entradas;
        this.salidas = salidas;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo_elemento() {
        return codigo_elemento;
    }

    public void setCodigo_elemento(String codigo_elemento) {
        this.codigo_elemento = codigo_elemento;
    }

    public String getId_elemento() {
        return id_elemento;
    }

    public void setId_elemento(String id_elemento) {
        this.id_elemento = id_elemento;
    }

    public String getDescripcion_elemento() {
        return descripcion_elemento;
    }

    public void setDescripcion_elemento(String descripcion_elemento) {
        this.descripcion_elemento = descripcion_elemento;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public String getSalidas() {
        return salidas;
    }

    public void setSalidas(String salidas) {
        this.salidas = salidas;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
}
