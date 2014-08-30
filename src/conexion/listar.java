
package conexion;

import Logica.Cliente;
import Logica.OrdenDeCompra;
import Logica.Proveedor;
import Logica.*;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public LinkedList<OrdenDeCompra> getCompras(String nick) {
        
        LinkedList<OrdenDeCompra> listaCompras =new LinkedList<>();
        conexion.conectar bd=new conexion.conectar();
        String sql="";
        bd.conectarBase();
        sql="SELECT * FROM ordencompra WHERE cliente='"+nick+"'";
        try (ResultSet rs = bd.sentencia.executeQuery(sql)){
           
                while (rs.next()) {
                    
                    Integer numero = rs.getInt("numero");
                    System.out.print(numero);
                    OrdenDeCompra comp = new OrdenDeCompra(numero);
                    
                    listaCompras.add(comp);
                }
         
            bd.desconectarBaseDeDatos();
        }
        catch (Exception e){
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaCompras;
    }

    public LinkedList<Proveedor> getProveedor() {
        LinkedList<Proveedor> listaProveedores = new LinkedList<>();
        conexion.conectar bd=new conexion.conectar();
        
        bd.conectarBase();
        String sql="SELECT * FROM usuarios where tipo ='proveedor'";
        try (ResultSet rs = bd.sentencia.executeQuery(sql)){
           
                while (rs.next()) {
                    Proveedor prov = new Proveedor();
                    prov.setDatos(rs.getString("nick"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("fechanac"), rs.getString("imagen"), rs.getString("tipo"), rs.getString("email"),rs.getString("nomcompania"), rs.getString("linkcompania"));
                    
                    listaProveedores.add(prov);
                }
         
            bd.desconectarBaseDeDatos();
        }
        catch (Exception e){
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaProveedores;
    }
    
    public LinkedList<Productos> getListaProductosCat(String nombre) {
        LinkedList<Productos> listaProductoCat = new LinkedList<>();
        conexion.conectar bd=new conexion.conectar();
        bd.conectarBase();
        String sql="SELECT Productos.nombre FROM Productos, categoriaproducto WHERE categoriaproducto.refproducto = Productos.referencia AND categoriaproducto.idcategoria = '" +nombre+ "'";
        try (ResultSet rs = bd.sentencia.executeQuery(sql)){
                while (rs.next()) {
                    Productos prod = new Productos();
                    prod.setNombre(rs.getString("nombre"));
                    listaProductoCat.add(prod);
                }
            bd.desconectarBaseDeDatos();
        }
        catch (Exception e){
            Logger.getLogger(buscar.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaProductoCat;
    }
    
}
