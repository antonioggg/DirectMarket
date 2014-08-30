/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;
import Logica.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pico
 */
public class buscar {
    conexion.conectar bd=new conexion.conectar();
    String sql="";
    
    public ResultSet mostrarOrdenesCompra(){
    bd.conectarBase();
    sql="SELECT * FROM ordencompra";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    return bd.resultado;
    }
    
    
    public ResultSet mostrarCompras(int com){
    bd.conectarBase();
    sql="SELECT * FROM compras WHERE idorden="+com+"";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    return bd.resultado;
    }
    
    
    
    
     public Productos mostrarPrecioUnitario(String prod){
          Productos pro =new Productos();
        bd.conectarBase();
        sql="SELECT * FROM Productos WHERE referencia='"+prod+"'";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
           while(bd.resultado.next()){
               pro.setNombre(bd.resultado.getString("Nombre"));
               pro.setPrecio(bd.resultado.getDouble("precio"));
               pro.setProvedor(bd.resultado.getString("Proveedor"));
               pro.setReferencia(bd.resultado.getString("referencia"));
           }
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
    return pro;
    }
      
      public boolean existeNick(String nic){
      boolean si=false;
      bd.conectarBase();
      sql="SELECT * FROM usuarios   WHERE nick='"+nic+"'";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            while(bd.resultado.next()){
               String ni=bd.resultado.getString("nick");
            if(ni.equals(nic)){
            si=true;
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
      return si;
      }
      
       public boolean existeEmail(String mail){
           String ni="";
      boolean si=false;
      bd.conectarBase();
      sql="SELECT * FROM usuarios   WHERE nick='"+mail+"'";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            while(bd.resultado.next()){
                ni=bd.resultado.getString("email");
            if(ni.equals(mail)){
            si=true;
            }
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
      return si;
      }

    public boolean findCat(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
 public ArrayList<CatPadre> categoriaPadre(){
           
           bd.conectarBase();
           ArrayList<CatPadre> cate = new ArrayList<CatPadre>();
          sql="SELECT * FROM categoria WHERE padre=''";
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            while(bd.resultado.next()){
           CatPadre cat=new CatPadre();
           cat.setNombre(bd.resultado.getString("nombre"));
           System.out.print(bd.resultado.getString("nombre"));
           cate.add(cat);
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         return cate; 
       }
       
        public ArrayList<CatHija> categoriasHijas(String pad){
           ArrayList<CatHija> categ = new ArrayList<CatHija>();
          bd.conectarBase();
          sql="SELECT * FROM categoria WHERE padre='"+pad+"'"; 
        try {
            bd.resultado=bd.sentencia.executeQuery(sql);
            while(bd.resultado.next()){
           CatHija cat=new CatHija();
           cat.setNombre(bd.resultado.getString("nombre"));
           categ.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         return categ;  
       }
      
  //muestras los productos de una determinada categoria
        public ArrayList ProductosPorCategoria(String nombre) throws SQLException{
            bd.conectarBase();
            sql = "SELECT Productos.nombre FROM Productos, categoriaproducto WHERE categoriaproducto.refproducto = Productos.referencia AND categoriaproducto.idcategoria = '" +nombre+ "'";
            ArrayList lista = new ArrayList();
            
             
            try {
        bd.resultado=bd.sentencia.executeQuery(sql);
//        JOptionPane.showMessageDialog(null, "Llego hasta aca 1"+bd.resultado.getObject(1).toString());
               while(bd.resultado.next()){
               lista.add(bd.resultado.getString("nombre")); 
               
               
               } 
               
              
               
                } catch (SQLException ex) {
                Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, ex);
                }
        return lista;  
    }  
}
