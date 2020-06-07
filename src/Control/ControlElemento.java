/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import BaseDeDatos.gestorBD;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MERRY
 */
public class ControlElemento implements IControl {
    private gestorBD mySQL;
    private ArrayList<ModeloElemento> listaModelo;
    
    public ControlElemento(){
        mySQL = new gestorBD();
        listaModelo = new ArrayList<>();
    }

    @Override
    public Object ObtenerDatos() {
        String consulta = "SELECT Id AS  ID, descripcion AS DESCRIPCION, codigo_elemento AS CODIGO, id_usuario, fecha\n" +
                                    "FROM elementos\n" +
                                    "ORDER BY descripcion ASC";
        
        List<Map<String, String>> elementos = new ArrayList<Map<String, String>>();
        elementos = mySQL.ListSQL(consulta);
        ArrayList<ModeloElemento> listaModeloElementos = new ArrayList<>();
        if (elementos.size() > 0) {

            for (Map<String, String> inventario : elementos) {
                listaModeloElementos.add(new ModeloElemento(
                        inventario.get("ID"),
                        inventario.get("DESCRIPCION"),
                        inventario.get("CODIGO"),
                        inventario.get("id_usuario"),
                        inventario.get("fecha")
                ));
            }
            return listaModeloElementos;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Object ObtenerDatosKey(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Guardar(Object _elemento) {
        
        ArrayList<String> consultas = new ArrayList<>();
        ModeloElemento elemento = (ModeloElemento) _elemento;

        consultas.add(
                //<editor-fold defaultstate="collapsed" desc="INSERT">
                "INSERT INTO `elementos`\n" +
                    "(`id`, `codigo_elemento`, `descripcion`, `fecha`, `id_usuario`)\n "+
                    "VALUES (\n" +
                    ""+elemento.getId()+", "+
                    "'"+elemento.getCodigo_elemento()+"', "+
                    "'"+elemento.getDescripcion_elemento()+"', "+
                    ""+elemento.getFecha()+", "+ 
                    ""+elemento.getId_usuario()+");"
        //</editor-fold>
        );

        try {
            if(mySQL.EnviarConsultas(consultas)){
                return Retorno.EXITO;
            }else{
                return Retorno.ERROR;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());
            return Retorno.CLASE_NO_ENCONTRADA;
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            return Retorno.EXCEPCION_SQL;
        }
    }

    @Override
    public int Actualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Eliminar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerDatosFiltro(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID(String descripcion, String codigo) {
        String consulta = "SELECT id FROM `elementos` WHERE descripcion = '"+descripcion+"' AND codigo_elemento = '"+codigo+"'";
        
        String id = mySQL.SELECT(consulta).get(0)[0];
        
        return id;
    }
}
