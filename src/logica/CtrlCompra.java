
package Logica;

//@author Francis

import conexion.*;
import java.sql.ResultSet;


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
    
    
}
