
package conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class borrar {
    conexion.conectar bd=new conexion.conectar();
    String sql="";
    
    //borrar ordenes de compra
    public void borrarOrdenesCompra(int b){
    bd.conectarBase();
    sql="DELETE FROM `ordencompra` WHERE numero = "+b+" ";
        try {
          bd.sentencia.execute(sql);    
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    //borrar compras
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
