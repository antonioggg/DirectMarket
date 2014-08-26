package Logica;

final public class CatPadre extends Categoria {
    
    public CatPadre (String nombre) {
        this.nombre = nombre;
    }
    
    public CatPadre () {
        
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }  
}

