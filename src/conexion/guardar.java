/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logica.*;

/**
 *
 * @author pico
 */
public class guardar {
    
    conexion.conectar bd=new conexion.conectar();
    String sql;
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

    public void altacat(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
