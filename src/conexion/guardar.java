
package conexion;

import Logica.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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

   

    public void altacompra(LinkedList<Object> compras, String clinick, Double preciototal) {
        // Funcion para Guardar la Compra
        bd.conectarBase();
        //Obtiene la hora del sistema
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        //Obtiene la fecha del sistema
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sql="INSERT INTO ordencompra (fechacompra, preciototal, cliente, hora) VALUES ('"+dateFormat+"','"+preciototal+"','"+clinick+"','"+hourFormat+"')";
        try {
            bd.sentencia.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        //busacar el id del ultimo registro de la tabla ordencompra 
        String sql2 = "SELECT MAX(numero) FROM ordencompra";
        int idordencompra=0;
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            idordencompra =bd.resultado.getInt("numero");
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        LinkedList<Compra> com = new LinkedList(compras);
        for (int i=0;i<compras.size();i++) {
     
            String sql3 = "INSERT INTO compras (idorden, producto, cantidad) Values ('"+idordencompra+"', '"+com.get(i).getRefprod()+"','"+com.get(i).getCantidad()+"' )";
            try {
                bd.sentencia.execute(sql3);
            } catch (SQLException ex) {
                Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bd.desconectarBaseDeDatos();
    }
    
    
}
