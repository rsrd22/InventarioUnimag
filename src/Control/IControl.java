/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

/**
 *
 * @author MERRY
 */
public interface IControl {
    public Object ObtenerDatos();
    
    public Object ObtenerDatosKey(String ID);

    public int Guardar(Object o);

    public int Actualizar(Object o);

    public int Eliminar(Object o);
    
    public Object ObtenerDatosFiltro(Object o);
}
