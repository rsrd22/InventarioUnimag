/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MERRY
 */
public class Consultas {

    public static Map<String, String> consultas = new HashMap<String, String>();

    /**
     * Consultas<br>
     * AA__BB__CC<br>
     * AA= NOMBRE EN COLUMNA<br>
     * BB= TAMAÑO COLUMNA TABLA <br>
     * CC= ALINEACION CONTENIDO COLUMNA TABLA ("L", "C", "R")
     */
    public static void Agregar() {
        consultas.clear();
        
        consultas.put("BQD_ELEM", "SELECT Id as ID , descripcion as DESCRIPCION, codigo_elemento AS CODIGO, id_usuario, fecha\n" +
                                    "FROM elementos\n" +
                                    "ORDER BY descripcion ASC");


    }

}
