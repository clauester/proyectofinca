/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;



/**
 *
 * @author Miguel Davila
 */
public class DatosIncompletosException extends NullPointerException{
    
     public  DatosIncompletosException (){
        super();
    }
     public  DatosIncompletosException (String mensaje){
        super(mensaje);
        
    }
}
