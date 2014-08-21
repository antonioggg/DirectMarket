
package Logica;

import java.util.Calendar;

//@author Francis
 
public class DataFecha {
    
    public class fecha {
    public Integer getedad(String dn){
        String sCadena = dn;
        int anio = Integer.valueOf(sCadena.substring(0,4));
        int mes = Integer.valueOf(sCadena.substring(5,7));
        int dia = Integer.valueOf(sCadena.substring(7,9));
       
        Calendar c1 = Calendar.getInstance();
        int diaactual = (c1.get(Calendar.DATE));
        int mesactual = (c1.get(Calendar.MONTH));
        int anioactual = (c1.get(Calendar.YEAR));
        
        int edad = anioactual-anio;
        if (mesactual>mes){
            edad=edad+1;
        }else{
            if (mesactual==mes){
                if (diaactual>dia){
                    edad=edad+1;
                }
            }
        }
        return edad;
    }
    public String getfechaactual(){
        Calendar c1 = Calendar.getInstance();
        int diaactual = (c1.get(Calendar.DATE));
        int mesactual = (c1.get(Calendar.MONTH));
        int anioactual = (c1.get(Calendar.YEAR));
        String dia = String.valueOf(diaactual);
        String mes = String.valueOf(mesactual);
        String anio = String.valueOf(anioactual);
        String fn = anio +"-"+ mes +"-"+ dia;
        return fn;
        
    }
    
  }
    
    
}
    
