/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import BaseDeDatos.baseDeDatos;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author RSRD
 */
public class ConfiguracionPropiedades {

    private static Properties propiedades;
    private static String SERVIDOR;
    private static String USUARIO;
    private static String CLAVE;
    private static String BASE_DE_DATOS;
    private static final String KEY_SERVIDOR = "servidor";
    private static final String KEY_USUARIO = "usuario";
    private static final String KEY_CLAVE = "clave";
    private static final String KEY_BASE_DE_DATOS = "baseDeDatos";

    public static void cargarConfiguracion() {
        propiedades = new Properties();
        try {
            String urlRelativa = "C:\\CONFIG INVENTARIO\\Config.properties";
            FileInputStream archivoConfig = new FileInputStream(urlRelativa);

            propiedades.load(archivoConfig);
            SERVIDOR = propiedades.getProperty(KEY_SERVIDOR);
            BASE_DE_DATOS = propiedades.getProperty(KEY_BASE_DE_DATOS);
            USUARIO = propiedades.getProperty(KEY_USUARIO);
            CLAVE = propiedades.getProperty(KEY_CLAVE);
            cargarPropiedades();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "El archivo de configuracion no se encuentra en la ruta esperada.\nDetalles:\n" + ioe.getMessage());
        }
    }

    public static String getBaseDeDatos() {
        return propiedades.getProperty(KEY_BASE_DE_DATOS);
    }

    public static void setBaseDeDatos(String valor) {
        propiedades.setProperty(KEY_BASE_DE_DATOS, valor);
    }

    public static String getUsuario() {
        return propiedades.getProperty(KEY_USUARIO);
    }

    public static void setUsuario(String valor) {
        propiedades.setProperty(KEY_USUARIO, valor);
    }

    public static String getServidor() {
        return propiedades.getProperty(KEY_SERVIDOR);
    }

    public static void setServidor(String valor) {
        propiedades.setProperty(KEY_SERVIDOR, valor);
    }

    public static String getClave() {
        return propiedades.getProperty(KEY_CLAVE);
    }

    public static void setClave(String valor) {
        propiedades.setProperty(KEY_CLAVE, valor);
    }

    private static void cargarPropiedades() {
        baseDeDatos.HOST = getServidor();
        baseDeDatos.USER = getUsuario();
        baseDeDatos.PASSWORD = getClave();
        baseDeDatos.BD = getBaseDeDatos();
    }
}
