
package Logica;

//@author Francis

public class Productos {
    
    //Atributos
    private String nombre;
    private String provedor;
    private String referencia;
    private double precio;

    public Productos(String nombre, String provedor, String referencia, double precio) {
        this.nombre = nombre;
        this.provedor = provedor;
        this.referencia = referencia;
        this.precio = precio;
    }

    public Productos() {
        this.nombre = "";
        this.provedor = "";
        this.referencia = "";
        this.precio = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    


}
