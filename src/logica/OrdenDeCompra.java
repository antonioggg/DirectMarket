
package Logica;

//@author Francis

public class OrdenDeCompra {

    public OrdenDeCompra() {
      
    }

    public OrdenDeCompra(Integer numero) {
        this.numero = numero;
    }
    
    
    //Atributos
    private double preciototal;
    private Integer numero;
    private DataFecha fecha;

    public OrdenDeCompra(double preciototal, Integer numero, DataFecha fecha) {
        this.preciototal = preciototal;
        this.numero = numero;
        this.fecha = fecha;
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
