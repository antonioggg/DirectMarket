
package conexion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logica.*;

public class guardar {
    
    conexion.conectar bd=new conexion.conectar();
    String sql;
    
    //guardar cliente
    public void guardarCliente(Cliente per){
    bd.conectarBase();
    sql="INSERT INTO usuarios (nick,nombre,apellido,fechanac,imagen,tipo,email) VALUES ('"+per.getNick()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getFechanac()+"','"+per.getImagen()+"','"+per.getTipo()+"','"+per.getE_mail()+"')";
        try {
            bd.sentencia.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
   } 
    
    //guardar proveedor
    public void guardarProvedor(Proveedor per){
    bd.conectarBase();
    sql="INSERT INTO usuarios (nick,nombre,apellido,fechanac,imagen,tipo,email,nomcompania,linkcompania) VALUES ('"+per.getNick()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getFechanac()+"','"+per.getImagen()+"','"+per.getTipo()+"','"+per.getE_mail()+"','"+per.getNombre_cia()+"','"+per.getLink()+"')";
        try {
            bd.sentencia.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.desconectarBaseDeDatos();
   }

    //alta categoria
    public void altacat(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
