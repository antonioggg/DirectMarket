
package Logica;

//@author Francis

public class OrdenDeCompra {
    
    //Atributos
    private double preciototal;
    private Integer numero;
    private DataFecha fecha;
    
    
     //Funciones 
    public OrdenDeCompra(){
        preciototal = new Double(null);
        numero = new Integer(0); 
        fecha = new DataFecha();       
    }
    
    public void setOrdenDeCompra(double pt,int n, DataFecha f){
        preciototal = pt;
        numero = n;
        fecha = f;   
 }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public DataFecha getFecha() {
        return fecha;
    }

    public void setFecha(DataFecha fecha) {
        this.fecha = fecha;
    }
    
}
