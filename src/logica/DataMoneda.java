
package Logica;

//@author Francis

public class DataMoneda {
    
    //Atributos
    private double valor;
    private String moneda; 
    //Operaciones 
    public DataMoneda(){
        valor = 0;
        moneda = " ";
    }
    public void setMoneda(double v,String m){
        valor = v;
        moneda = m;
    }
    public DataMoneda getMoneda(){
        return this;
    }
    public double getvalor(){
        return valor;
        
    }
    public String getmoneda(){
        return moneda;
    }
          
     

    public void setMoney(String text, String $) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        return(String.valueOf(valor));
    }
    
}
