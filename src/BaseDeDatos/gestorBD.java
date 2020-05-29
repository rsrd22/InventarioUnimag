/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDeDatos;

import General.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author MERRY
 */
public class gestorBD {
    
    private static Connection con = null;
    private String BD;
    private String usuario;
    private String contrasena;
    public String mensaje;
    private String host;
    
    private static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static String url = "jdbc:ucanaccess://E:\\Proyectos\\BD\\inventarioLab.accdb";
    
    
    public gestorBD(){
        con = null;
        mensaje = "";
        
        BD = baseDeDatos.BD;
        usuario = baseDeDatos.USER;
        host = baseDeDatos.HOST;
        contrasena = baseDeDatos.PASSWORD; 
//        System.out.println("BD--"+BD);
//        System.out.println("usuario--"+usuario);
//        System.out.println("host--"+host);
//        System.out.println("contrasena--"+contrasena);
    }
    
    private boolean Conectar() {
        try {
            //url = "jdbc:ucanaccess://" + host + "\\" + BD;
            System.out.println("url-->"+url);
            Class.forName(driver); 
            
            con = DriverManager.getConnection(url);
            
            return true;
        } catch (ClassNotFoundException e) {

            mensaje = "Ocurrio un error al tratar de establecer conexión con el servidor.\n"
                    + "Verifique que el servidor se encuentra encendido y funcionando bien."
                    + "_____________________________________________________________________\n" + e.getMessage();

            return false;
        } catch (Exception ex) {
            System.out.println("ERROR CONECTAR -- "+ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<String[]> SELECT(String sentenciaSQL) {
        try {
//            System.out.println("SELECT -->" + sentenciaSQL);
            ResultSet contenedorQUERY = null;
            ArrayList<String[]> datosQUERY = new ArrayList<>();
            boolean existenDatos = false;

            if (!Conectar()) {
                JOptionPane.showMessageDialog(null, "ERROR EN EL SELECT "+mensaje);
            } else {
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
                Desconectar();
            }

            if (existenDatos) {
                return datosQUERY;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocurrio un error al tratar de obtener los datos\n"
                    + "______________________________________________________\n"
                    + "Detalles:\n" + ex.getMessage());
            Desconectar();
            return new ArrayList<>();
        }
    }
    
    public List<Map<String, String>> ListSQL(String sql) {
        List<Map<String, String>> lista = new ArrayList<Map<String, String>>();
        try {
            System.out.println("ListSQL -->" + sql);
            ResultSet contenedorQUERY = null;

            boolean existenDatos = false;

            if (!Conectar()) {
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                contenedorQUERY = st.executeQuery(sql);

                int numeroDeColumnas = contenedorQUERY.getMetaData().getColumnCount();

                while (contenedorQUERY.next()) {
                    ResultSetMetaData rsmd = (ResultSetMetaData) contenedorQUERY.getMetaData();
                    Map<String, String> obj = new LinkedHashMap<String, String>();

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        obj.put(rsmd.getColumnLabel(i), Utilidades.decodificarElemento(contenedorQUERY.getString(rsmd.getColumnLabel(i))));
                    }
                    lista.add(obj);

                }
                st.close();
                contenedorQUERY.close();
                Desconectar();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR ListSQL--->" + e.getMessage());
        }
        return lista;
    }

    public boolean EnviarConsultas(ArrayList consultas) throws ClassNotFoundException {
        String QuerySQL = null;

        try {
            if (!Conectar()) {
                JOptionPane.showMessageDialog(null, mensaje);
                return false;
            } else {
                if (con == null) {
                    return false;
                }

                if (consultas.size() < 1) {
                    mensaje = "No hay consultas en la cadena enviada.";
                    return false;
                }
                //System.out.println("con--->"+con);
                con.setAutoCommit(false);
                Statement st = con.createStatement();
                for (int x = 0; x < consultas.size(); x++) {
                    System.out.println("consultas.get(" + x + ")-->" + consultas.get(x) + "//////////////////////");
                    if (!consultas.get(x).equals("")) {
                        QuerySQL = consultas.get(x).toString();
                        //System.out.println("EnviarConsultas-("+x+")->"+QuerySQL);
                        if (st.executeUpdate(QuerySQL) <= 0) {
//                        if (st.execute(QuerySQL)) {
                            con.rollback();
                            con.setAutoCommit(true);
                            con.close();
                            return false;
                        }
                    }
                    //System.out.println("HOLA");
                }
                con.commit();
                con.setAutoCommit(true);
                Desconectar();
                return true;
            }

        } catch (Exception e) {
            Desconectar();
            e.printStackTrace();
            return false;
        }
    }
    
    public String getClaveEncryptada(String user, String clave) {
        Encryptar e = new Encryptar();
        System.out.println("user--->" + user + "-----clve-->" + clave);
        String r = "";

        r = user.substring(1, (user.length() < 5 ? user.length() : 5));
        while (r.length() < 5) {
            r += "0";
        }
        r = e.EncryptarClave(r + clave);
        return r;
    }

    public String unicoDato(String sentenciaSQL) {
        try {
            //System.out.println("SELECT -->"+sentenciaSQL);
            ResultSet contenedorQUERY = null;
            String resultConsulta = "";
            boolean existenDatos = false;

            if (!Conectar()) {
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                contenedorQUERY = st.executeQuery(sentenciaSQL);

                int numeroDeColumnas = contenedorQUERY.getMetaData().getColumnCount();

                if (contenedorQUERY.next()) {
                    existenDatos = true;

                    resultConsulta = contenedorQUERY.getString(1);

                }
                st.close();
                contenedorQUERY.close();
                Desconectar();
            }

            if (existenDatos) {
                return resultConsulta;
            } else {
                return null;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Ocurrio un error al tratar de obtener los datos\n"
                    + "______________________________________________________\n"
                    + "Detalles:\n" + ex.getMessage());
            Desconectar();
            return null;
        }
    }
    
    private boolean Desconectar() {
        try {
            if (!con.isClosed()) {
                con.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            String mensaje = "Error al tratar de cerrar la conexión.\n"
                    + "___________________________________________________________________\n" + ex.getMessage();
            return false;

        }
    }
    
    public static Connection ObtenerConexion(){
        try{
            if(con == null){
                Class.forName(driver);
                con = DriverManager.getConnection(url);
                JOptionPane.showMessageDialog(null, "Conexión correcta");
            }
        }catch(Exception e){
            e.printStackTrace();
            con = null;
        }
        return con;
    }
    
}
