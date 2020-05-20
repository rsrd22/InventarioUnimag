/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import General.Utilidades;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MERRY
 */
public class InventarioLabBiologia {

    static Connection con = null;
    static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    static String url = "jdbc:ucanaccess://E:\\Proyectos\\BD\\inventarioLab.accdb"; 
    
    public static Connection ObtenerConexion(){
        try{
            if(con == null){
                System.out.println("esta es la URL "+url);
                Class.forName(driver);
                con = DriverManager.getConnection(url);
                JOptionPane.showMessageDialog(null, "Conexion Establecida"+con);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error aca");
            con = null;
        }
        return con;
    }
    
    public static ArrayList<String[]> SELECT(Connection con, String sentenciaSQL) {
        try {
//            System.out.println("SELECT -->" + sentenciaSQL);
            ResultSet contenedorQUERY = null;
            ArrayList<String[]> datosQUERY = new ArrayList<>();
            boolean existenDatos = false;

//            if (!Conectar()) {
//                JOptionPane.showMessageDialog(null, "ERROR EN EL SELECT "+mensaje);
//            } else {
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                contenedorQUERY = st.executeQuery(sentenciaSQL);

                int numeroDeColumnas = contenedorQUERY.getMetaData().getColumnCount();

                while (contenedorQUERY.next()) {
                    existenDatos = true;
                    String filaConsulta[] = new String[numeroDeColumnas];
                    for (int i = 0; i < numeroDeColumnas; i++) {
                        //System.out.println("contenedorQUERY.getString("+i+" + 1)-->"+contenedorQUERY.getString(i + 1));
                        filaConsulta[i] = Utilidades.decodificarElemento(contenedorQUERY.getString(i + 1));
                    }

                    datosQUERY.add(filaConsulta);
                }
                st.close();
                contenedorQUERY.close();
//                Desconectar();
//            }

            if (existenDatos) {
                return datosQUERY;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocurrio un error al tratar de obtener los datos\n"
                    + "______________________________________________________\n"
                    + "Detalles:\n" + ex.getMessage());
//            Desconectar();
            return new ArrayList<>();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Connection cn = ObtenerConexion();
            
            ArrayList<String[]> datos = SELECT(con, "Select * from Usuarios");
            
            System.out.println("*************"+datos.size()+"***************");
            if(datos.size()>0){
                for(String[] dat: datos){
                    for(String d: dat){
                        System.out.println("d---->"+d);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERROR DE MAIN");
        }
        
    }
    
}
