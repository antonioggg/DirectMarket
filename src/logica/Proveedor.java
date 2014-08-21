package Logica;

//@author Francis

public class Proveedor extends Usuario {
   private String nombre_cia;
   private String link;
    
    public Proveedor(){
        nick=null;
        nombre=null;
        apellido=null;  
        fechanac=null;
        imagen=null;
        email=null;
        nombre_cia =null;
        link= null;
         tipo=null;
    
               
     
     }
    public Proveedor(String ni,String n,String ap,String fec,String ima,String ti,String e, String nc, String li){
        nick=ni;
        nombre=n;
        apellido=ap;
        fechanac=fec;
        imagen=ima;
        tipo=ti;
        email=e;
        nombre_cia =nc;
        link=li;
        
   
     
     }
     
    public void setDatos(String ni,String n,String ap,String fec,String ima,String ti,String e, String nc, String li){
        nick=ni;
        nombre=n;
        apellido=ap;
        fechanac=fec;
        imagen=ima;
        tipo=ti;
        email=e;
        nombre_cia =nc;
        link=li; 
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

    public String getNombre_cia() {
        return nombre_cia;
    }

    public void setNombre_cia(String nombre_cia) {
        this.nombre_cia = nombre_cia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
    
