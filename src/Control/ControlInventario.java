/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import BaseDeDatos.gestorBD;
import Modelo.ModeloInventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MERRY
 */
public class ControlInventario  implements IControl{
    private gestorBD mySQL;
    private ArrayList<ModeloInventario> listaModelo;
    
    public ControlInventario(){
        mySQL = new gestorBD();
        listaModelo = new ArrayList<>();
    }

    @Override
    public Object ObtenerDatos() {
        String consulta = "SELECT inv.id as IDINVENTARIO, ele.codigo_elemento as CODELEMENTO, ele.id as IDELEMENTO, \n"+
                            "ele.descripcion as DESCELEMENTO, inv.entradas as ENTRADAS, inv.salidas as SALIDAS, inv.stock as STOCK\n" +
                            "FROM elementos AS ele INNER JOIN inventario AS inv ON ele.Id = inv.id_elemento\n" +
                            "ORDER BY ele.descripcion;";
        
        List<Map<String, String>> inventarios = new ArrayList<Map<String, String>>();
        inventarios = mySQL.ListSQL(consulta);
        ArrayList<ModeloInventario> listaModeloInventario = new ArrayList<>();
        if (inventarios.size() > 0) {

            for (Map<String, String> inventario : inventarios) {
                listaModeloInventario.add(new ModeloInventario(
                        inventario.get("IDINVENTARIO"),
                        inventario.get("CODELEMENTO"),
                        inventario.get("IDELEMENTO"),
                        inventario.get("DESCELEMENTO"),
                        inventario.get("ENTRADAS"),
                        inventario.get("SALIDAS"),
                        inventario.get("STOCK")
                ));
            }
            return listaModeloInventario;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Object ObtenerDatosKey(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Guardar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void ActualizarInventario(int opc, String idElemento, String cantidad, int InsertElemento) {
        ArrayList<String> consultas = new ArrayList<>();
        
        if(opc == 0){//ACTUALIZAR ENTRADAS
            if(InsertElemento == 0){//INSERT
                consultas.add(
                //<editor-fold defaultstate="collapsed" desc="INSERT">
                    "INSERT INTO inventario \n" +
                        "(id, id_elemento, entradas, salidas, stock)\n" +
                        "VALUES\n" +
                        "(0, "+idElemento+","+cantidad+", 0,"+cantidad+");"
                //</editor-fold>
                 );
            }else{// ACTUALIZAR
                consultas.add(
                //<editor-fold defaultstate="collapsed" desc="UPDATE ENTRADAS">
                    "UPDATE `inventario`\n" +
                        "SET `entradas` = (entradas+"+cantidad+"),\n" +
                        "  `stock` = (stock+"+cantidad+") \n" +
                        "WHERE `id_elemento` = "+idElemento+";"
                //</editor-fold>
                 );
            }
        }else{ // ACTUALIZAR SALIDAS
            consultas.add(
                //<editor-fold defaultstate="collapsed" desc="UPDATE SALIDAS">
                    "UPDATE `inventario`\n" +
                        "SET `entradas` = (salidas+"+cantidad+"),\n" +
                        "  `stock` = (stock-"+cantidad+") \n" +
                        "WHERE `id_elemento` = "+idElemento+";"
                //</editor-fold>
                 );
        }
        

        try {
            if(mySQL.EnviarConsultas(consultas)){
               
               
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
        }
    }
}
