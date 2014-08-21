
package Logica;

//@author Francis
  
public class EspecificacionProd {
    
    //Atributos
    private String nombre;
    private String descripcion;
    private Integer id_ref;
    private Integer cantidad;
    
    //Funciones
     public EspecificacionProd(){
        nombre = new String();
        descripcion = new String();
        id_ref = new Integer(null);
        cantidad = new Integer(null);        
    }
    
     public void setEspecificacionProd(String n, String d, int i, int c){
        nombre = n;
        descripcion = d;
        id_ref = i; 
        cantidad = c;
        
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_ref() {
        return id_ref;
    }

    public void setId_ref(Integer id_ref) {
        this.id_ref = id_ref;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
