
package Logica;

//@author Francis

public class Compra {
    
    //Atributos
    private Integer cantidad;
    private String refprod;

    public Compra(Integer cantidad, String refprod) {
        this.cantidad = cantidad;
        this.refprod = refprod;
    }

    public String getRefprod() {
        return refprod;
    }

    public void setRefprod(String refprod) {
        this.refprod = refprod;
    }
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
