
package Logica;

//@author Francis

import conexion.*;
import java.sql.ResultSet;
import java.util.LinkedList;


public class CtrlCompra {
    borrar bo=new borrar();
    buscar bu=new buscar();
    
    public ResultSet mostrarOrdenesCompra(){
    return bu.mostrarOrdenesCompra();
    }
    
    public void borrarOrdenesCompra(int b){
    bo.borrarOrdenesCompra(b);
    }
    
    public void borrarCompras(int b){
    bo.borrarCompras(b);
    }



    public LinkedList<OrdenDeCompra>  listarOrdenesCompras(String nick) {
       listar lis = new listar();
       LinkedList<OrdenDeCompra> Compras = lis.getCompras(nick);
       System.out.print("Lista compras creada");
       return Compras;
       
    }
    
}
