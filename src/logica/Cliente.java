package Logica;

//@author Francis

public class Cliente extends Usuario {
    
    public Cliente(){
        nick=null;
        nombre=null;
        apellido=null;        
        email=null;
        tipo=null;
        fechanac=null;
        imagen=null;
               
     
     }
    public Cliente(String ni,String n,String ap,String fec,String ima,String ti,String e){
        nick=ni;
        nombre=n;
        apellido=ap;
        fechanac=fec;
        imagen=ima;
        tipo=ti;
        email=e;
         
    
    
     
     }
     
    public void setDatos(String ni,String n,String ap,String fec,String ima,String ti,String e){
        nick=ni;
        nombre=n;
        apellido=ap;
        fechanac=fec;
        imagen=ima;
        tipo=ti;
        email=e;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String ap) {
       apellido = ap;
    }

    public String getE_mail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String img) {
        imagen = img;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String ni) {
        nick = ni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
       
}
    