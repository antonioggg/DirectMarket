
package Logica;

import conexion.buscar;
import conexion.conectar;
import conexion.guardar;
import conexion.listar;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//@author Francis
 
public class CtrlProductos {
    
   public ArrayList verProductosPorCategoria (String nombre){
      buscar bu = new buscar();
      ArrayList pro = new ArrayList();
       try {
           pro = (ArrayList)bu.ProductosPorCategoria(nombre);
       } catch (SQLException ex) {
           Logger.getLogger(CtrlProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
      Iterator it = pro.iterator();
       while (it.hasNext()) {
           String producto = (String)it.next();
          
       }
      return pro;
    } 
        
    
    
}
