/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package General;

import java.awt.Color;
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
}
