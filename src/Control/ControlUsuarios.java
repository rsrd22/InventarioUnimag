/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import BaseDeDatos.gestorBD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MERRY
 */
public class ControlUsuarios {
    private gestorBD gbd;
    
    public ControlUsuarios(){
        gbd = new gestorBD();
    }
    
    //<editor-fold defaultstate="collapsed" desc="DATOS DE USUARIO">
    public List<Map<String, String>> getUsuarios(String idUsuario) {
        try{
            System.out.println("**************getUsuarios**************");
            String consulta = "SELECT us.id as ID_USUARIO, us.usuario as USUARIO, us.clave as CLAVE, IFNULL(empl.identificacion, '') IDENTIFICACION, IFNULL(empl.tipo_identificacion, '') TIDENTIFICACION,\n" +
                                "empl.primer_nombre AS PN, IFNULL(empl.segundo_nombre, '') SN, empl.primer_apellido AS PA, IFNULL(empl.segundo_apellido, '') SA,\n" +
                                "'' AS FNAC, '' AS SEXO, empl.correo AS CORREO, '' AS TELEFONOS, \n" +
                                "tbl.IDPERMISO AS IDPERMISO, perm.id_modulo AS IDMODULO, perm.s AS S, perm.i AS I, perm.u AS U, perm.d AS D, perm.v AS V,\n" +
                                "perp.id_propietario AS IDPROPIETARIO, CONCAT_WS(' ', prop.primer_nombre, IFNULL(prop.segundo_nombre, ''), prop.primer_apellido, IFNULL(prop.segundo_apellido, '')) PROPIETARIO\n" +
                                "FROM usuarios us \n" +
                                "INNER JOIN empleado empl ON empl.id = us.id_empleado\n" +
                                "LEFT JOIN (\n" +
                                "	SELECT usu.id, IF(peru.id IS NULL, perp.id, peru.id) IDPERMISO\n" +
                                "	FROM  usuarios usu\n" +
                                "	LEFT JOIN permisos peru ON peru.tipo = 'usuario' AND peru.valor_tipo = usu.id\n" +
                                "	LEFT JOIN permisos perp ON perp.tipo = 'perfil' AND perp.valor_tipo = usu.id_perfil\n" +
                                ") tbl ON tbl.id = us.id\n" +
                                "LEFT JOIN permisosxmodulos perm ON perm.id_permiso = tbl.IDPERMISO\n" +
                                "LEFT JOIN permisosxpropietarios perp ON perp.id_permiso = tbl.IDPERMISO\n" +
                                "LEFT JOIN propietario prop ON prop.id = perp.id_propietario\n" +
                                "WHERE us.id = '"+idUsuario+"'";
            
            consulta = "SELECT us.id AS ID_USUARIO, us.usuario AS USUARIO, us.clave AS CLAVE, IFNULL(empl.identificacion, '') IDENTIFICACION, IFNULL(empl.tipo_identificacion, '') TIDENTIFICACION,\n" +
                        "empl.primer_nombre AS PN, IFNULL(empl.segundo_nombre, '') SN, empl.primer_apellido AS PA, IFNULL(empl.segundo_apellido, '') SA,\n" +
                        "'' AS FNAC, '' AS SEXO, empl.correo AS CORREO, '' AS TELEFONOS /*, \n" +
                        "tbl.IDPERMISO AS IDPERMISO, perm.id_modulo AS IDMODULO, perm.s AS S, perm.i AS I, perm.u AS U, perm.d AS D, perm.v AS V,\n" +
                        "perp.id_propietario AS IDPROPIETARIO, \n" +
                        "CONCAT_WS(' ', prop.primer_nombre, IFNULL(prop.segundo_nombre, ''), prop.primer_apellido, IFNULL(prop.segundo_apellido, '')) PROPIETARIO*/\n" +
                        "FROM usuarios us \n" +
                        "INNER JOIN empleado empl ON empl.id = us.id_empleado\n" +
                        "/*LEFT JOIN (\n" +
                        "	SELECT usu.id, IF(peru.id IS NULL, perp.id, peru.id) IDPERMISO\n" +
                        "	FROM  usuarios usu\n" +
                        "	LEFT JOIN permisos peru ON peru.tipo = 'usuario' AND peru.valor_tipo = usu.id\n" +
                        "	LEFT JOIN permisos perp ON perp.tipo = 'perfil' AND perp.valor_tipo = usu.id_perfil\n" +
                        ") tbl ON tbl.id = us.id\n" +
                        "LEFT JOIN permisosxmodulos perm ON perm.id_permiso = tbl.IDPERMISO\n" +
                        "LEFT JOIN permisosxpropietarios perp ON perp.id_permiso = tbl.IDPERMISO\n" +
                        "LEFT JOIN propietario prop ON prop.id = perp.id_propietario*/\n" +
                        "WHERE us.id = '1'";
            
            
            consulta = "SELECT us.id as IDUSUARIO, us.usuario as USUARIO, perf.id as IDPERFIL, perf.descripcion as PERFIL\n" +
                        "FROM usuarios us \n" +
                        "INNER JOIN perfiles perf on perf.id = us.id_perfil\n" +
                        "WHERE US.ID = '"+idUsuario+"'";
            
            
            List<Map<String, String>> lista = gbd.ListSQL(consulta);
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    //</editor-fold>
}
