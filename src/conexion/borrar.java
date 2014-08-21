/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pico
 */
public class borrar {
     conexion.conectar bd=new conexion.conectar();
    String sql="";
    public void borrarOrdenesCompra(int b){
    bd.conectarBase();
    sql="DELETE FROM `ordencompra` WHERE numero = "+b+" ";
        try {
          bd.sentencia.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void borrarCompras(int b){
    bd.conectarBase();
    sql="DELETE FROM `compras` WHERE idorden = "+b+" ";
        try {
          bd.sentencia.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}
