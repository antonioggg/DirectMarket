
package Logica;

//@author Francis

public class Compra {
    
    //Atributos
    private Integer cantidad;
    
     //Funciones 
    public Compra(){
        cantidad = new Integer(0);  
        
    }
    public void setCompra(int c){
        cantidad = c;
    }
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
