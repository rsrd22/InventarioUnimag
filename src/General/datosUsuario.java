/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class datosUsuario {

    /**
     * datos[0]=ID USUARIO<BR>
     * datos[1]=NOMBRE DE USUARIO<BR>
     * datos[2]=ID PERFIL<BR>
     * datos[3]=PERFIL<BR>
     * datos[4]=NUMERO DE ID<BR>
     * datos[5]=TIPO DE ID<BR>
     * datos[6]=PRIMER NOMBRE<BR>
     * datos[7]=SEGUNDO NOMBRE<BR>
     * datos[8]=PRIMER APELLIDO<BR>
     * datos[9]=SEGUNDO APELLIDO<BR>
     * datos[10]=FECHA DE NACIMIENTO<BR>
     * datos[11]=SEXO<BR>
     * datos[12]=EMAIL<BR>
     * datos[13]=TELEFONO<BR>
     * datos[14]=CELULAR<BR>
     _____________________________
     * datos[13]=ID PERMISOS<BR>
     * datos[14]=ID MODULO(0,1,2,3)<BR>
     * datos[15]=ID INSERT(0,1)<BR>
     * datos[16]=ID UPDATE(0,1)<BR>
     * datos[17]=ID DELETE(0,1)<BR>
     * datos[18]=ID VISIBLE(0,1)<BR>
     * datos[19] = ID PROPIETARIOS<BR>
     * datos[20] = NOMBRE PROPIETARIOS
     * ________________________________
     */
    
    public static List<Map<String, String>> datos = new ArrayList<>();
    
    public static List<Map<String, String>> ModulosUsuario = new ArrayList<>();
    public static List<Map<String, String>> PropietariosUsuario = new ArrayList<>();
    public static List<Map<String, String>> Moduloscrud = new ArrayList<>();
    
}
