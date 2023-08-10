/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bd;

import java.sql.ResultSet;
import modelo.Finca;
import modelo.Persona;
import modelo.Recibo;
import modelo.Servicio;
//import org.junit.Test;
//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author maite
 */
public class CN_GetDataTest {
    
    public CN_GetDataTest() {
    }

 
  

 
  

    @Test
    public void testDeletePropietario() {
        System.out.println("DeletePropietario");
        int id = 0;
        CN_GetData instance = new CN_GetData();
        instance.DeletePropietario(id);
        
    }





  

    @Test
    public void testIniciarSesion() {
        System.out.println("IniciarSesion");
        String cedula = "";
        String contrasenia = "";
        CN_GetData instance = new CN_GetData();
        ResultSet expResult = null;
        ResultSet result = instance.IniciarSesion(cedula, contrasenia);
        assertNotEquals(expResult, result);
        
    }

 

    @Test
    public void testDeleteFinca() {
        System.out.println("DeleteFinca");
        int id = 0;
        CN_GetData instance = new CN_GetData();
        instance.DeleteFinca(id);
        
    }

   

    @Test
    public void testGetServicios() {
        System.out.println("GetServicios");
        CN_GetData instance = new CN_GetData();
        ResultSet expResult = null;
        ResultSet result = instance.GetServicios();
        assertNotEquals(expResult, result);
        
    }

   

    @Test
    public void testDeleteServicio() {
        System.out.println("DeleteServicio");
        int id = 0;
        CN_GetData instance = new CN_GetData();
        instance.DeleteServicio(id);
        
    }

   

    @Test
    public void testDeleteRecibo() {
        System.out.println("DeleteRecibo");
        int id = 0;
        CN_GetData instance = new CN_GetData();
        instance.DeleteRecibo(id);
        
    }

 
    
}
