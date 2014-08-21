
package Logica;

import conexion.*;

//@author Francis

//Controlador de Usuario
public class CtrlUsuario {
    buscar bu=new buscar();
    guardar gu=new guardar();
    //Verificar que no exista el nick
    public boolean existenick(String nick){
 return bu.existeNick(nick);
     }
     public boolean existemail(String mai){
 return bu.existeEmail(mai);
     }
     
    public void guardarProvedor(Proveedor pro){
    gu.guardarProvedor(pro);
    }
    
    public void guardarCliente(Cliente cli){
    gu.guardarCliente(cli);
    }
    
}
