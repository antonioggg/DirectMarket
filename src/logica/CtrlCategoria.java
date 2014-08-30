
package Logica;

import conexion.buscar;
import conexion.guardar;
import conexion.listar;
import java.util.LinkedList;


//@author Francis

public class CtrlCategoria {
    
    public String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    private CtrlCategoria(){
        this.categoria = "";
    }
    
    private static CtrlCategoria instance = new CtrlCategoria();
    
    public static CtrlCategoria getInstance(){
        return instance;
    }
    
    public void altacategoria(String nom){
        Categoria cat;
        String hija="CatHija";
        if(nom.equals(hija)){
        cat = new CatHija();
        }
          
           cat = new CatHija();
          // cat.setTipo(nom);
           guardar gc= new guardar();
           gc.altacat(nom);
          
       
}
public boolean existeC(String nom){
        buscar cat= new buscar();
        return cat.findCat(nom);
     }
}

