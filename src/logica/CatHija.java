package Logica;

 public class CatHija extends Categoria {
    
    private String padre;
    
    public CatHija (String nombre, String padre) {
        
        this.nombre = nombre;
        this.padre = padre;
} 
    public CatHija () {
        
        this.nombre = null;
        this.padre = null;
    }
    
    public String getNombre() {
        return nombre;        
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPadre() {
        return padre;
    }
    
    public void setPadre (String padre) {
        this.padre = padre;
    }

    @Override
    public String toString() {
        return nombre;
    }
  
}
 