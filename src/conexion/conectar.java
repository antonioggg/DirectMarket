
package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class conectar {
    
   public ResultSet resultado;
   public Statement sentencia;
   public Connection conexion;
   
    public void conectarBase(){
        try {
            Class.forName("org.sqlite.JDBC");
            conexion=DriverManager.getConnection("jdbc:sqlite:C:/Documents and Settings/Admin/Mis documentos/NetBeansProjects/directmarket.db");
            sentencia=conexion.createStatement();
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error carga de driver");
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error creacion de statement");
        }
       
    }
     public void desconectarBaseDeDatos(){
        //metodo de desconexion
        try{
            if(conexion !=null){
                if (sentencia !=null){
                    //si la conexion devuelve valores nulos
                    sentencia.close();
                }
                conexion.close();
            }
        }
        catch (SQLException ex){ 
        }
    }
     
     
     

}