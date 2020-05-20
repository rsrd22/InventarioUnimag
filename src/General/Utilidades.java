/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package General;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author MERRY
 */
public class Utilidades {
    
    public static String TEXTO_SIN_NUMEROS = "\\d";
    public static String SeparadorBusqueda = "__";
    public static String SOLO_NUMEROS = "^[0-9]+$";
    public static String PACIENTES_AUXILIARES_OCASIONALES = "^[A|O]$";
    public static Double FACTOR_CONVERSION = 2.20462;
    
    public static void establecerColorDeFondo(JPanel panel, boolean estaEncimaDelPanel) {
        if (panel.isEnabled()) {
            if (estaEncimaDelPanel) {
                panel.setBackground(new Color(24, 122, 171));
            } else {
                panel.setBackground(new Color(22, 108, 151));
            }
        }
    }
    
    public static ArrayList<String> decodificarNombre(String nombre) {
        do {
            nombre = nombre.replace("  ", " ");
        } while (nombre.contains("  "));

        ArrayList<String> resultado = new ArrayList<>();
        String vn[] = nombre.split(" ");

        for (int i = 0; i < vn.length; i++) {
            if (vn[i].equalsIgnoreCase("de")) {
                if (vn[i + 1].equalsIgnoreCase("la") || vn[i + 1].equalsIgnoreCase("los")) {
                    resultado.add(vn[i] + " " + vn[i + 1] + " " + vn[i + 2]);
                    i += 2;
                } else {
                    resultado.add(vn[i] + " " + vn[i + 1]);
                    i += 1;
                }
            } else if (vn[i].equalsIgnoreCase("del")) {
                resultado.add(vn[i] + " " + vn[i + 1]);
                i += 1;
            } else {
                resultado.add(vn[i]);
            }
        }

        vn = null;
        return resultado;
    }

    public static String decodificarElemento(String dato) {
        try {

            dato = "" + dato + "";

            dato = dato.replace("_INTEa_", "¿");
            dato = dato.replace("_INTEc_", "?");

            dato = dato.replace("_at_", "á");
            dato = dato.replace("_et_", "é");
            dato = dato.replace("_it_", "í");
            dato = dato.replace("_ot_", "ó");
            dato = dato.replace("_ut_", "ú");
            dato = dato.replace("_At_", "Á");
            dato = dato.replace("_Et_", "É");
            dato = dato.replace("_It_", "Í");
            dato = dato.replace("_Ot_", "Ó");
            dato = dato.replace("_Ut_", "Ú");

            dato = dato.replace("Ã¡", "á");
            dato = dato.replace("Ã©", "é");
            dato = dato.replace("Ã­", "í");
            dato = dato.replace("Ã³", "ó");
            dato = dato.replace("Ãº", "ú");
            dato = dato.replace("Ã±", "ñ");
            dato = dato.replace("Ã?", "Ñ");

            dato = dato.replace("_enie_", "ñ");
            dato = dato.replace("_ENIE_", "Ñ");

            dato = dato.replace("&ntilde;", "ñ");
            dato = dato.replace("&Ntilde;", "Ñ");

            dato = dato.replace("Â", "");//espacios en blanco
            dato = dato.replace("_CD_", "\"");//COMILLAS DOBLES.."&quot;");//COMILLAS DOBLES..
            dato = dato.replace("_dx_", "<");//menorque..
            dato = dato.replace("_bx_", ">");//menorque..
            dato = dato.replace("_PT_", ":");//2 PUNTOS..
            dato = dato.replace("_M_", "+");//COMILLAS DOBLES..
            dato = dato.replace("_I_", "=");//IGUAL......
            dato = dato.replace("_BS_", "/");// BASESLAS
            dato = dato.replace("_CS_", "\"");//COMILLA SIMPLE...
            dato = dato.replace("_P_", "%");//PORCENTA.....
            //HTML = HTML.replace("_L_n", "<br/>");//ESLAS.....
            dato = dato.replace("_L_", "\\");//ESLAS.....
            dato = dato.replace("_A_", "&");//AMPERSAN.....Â
            dato = dato.replace("_Ord_", "°");//°    
            //System.out.println("html-->"+HTML);
//            dato = dato.replace("\\n", "<br/>");//° 
            //System.out.println("html2-->"+HTML);
            //HTML = HTML.replace("<br>", "\n");//°
            //HTML = HTML.replace("<br/>", "\n");//°
//            dato = dato.replace("<br>", "\n");//°
//            dato = dato.replace("<br/>", "\n");//° 
            //  alert(HTML);

        } catch (Exception e) {
            System.out.println("ERROR decodificarElemento()-->" + e.toString());
        }

        return dato;
    }

    public static String CodificarElemento(String dato) {
        try {

            dato = "" + dato + "";
            dato = dato.replace("Â", "");//espacios en blanco
            dato = dato.replace("Ã¡", "á");
            dato = dato.replace("Ã©", "é");
            dato = dato.replace("Ã­", "í");
            dato = dato.replace("Ã³", "ó");
            dato = dato.replace("Ãº", "ú");
            dato = dato.replace("Ã±", "ñ");
            dato = dato.replace("Ã?", "Ñ");

            dato = dato.replace("á", "_at_");
            dato = dato.replace("é", "_et_");
            dato = dato.replace("í", "_it_");
            dato = dato.replace("ó", "_ot_");
            dato = dato.replace("ú", "_ut_");

            dato = dato.replace("Á", "_At_");
            dato = dato.replace("É", "_Et_");
            dato = dato.replace("Í", "_It_");
            dato = dato.replace("Ó", "_Ot_");
            dato = dato.replace("Ú", "_Ut_");

            dato = dato.replace("¿", "_INTEa_");
            dato = dato.replace("?", "_INTEc_");

            dato = dato.replace("ñ", "_enie_");
            dato = dato.replace("Ñ", "_ENIE_");

            dato = dato.replace("\"", "_CD_");//COMILLAS DOBLES.."&quot;");//COMILLAS DOBLES..
            dato = dato.replace("<", "_dx_");//menorque..
            dato = dato.replace(">", "_bx_");//menorque..
            dato = dato.replace(":", "_PT_");//2 PUNTOS..
            dato = dato.replace("+", "_M_");//COMILLAS DOBLES..
            dato = dato.replace("=", "_I_");//IGUAL......
            dato = dato.replace("/", "_BS_");// BASESLAS
            dato = dato.replace("\"", "_CS_");//COMILLA SIMPLE...
            dato = dato.replace("%", "_P_");//PORCENTA.....
            //HTML = HTML.replace("_L_n", "<br/>");//ESLAS.....
            dato = dato.replace("\\", "_L_");//ESLAS.....
            dato = dato.replace("&", "_A_");//AMPERSAN.....Â
            dato = dato.replace("°", "_Ord_");//°   

            //  alert(HTML);
        } catch (Exception e) {
            System.out.println("ERROR decodificarElemento()-->" + e.toString());
        }

        return dato;
    }

}
