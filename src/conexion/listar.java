/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import Logica.Cliente;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class listar {

    public LinkedList<Cliente> getCliente() {
        
        LinkedList<Cliente> listaClientes=new LinkedList<>();
        conexion.conectar bd=new conexion.conectar();
        String sql="";
        bd.conectarBase();
        sql="SELECT * FROM usuarios";
        try (ResultSet rs = bd.sentencia.executeQuery(sql)){
           
                while (rs.next()) {
                    Cliente cli = new Cliente();
                    cli.setDatos(rs.getString("nick"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("fechanac"), rs.getString("imagen"), rs.getString("tipo"), rs.getString("email"));
                    listaClientes.add(cli);
                }
         
            bd.desconectarBaseDeDatos();
        }
        catch (Exception e){
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaClientes;
    }
    
}
