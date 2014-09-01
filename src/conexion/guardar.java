
package conexion;

import Logica.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

 
    public void altacompra(LinkedList<Object> compras, String clinick, Double preciototal) {
        // Funcion para Guardar la Compra
        
        bd.conectarBase();
        //Obtiene la hora del sistema
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        String hour = hourFormat.format(new Date());
        //Obtiene la fecha del sistema
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	String date = sdf.format(new Date()); 
        sql="INSERT INTO ordencompra (fechacompra, preciototal, cliente, hora) VALUES ('"+date+"','"+preciototal+"','"+clinick+"','"+hour+"')";
        //sql="INSERT INTO ordencompra (fechacompra, preciototal, cliente, hora) VALUES ('05/05/2014','874.2','nick', 'null')";
        try {
            bd.sentencia.execute(sql);
            System.out.println("Orden de compra creada");
        } catch (SQLException ex) {
            Logger.getLogger(guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        //busacar el id del ultimo registro de la tabla ordencompra 
        String sql2 = "SELECT max(numero) as idc From ordencompra";
        int idordencompra=0;
        try {
            bd.resultado=bd.sentencia.executeQuery(sql2);
            idordencompra = Integer.parseInt(bd.resultado.getString("idc"));
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

    public void altacat(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
