
package Logica;

//@author Francis

import conexion.*;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;


public class CtrlCompra {
    borrar bo=new borrar();
    buscar bu=new buscar();
    guardar ctrlgu=new guardar();
    
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

    public ResultSet mostrarcompras(int com) {
        
        return bu.mostrarCompras(com);
    }

    public Productos mostrarPrecioUnitario(String produc) {
       return bu.mostrarPrecioUnitario(produc);
    }



    public void guardarcompras(LinkedList<Object> compras, String value) {
        Double preciototal=0.0;
        LinkedList<Compra> com = new LinkedList(compras);
        for (int i=0;i<compras.size();i++) {
            int cant = com.get(i).getCantidad();
            //Obtiene cantidad
            Double precio = bu.getprecioxprod(com.get(i).getRefprod());
            Double subtotal = precio * cant;
            preciototal = preciototal + subtotal;
        }
        ctrlgu.altacompra(compras, value, preciototal);
        
    }
    
}
