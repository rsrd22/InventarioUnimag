/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import BaseDeDatos.gestorBD;
import General.Utilidades;
import Modelo.ModeloEntrada;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MERRY
 */
public class ControlEntrada implements IControl{
    private gestorBD mySQL;
    private ArrayList<ModeloEntrada> listaModelo;
    
    public ControlEntrada(){
        mySQL = new gestorBD();
        listaModelo = new ArrayList<>();
    }

    @Override
    public Object ObtenerDatos() {
        String consulta = "Select ent.id as ID, ele.id as IDELEMENTO, ele.codigo_elemento as CODELEMENTO, ele.descripcion as DESCELEMENTO,\n" +
                            "ent.lote as LOTE, ent.concentracion as CONCENTRACION, ent.marca as MARCA, ent.presentacion_comercial as PRESENTACION,\n" +
                            "ent.riesgo as RIESGO, ISNULL(ent.registro_sanitario) as REGSANITARIO, ent.semaforizacion as SEMAFORIZACION, Format(ent.fecha_vencimiento, \"Short Date\") as FECHA_VENCIMIENTO, \n" +
                            " Format(ent.fecha_inicio, \"Short Date\")  as FECHA_INICIO,  Format(ent.fecha_fin, \"Short Date\") as FECHA_FIN,  ent.cantidad as CANTIDAD,\n" +
                            "  Format(ent.fecha_entrada, \"Short Date\") as FECHA_ENTRADA,\n" +
                            "ent.id_usuario as ID_USUARIO, Format(ent.fecha, \"Short Date\") as FECHA\n" +
                            "from entradas ent \n" +
                            "inner join elementos ele on ele.id = ent.id_elemento\n" +
                            "order by ent.fecha desc";
        
        System.out.println("consulta-->"+consulta);
        List<Map<String, String>> entradas = new ArrayList<Map<String, String>>();
        entradas = mySQL.ListSQL(consulta);
        ArrayList<ModeloEntrada> listaModeloEntradas = new ArrayList<>();
        if (entradas.size() > 0) {
            //String id, String id_elemento, String codigo_elemento, String descripcion_elemento, 
            //String lote, String concentracion, String marca, String presentacion, String riesgo, 
            //String reg_sanitario, String semaforizacion, String fecha_vencimiento, 
            //String fecha_inicio, String fecha_fin, String cantidad, String fecha_entrada, String id_usuario, String fecha
            for (Map<String, String> entrada : entradas) {
                listaModeloEntradas.add(
                        new ModeloEntrada(entrada.get("ID"), entrada.get("IDELEMENTO"),
                                entrada.get("CODELEMENTO"), entrada.get("DESCELEMENTO"), 
                                entrada.get("LOTE"), entrada.get("CONCENTRACION"), entrada.get("MARCA"), 
                                entrada.get("PRESENTACION"), entrada.get("RIESGO"), entrada.get("REGSANITARIO"), 
                                entrada.get("SEMAFORIZACION"), entrada.get("FECHA_VENCIMIENTO"), entrada.get("FECHA_INICIO"), 
                                entrada.get("FECHA_FIN"), entrada.get("CANTIDAD"), entrada.get("FECHA_ENTRADA"), 
                                entrada.get("ID_USUARIO"), entrada.get("FECHA"))
                );
            }
            return listaModeloEntradas;
        } else {
            return new ArrayList<>();
        }
    }
    
    @Override
    public Object ObtenerDatosKey(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Guardar(Object _entrada) {
        
        ArrayList<String> consultas = new ArrayList<>();
        ModeloEntrada entrada = (ModeloEntrada) _entrada;

        consultas.add(
                //<editor-fold defaultstate="collapsed" desc="INSERT">
                "INSERT INTO entradas\n" +
                    "(id, id_elemento, lote, concentracion, marca, \n" +
                    "presentacion_comercial, riesgo, registro_sanitario,semaforizacion, fecha_vencimiento, \n" +
                    "fecha_inicio, fecha_fin, cantidad, fecha_entrada, id_usuario, fecha)\n" +
                    "VALUES\n" +
                    "("+entrada.getId()+", "+entrada.getId_elemento()+", '"+entrada.getLote()+"', '"+entrada.getConcentracion()+"', '"+entrada.getMarca()+"', \n" +
                    "'"+entrada.getPresentacion()+"', '"+entrada.getRiesgo()+"', '"+entrada.getReg_sanitario()+"','"+entrada.getSemaforizacion()+"', "+Utilidades.ValorNULL(entrada.getFecha_vencimiento())+", \n" +
                    ""+Utilidades.ValorNULL(entrada.getFecha_inicio())+", "+Utilidades.ValorNULL(entrada.getFecha_fin())+", "+entrada.getCantidad()+", "+Utilidades.ValorNULL(entrada.getFecha_entrada())+", "+entrada.getId_usuario()+", "+entrada.getFecha()+");"
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
    public int Actualizar(Object _entrada) {
        ArrayList<String> consultas = new ArrayList<>();
        ModeloEntrada entrada = (ModeloEntrada) _entrada;

        consultas.add(
            //<editor-fold defaultstate="collapsed" desc="UPDATE SALIDAS">
                "UPDATE `entradas`\n" +
                    "SET `lote` = '"+entrada.getLote()+"',\n" +
                    "  `concentracion` = '"+entrada.getConcentracion()+"',\n" +
                    "  `marca` = '"+entrada.getMarca()+"',\n" +
                    "  `presentacion_comercial` = '"+entrada.getPresentacion()+"',\n" +
                    "  `riesgo` = '"+entrada.getRiesgo()+"',\n" +
                    "  `registro_sanitario` = '"+entrada.getMarca()+"',\n" +
                    "  `semaforizacion` = '"+entrada.getSemaforizacion()+"',\n" +
                    "  `fecha_vencimiento` = "+Utilidades.ValorNULL(entrada.getFecha_vencimiento())+",\n" +
                    "  `fecha_inicio` = "+Utilidades.ValorNULL(entrada.getFecha_inicio())+",\n" +
                    "  `fecha_fin` = "+Utilidades.ValorNULL(entrada.getFecha_fin())+",\n" +
                    "  `cantidad` = "+entrada.getCantidad()+",\n" +
                    "  `fecha_entrada` = "+Utilidades.ValorNULL(entrada.getFecha_entrada())+",\n" +
                    "  `id_usuario` = "+entrada.getId_usuario()+",\n" +
                    "  `fecha` = "+entrada.getConcentracion()+"\n" +
                    "WHERE `id` = "+entrada.getId()+";"
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
    public int Eliminar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObtenerDatosFiltro(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
